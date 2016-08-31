package com.lanou3g.mostbeauty.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lanou3g.mostbeauty.Bean.HaveThingsReuseTitleBean;
import com.lanou3g.mostbeauty.R;
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
        viewPager= (ViewPager) getView().findViewById(R.id.haveThings_vp);
        adapter=new HaveThingsAdapter(getChildFragmentManager());
    }
    @Override
    protected void initData() {
        NetTool.getInstance().startRequest("http://design.zuimeia.com/api/v1/product/categories/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld"
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
