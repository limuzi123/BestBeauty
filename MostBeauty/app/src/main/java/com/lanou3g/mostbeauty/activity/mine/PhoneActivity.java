package com.lanou3g.mostbeauty.activity.mine;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/1.
 */
public class PhoneActivity extends BaseActivity implements View.OnClickListener {
    private TextView textViewSure, textViewSend;
    private EditText editTextPhone;
    private ImageView imageViewPhoneBack;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected int getLayout() {
        return R.layout.activity_phone;
    }

    @Override
    protected void initView() {
        textViewSure = (TextView) findViewById(R.id.text_view_sure);
        textViewSend = (TextView) findViewById(R.id.text_view_verification);
        imageViewPhoneBack = (ImageView) findViewById(R.id.image_back_material);
        imageViewPhoneBack.setOnClickListener(this);
        textViewSure.setOnClickListener(this);
        textViewSend.setOnClickListener(this);
        editTextPhone = (EditText) findViewById(R.id.edit_text_phone);
    }

    @Override
    protected void initData() {
//限制EditText的长度
        editTextPhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        setCode();
        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back_material:
                finish();
                break;
            case R.id.text_view_sure:
                startActivity(new Intent(this,MaterialActivity.class));
                finish();
                break;
        }
    }

    private void setCode() {
        editTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = editTextPhone.getText().toString().trim();
                if (string.length() == 11) {
                    textViewSend.setEnabled(true);
                    textViewSend.setTextColor(0xff00bc65);
                } else {
                    textViewSend.setEnabled(false);
                    textViewSend.setTextColor(0xff9f9f9f);
                }
                String strss = editTextPhone.getText().toString();
                editor.putString("Binbing", strss);
                editor.commit();
                Log.d("3333333333", strss);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}


