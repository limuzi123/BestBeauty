package com.lanou3g.mostbeauty.activity.pictorial;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.ReaderBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/7.
 */
public class ReaderActivity extends BaseActivity{
    private ImageView imgMy,imgBack;
    private TextView tvName,tvHow,tvHowTwo,tvHowThree;
    @Override
    protected int getLayout() {
        return R.layout.activity_reader;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgMy = (ImageView) findViewById(R.id.my_image_head);
        tvName = (TextView) findViewById(R.id.my_text_view_name);
        tvHow = (TextView) findViewById(R.id.tv_how);
        tvHowTwo = (TextView) findViewById(R.id.tv_how_two);
        tvHowThree = (TextView) findViewById(R.id.tv_how_three);
        imgBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("id");
        int id = Integer.parseInt(str);
        NetTool.getInstance().startRequest(API.READER_ACTIVITY_ONE +id+ API.READER_ACTIVITY_TWO, ReaderBean.class, new onHttpCallBack<ReaderBean>() {
            @Override
            public void onSuccess(ReaderBean response) {
                tvName.setText(response.getData().getUsername());
                if(response.getData().getLike_article_num()>0){
                    tvHow.setText(response.getData().getLike_article_num()+"");
                }else if(response.getData().getFollow_designer_num()>0){
                    tvHowTwo.setText(response.getData().getFollow_designer_num()+"");
                }
                Glide.with(ReaderActivity.this).load(response.getData().getAvatar_url()).bitmapTransform(new CropCircleTransformation(ReaderActivity.this)).into(imgMy);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
