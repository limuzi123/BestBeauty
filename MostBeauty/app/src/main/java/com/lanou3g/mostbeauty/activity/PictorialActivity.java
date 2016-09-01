package com.lanou3g.mostbeauty.activity;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PictorialActivityBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.base.MyApp;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/8/31.
 */
public class PictorialActivity extends BaseActivity {
    private WebView webView;
    private TextView tvTitle,tvSmallTitle,tvName,tvAuthor,tvSmall,tvSmallOne,tvContent;

    private ImageView imgTitle,imgName,imgNameOne;

    @Override
    protected int getLayout() {
        return R.layout.activity_pictoral;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.web_view);
        tvSmallTitle = (TextView) findViewById(R.id.tv_small_title);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imgTitle = (ImageView) findViewById(R.id.img_title);
        tvAuthor = (TextView) findViewById(R.id.tv_antuor);
        tvName = (TextView) findViewById(R.id.tv_name);
        imgName = (ImageView) findViewById(R.id.img_anduor);
        tvSmall = (TextView) findViewById(R.id.tv_tiltle_small);
        tvSmallOne = (TextView) findViewById(R.id.tv_small);
        tvContent = (TextView) findViewById(R.id.tv_content);
        imgNameOne = (ImageView) findViewById(R.id.img_name_one);


    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("id");
        int id = Integer.parseInt(str);
        String img = intent.getStringExtra("img");
        Glide.with(this).load(img).into(imgTitle);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(API.PICTORIAL_ACTIVITY_WEBVIEW+ id +API.PICTORIAL_ACTIVITY_WEBVIEW_TWO);
        NetTool.getInstance().startRequest(API.PICTORIAL_ACTIVITY_ONE + id + API.PICTORIAL_ACTIVITY_TWO,
                PictorialActivityBean.class, new onHttpCallBack<PictorialActivityBean>() {
                    @Override
                    public void onSuccess(PictorialActivityBean response) {
                        tvTitle.setText(response.getData().getTitle());
                        tvSmallTitle.setText(response.getData().getSub_title());
                        tvName.setText(response.getData().getAuthor().getUsername());
                        tvAuthor.setText(response.getData().getAuthor().getSign());
                        Glide.with(PictorialActivity.this).load(response.getData().getAuthor().getAvatar_url()).bitmapTransform(new CropCircleTransformation(PictorialActivity.this)).into(imgName);


                        
                       tvSmall.setText(response.getData().getDesigners().get(0).getName());






                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


    }
}
