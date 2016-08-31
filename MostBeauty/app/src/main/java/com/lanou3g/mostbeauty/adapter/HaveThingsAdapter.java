package com.lanou3g.mostbeauty.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanou3g.mostbeauty.Bean.HaveThingsReuseTitleBean;
import com.lanou3g.mostbeauty.fragment.haveThingsFragments.HaveFragment;
import com.lanou3g.mostbeauty.fragment.haveThingsFragments.ReuseFragment;

/**
 * title和viewpager
 * Created by dllo on 16/8/30.
 */
public class HaveThingsAdapter extends FragmentPagerAdapter {
    private HaveThingsReuseTitleBean bean;
    public HaveThingsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setBean(HaveThingsReuseTitleBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return HaveFragment.newInstance(position);
        }else {
            return ReuseFragment.newInstant(position);
        }
    }

    @Override
    public int getCount() {
        return bean.getData().getCategories().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "有物";
        }else {
            return bean.getData().getCategories().get(position).getName();
        }
    }
}
