package com.lanou3g.mostbeauty.fragment.haveThingsFragments;

import android.os.Bundle;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseFragment;

/**
 * Created by dllo on 16/8/30.
 */
public class ReuseFragment extends BaseFragment {
    @Override
    protected int initLayout() {
        return R.layout.fragment_have_reuse;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
    public static ReuseFragment newInstant(int position){
        Bundle args=new Bundle();
        args.putInt("position",position);
        ReuseFragment fragment = new ReuseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
