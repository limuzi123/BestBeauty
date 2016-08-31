package com.lanou3g.mostbeauty.gson;

/**
 * Created by dllo on 16/8/30.
 */
public class NetTool implements NetInterface {
    private static NetTool ourInstance;
    private NetInterface netInterface;


    public static NetTool getInstance() {
        if (ourInstance == null) {
            synchronized ((NetTool.class)) {
                if (ourInstance == null) {
                    ourInstance = new NetTool();
                }
            }
        }
        return ourInstance;
    }

    private NetTool() {
        netInterface = new OkHttpUtil();
    }

    @Override
    public void stratRequest(String url, onHttpCallBack<String> callBack) {
        netInterface.stratRequest(url, callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, onHttpCallBack<T> callBack) {
        netInterface.startRequest(url, tClass, callBack);
    }
}
