package com.lanou3g.mostbeauty.fragment.haveThingsFragments;

import android.os.Bundle;
import android.widget.ListView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.adapter.HaveThingsHaveAdapter;
import com.lanou3g.mostbeauty.base.BaseFragment;

/**
 * Created by dllo on 16/8/30.
 * 实体类: HaveThingsHaveBean
 * listView套用listView
 */
public class HaveFragment extends BaseFragment{
    //listView绑两个布局
    private ListView listView;
    private HaveThingsHaveAdapter adapter;
    private String[] id= {"1472529600000","1472400000000","1472270400000"};
    @Override
    protected int initLayout() {
        return R.layout.fragment_have_have;
    }

    @Override
    protected void initView() {
        listView= (ListView) getView().findViewById(R.id.have_have_lv);
        adapter = new HaveThingsHaveAdapter(getContext());
    }

    @Override
    protected void initData() {
       adapter.setId(id);
        listView.setAdapter(adapter);

    }
    public static HaveFragment newInstance(int position){
        Bundle args = new Bundle();
        args.putInt("position",position);
        HaveFragment fragment = new HaveFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
