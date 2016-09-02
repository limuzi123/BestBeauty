package com.lanou3g.mostbeauty.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/2.
 */
public class SetActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageViewSetHead,imageViewSetBack;

    @Override
    protected int getLayout() {
        return R.layout.set_activity;
    }

    @Override
    protected void initView() {
        imageViewSetHead = (ImageView) findViewById(R.id.image_head_set);
        imageViewSetHead.setOnClickListener(this);
        imageViewSetBack = (ImageView) findViewById(R.id.image_back_material);
        imageViewSetBack.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_head_set:
                startActivity(new Intent(this,MaterialActivity.class));
                break;
            case R.id.image_back_material:
                finish();
                break;
        }
    }
}