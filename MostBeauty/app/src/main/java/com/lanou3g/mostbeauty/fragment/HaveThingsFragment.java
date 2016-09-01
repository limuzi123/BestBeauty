package com.lanou3g.mostbeauty.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lanou3g.mostbeauty.Bean.HaveThingsReuseTitleBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.adapter.HaveThingsAdapter;
import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/8/30.
 */
public class HaveThingsFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HaveThingsAdapter adapter;
    @Override
    protected int initLayout() {
        return R.layout.fragment_havethings;
    }
    protected void initView() {
        tabLayout= (TabLayout) getView().findViewById(R.id.haveThings_tl);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSmoothScrollingEnabled(true);
        tabLayout.setTabTextColors(0xee606060,0xeeFFFFFF);
        tabLayout.setSelectedTabIndicatorColor(0xeeFFFFFF);
        viewPager= (ViewPager) getView().findViewById(R.id.haveThings_vp);
        adapter=new HaveThingsAdapter(getChildFragmentManager());
    }
    @Override
    protected void initData() {
        NetTool.getInstance().startRequest(API.HAVE_THINGS_FRAGMENT

                , HaveThingsReuseTitleBean.class
                , new onHttpCallBack<HaveThingsReuseTitleBean>() {
                    @Override
                    public void onSuccess(HaveThingsReuseTitleBean response) {
                        adapter.setBean(response);
                        viewPager.setAdapter(adapter);
                        tabLayout.setupWithViewPager(viewPager);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }
}
