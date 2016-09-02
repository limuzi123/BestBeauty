package com.lanou3g.mostbeauty.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.adapter.CollectAdapter;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.fragment.collectfragment.AssistFragment;
import com.lanou3g.mostbeauty.fragment.collectfragment.CollectFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/2.
 */
public class CollectActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> data;
    private CollectAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_collect;
    }

    @Override
    protected void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_collect);
        viewPager = (ViewPager) findViewById(R.id.view_pager_collect);
        data = new ArrayList<>();
        data.add(new CollectFragment());
        data.add(new AssistFragment());
        adapter = new CollectAdapter(getSupportFragmentManager(), data);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
    }
}
