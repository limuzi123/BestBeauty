package com.lanou3g.mostbeauty.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by dllo on 16/9/7.
 */
public class MyImageView extends ImageView {
    private int width;
    private int height;
    private int start = 0xffff8080;
    private int end = 0xff8080ff;
    private LinearGradient gradient;
    private Paint paint;

    public MyImageView(Context context) {
        super(context);
        getMyDisplay();
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getMyDisplay();
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getMyDisplay();
    }


    public void getMyDisplay() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
    }
    public void setGradient(int start , int end){
        this.start = start;
        this.end = end;
        gradient = new LinearGradient(0,0,width,height,start,end, TileMode.MIRROR);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (paint == null){
            paint = new Paint();
        }
        if (gradient == null){
            gradient = new LinearGradient(0,0,width,height,start,end, TileMode.MIRROR);
        }
        paint.setShader(gradient);
        canvas.drawRect(0,0,width,height,paint);
    }
}
