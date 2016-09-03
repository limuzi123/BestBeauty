package com.lanou3g.mostbeauty.activity.mine;

import android.view.View;
import android.widget.ImageView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/3.
 */
public class AboutActivity extends BaseActivity{
    private ImageView imageViewAboutBack;
    @Override
    protected int getLayout() {
        return R.layout.about_activity;
    }

    @Override
    protected void initView() {
     imageViewAboutBack = (ImageView) findViewById(R.id.image_back_material);
    }

    @Override
    protected void initData() {
       imageViewAboutBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
    }
}
