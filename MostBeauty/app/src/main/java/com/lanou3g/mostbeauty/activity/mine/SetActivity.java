package com.lanou3g.mostbeauty.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/2.
 */
//设置页面
public class SetActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageViewSetBack;
    private RelativeLayout relativeLayoutFeedBack,relativeLayoutSetHead;

    @Override
    protected int getLayout() {
        return R.layout.set_activity;
    }

    @Override
    protected void initView() {
        relativeLayoutSetHead = (RelativeLayout) findViewById(R.id.relative_layout_set);
        relativeLayoutSetHead.setOnClickListener(this);
        imageViewSetBack = (ImageView) findViewById(R.id.image_back_material);
        imageViewSetBack.setOnClickListener(this);
        relativeLayoutFeedBack = (RelativeLayout) findViewById(R.id.relative_feedback);
        relativeLayoutFeedBack.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relative_layout_set:
                startActivity(new Intent(this,MaterialActivity.class));
                break;
            case R.id.image_back_material:
                finish();
                break;
            case R.id.relative_feedback:
                startActivity(new Intent(this,FeedbackActivity.class));
                break;
        }
    }
}
