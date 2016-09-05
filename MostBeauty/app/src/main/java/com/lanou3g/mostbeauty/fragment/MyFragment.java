package com.lanou3g.mostbeauty.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou3g.mostbeauty.R;

import com.lanou3g.mostbeauty.activity.mine.FeedbackActivity;
import com.lanou3g.mostbeauty.activity.mine.MaterialActivity;
import com.lanou3g.mostbeauty.activity.mine.SetActivity;

import com.lanou3g.mostbeauty.activity.CollectActivity;
import com.lanou3g.mostbeauty.activity.DesignAttentionActivity;

import com.lanou3g.mostbeauty.activity.WishActivity;

import com.lanou3g.mostbeauty.base.BaseFragment;

/**
 * Created by dllo on 16/8/30.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private ImageView imageViewMyHead,imageViewSet,imageViewSina,imageViewQQ,imageViewWeixin;
    private TextView textViewFeedBack,textViewdraw;
    private RelativeLayout relativeLayoutAttention,relativeLayoutWish;
    private PopupWindow mPop;

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
    }

    @Override
    protected void initData() {

    }
    private PopupWindow LogonPop(){
        mPop = new PopupWindow();
        View popView = LayoutInflater.from(getActivity()).inflate(R.layout.my_pop,null);
        imageViewSina = (ImageView) popView.findViewById(R.id.sina_share);
        imageViewSina.setOnClickListener(this);
        imageViewQQ = (ImageView) popView.findViewById(R.id.image_qq);
        imageViewQQ.setOnClickListener(this);
        imageViewWeixin = (ImageView) popView.findViewById(R.id.image_weixin);
        imageViewWeixin.setOnClickListener(this);
        mPop.setWidth(800);
        mPop.setHeight(500);
        //点击外部是否消失
        mPop.setOutsideTouchable(true);
        //设置焦点
        mPop.setFocusable(true);
        mPop.setContentView(popView);
        Drawable drawable = new ColorDrawable(0xffffff);
        mPop.setBackgroundDrawable(drawable);
        mPop.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        backgroundAlpha(1f);
        mPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
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
    private void MyLogon(){

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_image_head:
                startActivity(new Intent(getActivity(), MaterialActivity.class));
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
        }
    }

}
