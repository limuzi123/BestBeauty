package com.lanou3g.mostbeauty.activity.mine;

//**

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

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;


//填写联系方式
public class PersonContactActivity extends BaseActivity implements View.OnClickListener {
    private TextView textViewSurePerson;
    private ImageView imageViewBackPerson;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText editTextPerson;

    @Override
    protected int getLayout() {
        return R.layout.activity_person;
    }

    @Override
    protected void initView() {
        textViewSurePerson = (TextView) findViewById(R.id.text_view_sure_person);
        imageViewBackPerson = (ImageView) findViewById(R.id.image_back_material);

        editTextPerson = (EditText) findViewById(R.id.edit_text_person);

        textViewSurePerson.setOnClickListener(this);
        imageViewBackPerson.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        ContactPerson();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_sure_person:
                startActivity(new Intent(PersonContactActivity.this, FeedbackActivity.class));
                finish();
                break;
            case R.id.image_back_material:
                finish();
                break;
        }
    }


    private void ContactPerson() {
        editTextPerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String ss = editTextPerson.getText().toString();
                editor.putString("CONTACT", ss);
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
     protected void onStart () {
            super.onStart();
            sharedPreferences = getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
            String contact = sharedPreferences.getString("CONTACT", "");
            editTextPerson.setText(contact);

        }




    }
