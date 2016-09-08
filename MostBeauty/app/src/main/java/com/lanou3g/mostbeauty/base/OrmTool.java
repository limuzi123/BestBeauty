package com.lanou3g.mostbeauty.base;

import com.litesuits.orm.LiteOrm;

/**
 * Created by dllo on 16/9/8.
 */
public class OrmTool {
   // private List<ollect>
    private static LiteOrm liteOrm;

    private static OrmTool ourInInsance;

    public OrmTool() {
        liteOrm = LiteOrm.newCascadeInstance(MyApp.getContext(), "my.db");

    }

    private static OrmTool getInstance() {
        if (ourInInsance == null) {
            synchronized (OrmTool.class) {
                if (ourInInsance == null) {
                    ourInInsance = new OrmTool();
                }
            }
        }
        return ourInInsance;

    }
}