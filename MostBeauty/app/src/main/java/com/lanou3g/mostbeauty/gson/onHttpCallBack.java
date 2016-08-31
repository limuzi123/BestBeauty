package com.lanou3g.mostbeauty.gson;

/**
 * 两个网络解析的回调方法
 * Created by dllo on 16/8/30.
 */
public interface onHttpCallBack<T> {
    void onSuccess(T response);
    void onError(Throwable e);
}
