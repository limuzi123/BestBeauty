package com.lanou3g.mostbeauty.activity.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/2.
 */
//用户反馈
public class FeedbackActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageViewFeedBack;
    private TextView textViewSendFeed, textViewContact;

    @Override
    protected int getLayout() {
        return R.layout.feedback_activity;
    }

    @Override
    protected void initView() {
        imageViewFeedBack = (ImageView) findViewById(R.id.image_back_material);
        imageViewFeedBack.setOnClickListener(this);
        textViewSendFeed = (TextView) findViewById(R.id.text_send_feed);
        textViewSendFeed.setOnClickListener(this);
        textViewContact = (TextView) findViewById(R.id.text_view_contact);
        textViewContact.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back_material:
                finish();
                break;
            case R.id.text_send_feed:
                Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_view_contact:
                startActivity(new Intent(FeedbackActivity.this,PersonContactActivity.class));
                finish();
                break;
        }
    }


}
