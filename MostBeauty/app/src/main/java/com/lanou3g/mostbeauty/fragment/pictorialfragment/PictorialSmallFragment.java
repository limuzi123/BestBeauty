package com.lanou3g.mostbeauty.fragment.pictorialfragment;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseFragment;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialSmallFragment extends BaseFragment {
    private TextView tvSmall,tvTitle;
    private ImageView imgTiltle;
    @Override
    protected int initLayout() {
        return R.layout.fragment_pictorial_small;
    }

    @Override
    protected void initView() {
        tvSmall = (TextView) getView().findViewById(R.id.tv_small);
        tvTitle = (TextView) getView().findViewById(R.id.tv_title);
        imgTiltle = (ImageView) getView().findViewById(R.id.img_tiltle);

    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
      String img = intent.getStringExtra("img");
      String tvTitleStr =  intent.getStringExtra("tvTitle");
      String tvSmallSrt =  intent.getStringExtra("tvSmall");
        Glide.with(getContext()).load(img).into(imgTiltle);
        tvSmall.setText(tvSmallSrt);
        tvTitle.setText(tvTitleStr);

    }
}
