package com.lanou3g.mostbeauty.activity.pictorial;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialAuthorActivity extends BaseActivity{
    private ViewPager viewPagerTop,viewPager;
    private TabLayout tabLayout;
    private ImageView imgName;
    private TextView tvName,tvSmall,tvContent,tvMore;
    @Override
    protected int getLayout() {
        return R.layout.activity_pictoral_author;
    }

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

    }

    @Override
    protected void initData() {

    }
}
