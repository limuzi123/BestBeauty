package com.lanou3g.mostbeauty.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.CollectActivity;
import com.lanou3g.mostbeauty.activity.FeedbackActivity;
import com.lanou3g.mostbeauty.activity.MaterialActivity;
import com.lanou3g.mostbeauty.activity.SetActivity;
import com.lanou3g.mostbeauty.base.BaseFragment;

/**
 * Created by dllo on 16/8/30.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private ImageView imageViewMyHead,imageViewSet;
    private TextView textViewFeedBack,textViewdraw;

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
    }

    @Override
    protected void initData() {

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
        }
    }
}
