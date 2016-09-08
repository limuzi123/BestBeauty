package com.lanou3g.mostbeauty.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by dllo on 16/9/7.
 */
public class NewScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener = null;
    public NewScrollView(Context context) {
        super(context);
    }

    public NewScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener != null){
            scrollViewListener.onScrollChanged(this,l,t,oldl,oldt);
        }




    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, 0, 0, isTouchEvent);
    }
    public interface ScrollViewListener{
        void onScrollChanged(View scrollView, int x, int y, int oldx, int oldy);
    }
    public void setScrollViewListener(ScrollViewListener listener){
        scrollViewListener = listener;
    }


}


























