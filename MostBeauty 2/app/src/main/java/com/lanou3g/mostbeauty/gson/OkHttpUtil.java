package com.lanou3g.mostbeauty.gson;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/8/30.
 */
public class OkHttpUtil implements NetInterface {
    private OkHttpClient mClient;
    //这样定义的Handler对象无论在哪里创建的 都是属于主线程的
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Gson gson;

    //构造方法初始化
    public OkHttpUtil() {
      //  super();
        //获取系统的sd卡,即设置缓存路径
        File path = Environment.getExternalStorageDirectory();
        //初始化okhttp 一个1024是1k, 1024*1024是1M 10*1024*1024是10M,
        mClient = new OkHttpClient.Builder()
                // 设置缓存路经和大小 一个1024是1k, 1024*1024是1M 10*1024*1024是10M,
                .cache(new Cache(path, 10 * 1024 * 1024))
                //超时时间5秒
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
        gson = new Gson();
    }

    @Override
    public void stratRequest(String url, final onHttpCallBack<String> callBack) {
        Request request = new Request.Builder().url(url).build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //接口里的方法
                        callBack.onError(e);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                // 此方法post将任务直接传给主线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);

                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final onHttpCallBack<T> callBack) {
        Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final T result = gson.fromJson(str,tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });

    }
}
