package com.lanou3g.mostbeauty.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dllo on 16/8/30.
 */
/*
Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();

    }

    //绑定布局
    protected abstract int getLayout();

    //绑定组件,数据处理
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();
}
