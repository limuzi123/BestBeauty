package com.lanou3g.mostbeauty.activity.mine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.base.MyApp;
import com.lanou3g.mostbeauty.other.DataClean;

import java.io.File;

/**
 * Created by dllo on 16/9/2.
 */
//设置页面
public class SetActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageViewSetBack;
    private RelativeLayout relativeLayoutFeedBack,relativeLayoutSetHead;
    private RelativeLayout relativeLayoutClean,relativeLayoutGood,relativeLayoutabout;

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
        relativeLayoutClean = (RelativeLayout) findViewById(R.id.relative_layout_clean);
        relativeLayoutClean.setOnClickListener(this);
        relativeLayoutGood = (RelativeLayout) findViewById(R.id.relative_good);
        relativeLayoutGood.setOnClickListener(this);
        relativeLayoutabout = (RelativeLayout) findViewById(R.id.relative_about);
        relativeLayoutabout.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }
    private void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SetActivity.this);
        builder.setMessage("确认清除缓存吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              //  DataClean.getCacheSize();
                DataClean.cleanInternalCache(SetActivity.this);
                Toast.makeText(SetActivity.this, "清除了缓存数据", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
            case R.id.relative_layout_clean:
                Dialog();
                break;
            case R.id.relative_good:
                Apply();
                break;
            case R.id.relative_about:
                startActivity(new Intent(SetActivity.this,AboutActivity.class));
                break;
        }
    }
    //跳转到应用商店
    private void Apply(){
        //这里开始执行一个应用市场跳转逻辑,默认this为Context上下文对象
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //跳转到应用市场,非Google Play市场一般情况也实现了这个接口
        intent.setData(Uri.parse("market://details?id=" + getPackageName()));
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
            }else {
                Toast.makeText(this, "您的手机没有安装应用市场", Toast.LENGTH_SHORT).show();
            }
        }
    }

