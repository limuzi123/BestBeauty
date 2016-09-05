package com.lanou3g.mostbeauty.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanou3g.mostbeauty.Bean.PivtorialAnthorInfo;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialAuthorPagerAdapter extends FragmentPagerAdapter {
    public PictorialAuthorPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return PivtorialAnthorInfo.getTabInfos().get(position).getFragment();
    }

    @Override
    public int getCount() {
        return PivtorialAnthorInfo.getTabInfos().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PivtorialAnthorInfo.getTabInfos().get(position).getTitle();
    }
}
