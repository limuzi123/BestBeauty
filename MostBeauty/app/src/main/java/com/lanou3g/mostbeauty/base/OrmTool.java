package com.lanou3g.mostbeauty.base;

/**
 * Created by dllo on 16/9/8.
 */
public class OrmTool {

    private static OrmTool ourInInsance;
    private static OrmTool getInstance(){
        if(ourInInsance == null){
            synchronized (OrmTool.class){
                if(ourInInsance==null){
                    ourInInsance =new  OrmTool();
                }
            }
        }
        return ourInInsance;
    }
}
