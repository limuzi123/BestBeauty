package com.lanou3g.mostbeauty.fragment;

import android.view.View;
import android.widget.ListView;

import com.lanou3g.mostbeauty.Bean.StylistFragmentBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.adapter.StylistFragmentAdapter;
import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/8/30.
 */

public class StylistFragment extends BaseFragment{
    private ListView listView;
    private StylistFragmentAdapter adapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_stylist;
    }

    @Override
    protected void initView() {
        listView = (ListView) getView().findViewById(R.id.list_view);

    }

    @Override
    protected void initData() {
        adapter = new StylistFragmentAdapter(getContext());
        NetTool.getInstance().startRequest(API.STYLIST_FRAGMNET, StylistFragmentBean.class, new onHttpCallBack<StylistFragmentBean>() {
            @Override
            public void onSuccess(StylistFragmentBean response) {
                adapter.setBean(response);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
