package com.lanou3g.mostbeauty.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by dllo on 16/9/2.
 */
//启动页
public class WelcomeActivity extends BaseActivity {
    private ImageView mImageEnter;
    private static final int ANIM_TIME = 2000;
    private static final float SCALE_END = 1.15F;
    private static final int[] imgs = {R.mipmap.splash_bg1, R.mipmap.splash_bg1};

    @Override
    protected int getLayout() {
        return R.layout.welcome_avtivity;
    }

    @Override
    protected void initView() {
        mImageEnter = (ImageView) findViewById(R.id.image_enter);
    }

    @Override
    protected void initData() {
        startMainActivity();
    }

    private void startMainActivity() {

        Random random = new Random(SystemClock.elapsedRealtime());
        mImageEnter.setImageResource(imgs[random.nextInt(imgs.length)]);

        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {

                    @Override
                    public void call(Long aLong) {
                        startAnim();
                    }
                });
    }

    private void startAnim() {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mImageEnter, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mImageEnter, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {

                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
