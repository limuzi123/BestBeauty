package com.lanou3g.mostbeauty.activity.mine;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.mine.PhoneActivity;
import com.lanou3g.mostbeauty.base.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by dllo on 16/8/30.
 */
/*
编辑资料
 */
public class MaterialActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageViewBackMaterial,imageViewHead;
    private TextView textView,textViewBinbing;
    private TextView textViewMen, textViewWomen, textViewPrivary, textViewSex;
    private int mYear, mMoth, mDay;
    private PopupWindow mPop, popupWindow;
    private Button buttonPhoto,buttonWatch;//拍照,相册
    private Bitmap head;//头像Bitmap
    private static String path = "/sdcard/myHead";//sd卡路径

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText editTextNickName,editTextMailbox;
    @Override
    protected int getLayout() {
        return R.layout.material_activity;
    }

    @Override
    protected void initView() {
        imageViewBackMaterial = (ImageView) findViewById(R.id.image_back_material);
        textView = (TextView) findViewById(R.id.text_view_birthday);
        textViewSex = (TextView) findViewById(R.id.text_view_sex);
        textViewBinbing = (TextView) findViewById(R.id.text_view_binbing);
        textViewBinbing.setOnClickListener(this);
        imageViewHead = (ImageView) findViewById(R.id.image_head);
        editTextMailbox = (EditText) findViewById(R.id.edit_text_mailbox);
        editTextNickName = (EditText) findViewById(R.id.text_view_nickname);
        imageViewHead.setOnClickListener(this);
        textViewSex.setOnClickListener(this);
        textView.setOnClickListener(this);
        imageViewBackMaterial.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        //从sd中找头像,转换成Bitmap;
        Bitmap bitmap = BitmapFactory.decodeFile(path + "head.jpg");
        if (bitmap != null) {
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bitmap);//转换成drawable
            imageViewHead.setImageDrawable(drawable);
        }else {
            /**
             *  如果SD里面没有则需要从服务器取头像，取回来的头像再保存在SD中
             *
             */
        }
        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        showPopUp();
        choosePopUp();
        Storage();
    }

    public void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMoth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textView.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        editor.putString("BIRTHDAY",year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        editor.commit();
                    }
                }, mYear, mMoth, mDay);
        datePickerDialog.show();
    }

    private PopupWindow showPopUp() {
        mPop = new PopupWindow(this);
        View popView = LayoutInflater.from(this).inflate(R.layout.material_pop_layout, null);
        textViewMen = (TextView) popView.findViewById(R.id.text_view_men);
        textViewWomen = (TextView) popView.findViewById(R.id.text_view_women);
        textViewPrivary = (TextView) popView.findViewById(R.id.text_view_privary);
        textViewMen.setOnClickListener(this);
        textViewWomen.setOnClickListener(this);
        textViewPrivary.setOnClickListener(this);
        mPop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置点击外部是否消失
        mPop.setOutsideTouchable(true);
        //设置焦点
        mPop.setFocusable(true);
        mPop.setContentView(popView);
        mPop.setAnimationStyle(R.style.pop_anim);
        mPop.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        backgroundAlpha(1f);

        mPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);

            }
        });
        return mPop;
    }

    private PopupWindow choosePopUp(){
        popupWindow = new PopupWindow(this);
        View popupWindowView = LayoutInflater.from(this).inflate(R.layout.choose_head,null);
        buttonPhoto = (Button) popupWindowView.findViewById(R.id.btn_photos);
        buttonWatch = (Button) popupWindowView.findViewById(R.id.btn_takephoto);
        buttonPhoto.setOnClickListener(this);
        buttonWatch.setOnClickListener(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setContentView(popupWindowView);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        backgroundAlpha(1f);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        return popupWindow;
    }
    public void backgroundAlpha(float bgAlpha) {
        //设全屏
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha;
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(lp);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back_material:
                finish();
                Toast.makeText(this, "资料保存成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_view_birthday:
                showDatePickerDialog();
                  break;
            case R.id.text_view_sex:
                mPop.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                backgroundAlpha(0.7f);
                break;
            case R.id.text_view_men:
                textViewSex.setText("男");
                mPop.dismiss();
                break;
            case R.id.text_view_women:
                textViewSex.setText("女");
                mPop.dismiss();
                break;
            case R.id.text_view_privary:
                textViewSex.setText("保密");
                mPop.dismiss();
                break;
            case R.id.image_head:
                popupWindow.showAtLocation(v,Gravity.BOTTOM,0,0);
                backgroundAlpha(0.7f);
                break;
            case R.id.text_view_binbing:
                startActivity(new Intent(this,PhoneActivity.class));
                break;
            case R.id.btn_photos://从相册选取照片
                Intent intent = new Intent(Intent.ACTION_PICK,null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,1);
                popupWindow.dismiss();
                break;
            case R.id.btn_takephoto://调用相机照相
                Intent intents = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intents.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                        "head.jpg")));
                //采用ForResult打开
                startActivityForResult(intents,2);
                popupWindow.dismiss();
                break;
            default:
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());//裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory()
                            + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));//裁剪图片
                }

                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if(head!=null){
                        /**
                         * 上传服务器代码
                         */
                        setPicToView(head);//保存在SD卡中
                        imageViewHead.setImageBitmap(head);//用ImageView显示出来
                    }
                }
                break;
            default:
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    };
    /**
     * 调用系统的裁剪
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName =path + "head.jpg";//图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //边输入边存储
    private void Storage(){
        editTextNickName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = editTextNickName.getText().toString().trim();
                editor.putString("NICKNAME",str);
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTextMailbox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = editTextMailbox.getText().toString().trim();
                editor.putString("MAILBOX",string);
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textViewSex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String ss = textViewSex.getText().toString();
                editor.putString("SEX",ss);
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences = getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        String nickname = sharedPreferences.getString("NICKNAME","昵称");
        editTextNickName.setText(nickname);
        String mailbox = sharedPreferences.getString("MAILBOX","绑定邮箱");
        editTextMailbox.setText(mailbox);
        String sex = sharedPreferences.getString("SEX","选择性别");
        textViewSex.setText(sex);
        String birthday = sharedPreferences.getString("BIRTHDAY","选择生日");
        Log.d("MainActivity", "999999999"+birthday);
        textView.setText(birthday);
    }
    @Override
    protected void onResume() {
        super.onResume();
        String binbing = sharedPreferences.getString("Binbing","绑定手机号");
        textViewBinbing.setText(binbing);
        Log.d("1111111111", binbing);
    }

}
