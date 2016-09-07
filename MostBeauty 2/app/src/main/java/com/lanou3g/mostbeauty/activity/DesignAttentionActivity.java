package com.lanou3g.mostbeauty.activity;

import android.view.View;
import android.widget.ImageView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/2.
 */
//关注的设计师
public class DesignAttentionActivity extends BaseActivity{
    private ImageView imageViewDesignBack;
    @Override
    protected int getLayout() {
        return R.layout.activity_design;
    }

    @Override
    protected void initView() {
     imageViewDesignBack = (ImageView) findViewById(R.id.image_back_material);
    }

    @Override
    protected void initData() {
     imageViewDesignBack.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });
    }
}
