package com.lanou3g.mostbeauty.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.R;

import com.lanou3g.mostbeauty.activity.MainActivity;
import com.lanou3g.mostbeauty.activity.mine.FeedbackActivity;
import com.lanou3g.mostbeauty.activity.mine.MaterialActivity;
import com.lanou3g.mostbeauty.activity.mine.SetActivity;

import com.lanou3g.mostbeauty.activity.CollectActivity;
import com.lanou3g.mostbeauty.activity.DesignAttentionActivity;

import com.lanou3g.mostbeauty.activity.WishActivity;

import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.base.MyApp;
import com.mob.tools.utils.UIHandler;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/8/30.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener, PlatformActionListener, Handler.Callback {
    private ImageView imageViewMyHead, imageViewSet, imageViewSina, imageViewQQ, imageViewWeixin;
    private TextView textViewFeedBack, textViewdraw, textViewMyTextViewName;
    private RelativeLayout relativeLayoutAttention, relativeLayoutWish;
    private PopupWindow mPop;
    private SharedPreferences sharedQQ;
    private static final int MSG_ACTION_CCALLBACK = 2;
    private boolean logon;
    private SharedPreferences.Editor editor;

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        imageViewMyHead = (ImageView) getView().findViewById(R.id.my_image_head);
        imageViewMyHead.setOnClickListener(this);
        imageViewSet = (ImageView) getView().findViewById(R.id.image_set);
        imageViewSet.setOnClickListener(this);
        textViewFeedBack = (TextView) getView().findViewById(R.id.text_feedback);
        textViewFeedBack.setOnClickListener(this);
        textViewdraw = (TextView) getView().findViewById(R.id.text_view_collect_draw);
        textViewdraw.setOnClickListener(this);
        relativeLayoutAttention = (RelativeLayout) getView().findViewById(R.id.relative_layout_attention);
        relativeLayoutAttention.setOnClickListener(this);
        relativeLayoutWish = (RelativeLayout) getView().findViewById(R.id.relative_layout_wish);
        relativeLayoutWish.setOnClickListener(this);
        textViewMyTextViewName = (TextView) getView().findViewById(R.id.my_text_view_name);
    }

    @Override
    protected void initData() {
        LogonPop();
        sharedQQ = getActivity().getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        editor = sharedQQ.edit();
        ShareSDK.initSDK(getActivity());
        Log.d("MyFragment", "a0000000" + logon);
        //保存登录状态
        if (sharedQQ.getBoolean("logon", false)) {
            String nickname = sharedQQ.getString("qqName", "");
            textViewMyTextViewName.setText(nickname);
            Log.d("my", nickname);
            String picture = sharedQQ.getString("qqHeadPicture", "");
            Log.d("MyFragment", picture);
            //传过来的是一个String类型的网址
            Glide.with(getContext()).load(picture).bitmapTransform(new CropCircleTransformation(getContext())).
                    into(imageViewMyHead);
        }
    }

    private PopupWindow LogonPop() {
        mPop = new PopupWindow(getContext());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.my_pop, null);
        imageViewSina = (ImageView) view.findViewById(R.id.sina_share);
        imageViewQQ = (ImageView) view.findViewById(R.id.image_qq);
        imageViewWeixin = (ImageView) view.findViewById(R.id.image_weixin);
        imageViewSina.setOnClickListener(this);
        imageViewQQ.setOnClickListener(this);
        imageViewWeixin.setOnClickListener(this);
        mPop.setWidth(700);
        mPop.setHeight(600);
        mPop.setOutsideTouchable(true);
        mPop.setFocusable(true);
        mPop.setContentView(view);
        Drawable drawable = new ColorDrawable(0xffffffff);
        mPop.setBackgroundDrawable(drawable);
        mPop.setAnimationStyle(R.style.pop_anim);
        mPop.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        backgroundAlpha(1f);
        mPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
                Log.d("MyFragment", "aaa");
            }
        });
        return mPop;
    }

    public void backgroundAlpha(float bgAlpha) {
        //设全屏
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha;
        this.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_image_head:
                if (sharedQQ.getBoolean("logon", false)) {
                    startActivity(new Intent(getActivity(), MaterialActivity.class));
                } else {
                    mPop.showAtLocation(v, Gravity.CENTER, 0, 0);
                    backgroundAlpha(0.7f);
                }
                break;
            case R.id.image_set:
                startActivity(new Intent(getActivity(), SetActivity.class));
                break;
            case R.id.text_feedback:
                startActivity(new Intent(getActivity(), FeedbackActivity.class));
                break;
            case R.id.text_view_collect_draw:
                startActivity(new Intent(getActivity(), CollectActivity.class));
                break;
            case R.id.relative_layout_attention:
                startActivity(new Intent(getActivity(), DesignAttentionActivity.class));
                break;
            case R.id.relative_layout_wish:
                startActivity(new Intent(getActivity(), WishActivity.class));
                break;
            case R.id.image_qq:
                Platform weixinfd = ShareSDK.getPlatform(QQ.NAME);
                weixinfd.setPlatformActionListener(this);
                weixinfd.showUser(null);
                break;

        }
    }

    //第三方qq登录
    @Override
    public void onCancel(Platform platform, int i) {
        Message msg = new Message();
        msg.what = MSG_ACTION_CCALLBACK;
        msg.arg1 = 3;
        msg.arg2 = i;
        msg.obj = platform;
        UIHandler.sendMessage(msg, this);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Message msg = new Message();
        msg.what = MSG_ACTION_CCALLBACK;
        msg.arg1 = 1;
        msg.arg2 = i;
        msg.obj = platform;

        if (platform.getName().equals(QQ.NAME)) {
        }
        UIHandler.sendMessage(msg, this);
        System.out.println(hashMap);


        //获取资料
        String qqName = platform.getDb().getUserName();//获取用户名字
        String qqHeadPicture = platform.getDb().getUserIcon();//获取用户头像
        Log.d("名字", qqName);

        editor.putString("qqName", qqName);
        editor.putString("qqHeadPicture", qqHeadPicture);
        logon = true;
        editor.putBoolean("logon", logon);
        Log.d("MyFragment", "---------" + logon);
        editor.commit();

        //登陆进去后跳到主页面
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Message msg = new Message();
        msg.what = MSG_ACTION_CCALLBACK;
        msg.arg1 = 2;
        msg.arg2 = i;
        msg.obj = throwable;
        UIHandler.sendMessage(msg, this);
        Log.d("MyFragment", "oaoaoaoaoaoao");
        //分享失败的统计
        ShareSDK.logDemoEvent(4, platform);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.arg1) {
            case 1: {
                logon = true;
                editor.putBoolean("logon", logon);
                Log.d("MyFragment", "---------" + logon);
                editor.commit();
                //成功
                Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
                mPop.dismiss();
            }
            break;
            case 2: {
                //失败
                Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
            }
            break;
            case 3: {
                //取消
                Toast.makeText(getActivity(), "取消", Toast.LENGTH_SHORT).show();
            }
            break;
        }
        return false;
    }

}
