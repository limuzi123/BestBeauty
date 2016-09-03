package com.lanou3g.mostbeauty.activity.pictorial;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build.VERSION_CODES;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.mostbeauty.Bean.PivtorialAnthorInfo;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.adapter.PictorialAuthorPagerAdapter;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialAuthorActivity extends BaseActivity{
    private ViewPager viewPagerTop,viewPager;
    private TabLayout tabLayout;
    private ImageView imgName;
    private TextView tvName,tvSmall,tvContent,tvMore;
    private PictorialAuthorPagerAdapter pagerAdapter;
    private int width;


    @Override
    protected int getLayout() {
        return R.layout.activity_pictoral_author;
    }

    @TargetApi(VERSION_CODES.M)
    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPagerTop = (ViewPager) findViewById(R.id.img_top);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        imgName = (ImageView) findViewById(R.id.img_name);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvSmall = (TextView) findViewById(R.id.tv_small);
        tvContent = (TextView) findViewById(R.id.tv_content);
        tvMore = (TextView) findViewById(R.id.tv_more);

       
        pagerAdapter = new PictorialAuthorPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GRAY,Color.LTGRAY);
        tabLayout.setSelectedTabIndicatorColor(0xffffffff);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        final WindowManager wm = getWindowManager();
        width = wm.getDefaultDisplay().getWidth();



    }

    @Override
    protected void initData() {

    }
}
