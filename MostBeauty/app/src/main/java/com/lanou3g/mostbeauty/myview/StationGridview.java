package com.lanou3g.mostbeauty.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * Created by dllo on 16/8/16.
 */
public class StationGridview extends GridView {
    public StationGridview(Context context) {
        super(context);
    }

    public StationGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StationGridview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    //重写dispatchTouchEvent方法禁止GridView滑动
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
//遇到一个ScrollView嵌套GridView的情况，由于这两款控件都自带滚动条，外层的ScrollView会对滚动事件进行拦截，就会存在GridView会显示不全。
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec= MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
