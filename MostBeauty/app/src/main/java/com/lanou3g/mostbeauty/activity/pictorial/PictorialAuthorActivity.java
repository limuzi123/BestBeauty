package com.lanou3g.mostbeauty.activity.pictorial;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Build.VERSION_CODES;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnScrollChangeListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PictorialAuthorActivityViewPagerTopBean;
import com.lanou3g.mostbeauty.Bean.PivtorialAnthorInfo;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.adapter.AnthorPagerAdapter;
import com.lanou3g.mostbeauty.adapter.PictorialAuthorPagerAdapter;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialAuthorActivity extends BaseActivity implements OnClickListener{
    private ViewPager viewPagerTop,viewPager;
    private TabLayout tabLayout;
    private ImageView imgName;
    private TextView tvName,tvSmall,tvContent,tvMore;
    private PictorialAuthorPagerAdapter pagerAdapter;
    private AnthorPagerAdapter adapter;
    private Handler handler;
    private boolean flag = true;
    private boolean mm = true;
    private ScrollView scrollView;
    private ImageView imgBackSmall,imgBackTwo,imgBack;
    private FrameLayout frameLayoutOne,frameLayoutTwo;
    private HorizontalScrollView horizontalscrollView;
    private LinearLayout linearLayout;
    private ImageView[] tips;



    private int l;



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
        scrollView = (ScrollView) findViewById(R.id.scroll_View);
        imgBackSmall = (ImageView) findViewById(R.id.img_back_small);
        imgBackTwo = (ImageView) findViewById(R.id.img_back_two);
        frameLayoutOne = (FrameLayout) findViewById(R.id.frame_layout_one);
        frameLayoutTwo = (FrameLayout) findViewById(R.id.frame_layout_two);
        horizontalscrollView = (HorizontalScrollView) findViewById(R.id.frame_layout_big);
        linearLayout = (LinearLayout) findViewById(R.id.linear_tip);
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);
        imgBackSmall.setOnClickListener(this);


        pagerAdapter = new PictorialAuthorPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GRAY,Color.LTGRAY);
        tabLayout.setSelectedTabIndicatorColor(0xffffffff);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);



        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        l = display.getWidth();

        tabLayout.setPadding(l/2,0,0,0);



    }



    @Override
    protected void initData() {
        adapter= new AnthorPagerAdapter(this);
        Intent intent =getIntent();
       String str =  intent.getStringExtra("idAuthor");
        int id = Integer.parseInt(str);
        getTiltileState();
        getTabPosition();
        getNetRequest(id);




    }

    // TODO: 16/9/5 获取Tablayout上面界面的网络数据
    private void getNetRequest(int id) {
        NetTool.getInstance().startRequest(API.PICTORIAL_AUTHOR_ACTYVITY_VIEWPAGER_TOP_ONE + id + API.PICTORIAL_AUTHOR_ACTYVITY_VIEWPAGER_TOP_TWO, PictorialAuthorActivityViewPagerTopBean.class,
                new onHttpCallBack<PictorialAuthorActivityViewPagerTopBean>() {
                    @Override
                    public void onSuccess(PictorialAuthorActivityViewPagerTopBean response) {
                        adapter.setBean(response);
                        setReturn(response);
                        adapter.setViewPager(viewPagerTop);
                        viewPagerTop.setAdapter(adapter);

                        Glide.with(PictorialAuthorActivity.this).load(response.getData().getAvatar_url())
                                .bitmapTransform(new CropCircleTransformation(PictorialAuthorActivity.this)).into(imgName);
                        tvName.setText(response.getData().getName());
                        tvSmall.setText(response.getData().getLabel());
                        tvContent.setText(response.getData().getConcept());
                        tvMore.setText(response.getData().getDescription());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    // TODO: 16/9/6 滑动scrollView使Tablayout顶部悬浮 用removeView和addView方法对其进行移除和添加
    @TargetApi(VERSION_CODES.M)
    private void getTiltileState() {
        scrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d("PictorialAuthorActivity", + viewPager.getTop()-scrollY-tabLayout.getHeight()+"");

                if(viewPager.getTop()-scrollY-tabLayout.getHeight()<=0){
                    frameLayoutOne.removeView(tabLayout);
                    horizontalscrollView.setVisibility(View.VISIBLE);
                    imgBackTwo.setVisibility(View.VISIBLE);
                    frameLayoutTwo.removeAllViews();

                    frameLayoutTwo.addView(tabLayout);
                }else if(viewPager.getTop()-scrollY-tabLayout.getHeight()>0){
                    frameLayoutOne.removeAllViews();
                    frameLayoutTwo.removeAllViews();
                    frameLayoutOne.addView(tabLayout);
                    horizontalscrollView.setVisibility(View.GONE);

                    imgBackSmall.setVisibility(View.INVISIBLE);

                }
            }
        });
    }

    // TODO: 16/9/6 Tablayout 的状态变化 使其被选中的地方始终居中
    private void getTabPosition() {
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                tabLayout.setPadding(l/2 -position*250,0,0,0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void setReturn(PictorialAuthorActivityViewPagerTopBean response){
        setPagerChange();
        tips = new ImageView[response.getData().getIntroduce_images().size()];
        for (int i = 0; i < response.getData().getIntroduce_images().size(); i++) {
         ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(20,20));
            tips[i] = imageView;
            if(i== 0){
                imageView.setImageResource(R.mipmap.ic_point_selected);
            }else {
                imageView.setImageResource(R.mipmap.ic_point_unselected);
            }
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(20, 20);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin = 20;

            linearLayout.addView(imageView, layoutParams);
        }
        adapter.setTips(tips);
    }
    // TODO: 16/9/6 线程只发送一次消息,所以Handler只执行一次 实现只自动跳转一次的效果
    private void setPagerChange() {
        handler = new Handler(new Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(viewPagerTop.getCurrentItem()==0){


                    viewPagerTop.setCurrentItem(viewPagerTop.getCurrentItem() + 1);



                }

                return false;
            }
        });

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag) {
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //只发送一次消息,就关闭线程
                        if (mm) {
                        handler.sendEmptyMessage(0);
                            mm = false;
                        }
                    }
                }
            }).start();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_back_small:
                finish();
                break;
        }
    }
}
