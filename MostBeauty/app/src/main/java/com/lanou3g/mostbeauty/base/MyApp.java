package com.lanou3g.mostbeauty.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/8/30.
 */
public class MyApp extends Application{
    protected static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
    public static Context getContext(){
        return context;
    }
}
