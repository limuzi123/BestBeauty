package com.lanou3g.mostbeauty.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
        Drawable drawable = getDrawable();

        //空值判断，必要步骤，避免由于没有设置src导致的异常错误
        if (drawable == null) {
            return;
        }
        //必要步骤，避免由于初始化之前导致的异常错误
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (!(drawable instanceof BitmapDrawable)) {
            return;
        }
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        if (null == b) {
            return;
        }
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
        int w = getWidth();
        Bitmap roundBitmap = getCroppedBitmap(bitmap, w);
        canvas.drawBitmap(roundBitmap, 0, 0, null);
    }


    /**
     * 初始Bitmap对象的缩放裁剪过程
     * @param bmp        初始Bitmap对象
     * @param radius    圆形图片直径大小
     * @return 返回一个圆形的缩放裁剪过后的Bitmap对象
     */
    public static Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
        //比较初始Bitmap宽高和给定的圆形直径，判断是否需要缩放裁剪Bitmap对象
        if (bmp.getWidth() != radius || bmp.getHeight() != radius)
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        else
            sbmp = bmp;
        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(), sbmp.getHeight(),
                Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(sbmp.getWidth() / 2 + 0.7f,
                sbmp.getHeight() / 2 + 0.7f, sbmp.getWidth() / 2 + 0.1f, paint);
        //核心部分，设置两张图片的相交模式，在这里就是上面绘制的Circle和下面绘制的Bitmap
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        return output;
    }
}
