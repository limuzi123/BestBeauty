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
    private static HaveThingsReuseTitleBean bean;
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
        return bean.getData().getCategories().size()+1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "Daily";
        }else {
            return bean.getData().getCategories().get(position-1).getName();
        }
    }
    //传值给ReuseFragment
    public static int getId(int position){
        int id = bean.getData().getCategories().get(position-1).getId();
        //标题位置position-1
        return id;
    }
    public static HaveThingsReuseTitleBean getHaveThingsReuseTitleBean(){
       return bean;
    }
}
