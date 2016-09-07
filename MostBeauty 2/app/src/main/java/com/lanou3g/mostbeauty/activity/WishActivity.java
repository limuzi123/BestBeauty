package com.lanou3g.mostbeauty.activity;

import android.view.View;
import android.widget.ImageView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/2.
 */
//我的心愿单
public class WishActivity extends BaseActivity{
    private ImageView imageViewWish;
    @Override
    protected int getLayout() {
        return R.layout.activity_wish;
    }

    @Override
    protected void initView() {
     imageViewWish = (ImageView) findViewById(R.id.image_back_material);
    }

    @Override
    protected void initData() {
     imageViewWish.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });
    }
}
