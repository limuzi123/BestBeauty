package com.lanou3g.mostbeauty.other;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dllo on 16/9/5.
 */
//退出程序
public class ExitApplication {
    //声明一个泛型,并初始化
    private List<Activity> activityList = new LinkedList();
    private static ExitApplication instance;

    private ExitApplication() {
    }

    //单例模式中获取唯一的ExitApplication实例
    public static ExitApplication getInstance() {
        if (null == instance) {
            instance = new ExitApplication();
        }
        return instance;
    }

    //添加Activity到集合中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    //遍历所有的Activity并finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }
}
