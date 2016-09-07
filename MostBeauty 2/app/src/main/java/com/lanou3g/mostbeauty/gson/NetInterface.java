package com.lanou3g.mostbeauty.gson;

/**
 * 通过此接口是请求回调
 * Created by dllo on 16/8/30.
 */
public interface NetInterface {
    //请求的是String类型 回调 可能数据接口有问题时 比如特殊字符时,用此方法,即Gson解析不了时
    void stratRequest(String url,
                      onHttpCallBack<String> callBack);

    //泛型
    <T> void startRequest(String url,
                          Class<T> tClass,
                          onHttpCallBack<T> callBack);
}
