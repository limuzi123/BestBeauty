package com.lanou3g.mostbeauty.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/2.
 */
//用户反馈
public class PersonContactActivity extends BaseActivity implements View.OnClickListener{
    private TextView textViewSurePerson;
    private ImageView imageViewBackPerson;
    @Override
    protected int getLayout() {
        return R.layout.activity_person;
    }

    @Override
    protected void initView() {
        textViewSurePerson = (TextView) findViewById(R.id.text_view_sure_person);
        imageViewBackPerson = (ImageView) findViewById(R.id.image_back_material);
        textViewSurePerson.setOnClickListener(this);
        imageViewBackPerson.setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_sure_person:
                startActivity(new Intent(PersonContactActivity.this,FeedbackActivity.class));
                finish();
                break;
            case R.id.image_back_material:
                finish();
                break;
        }
    }
}
