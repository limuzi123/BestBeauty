package com.lanou3g.mostbeauty.activity.pictorial;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.lanou3g.mostbeauty.Bean.PictorialCommentActivityBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.activity.MainActivity;
import com.lanou3g.mostbeauty.activity.WelcomeActivity;
import com.lanou3g.mostbeauty.adapter.PictorialCommentActivityAdapter;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/9/2.
 */
public class PictorialCommentActivity extends BaseActivity implements OnClickListener{
    private ListView listView;
    private PictorialCommentActivityAdapter activityAdapter;
    private ImageView imgBack;
    private String strId;

    @Override
    protected int getLayout() {
        return R.layout.activity_pictoral_comment;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.list_view);
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        strId = intent.getStringExtra("id");
        int id = Integer.parseInt(strId);
        activityAdapter = new PictorialCommentActivityAdapter(this);
        NetTool.getInstance().startRequest(API.PICYOR_COMMENT_ACTIVITY_ONE + id + API.PICYOR_COMMENT_ACTIVITY_TWO, PictorialCommentActivityBean.class, new onHttpCallBack<PictorialCommentActivityBean>() {
            @Override
            public void onSuccess(PictorialCommentActivityBean response) {
                activityAdapter.setBean(response);
                listView.setAdapter(activityAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:


                finish();
                break;
        }
        overridePendingTransition(R.anim.exit_comment,R.anim.enter_comment);
    }


}
