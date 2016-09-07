package com.lanou3g.mostbeauty.activity.pictorial;

import android.annotation.TargetApi;
import android.content.Intent;
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

import com.lanou3g.mostbeauty.Bean.PictorialAuthorActivityViewPagerTopBean;
import com.lanou3g.mostbeauty.Bean.PivtorialAnthorInfo;
import com.lanou3g.mostbeauty.Bean.StoreBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.adapter.PictorialAuthorPagerAdapter;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;
import com.lanou3g.mostbeauty.myview.SwipeBackLayout;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialAuthorActivity extends BaseActivity{
    private ViewPager viewPagerTop,viewPager;
    private TabLayout tabLayout;
    private ImageView imgName;
    private TextView tvName,tvSmall,tvContent,tvMore;
    private PictorialAuthorPagerAdapter pagerAdapter;
<<<<<<< HEAD
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
    private static StoreBean response;
    private SwipeBackLayout swipeBackLayoutTwo;



    private int l;

=======
    private int width;
>>>>>>> 80326f4f49bf17c33e59ac3ac859738fa8a9ce50


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
<<<<<<< HEAD
        scrollView = (ScrollView) findViewById(R.id.scroll_View);
        imgBackSmall = (ImageView) findViewById(R.id.img_back_small);
        imgBackTwo = (ImageView) findViewById(R.id.img_back_two);
        frameLayoutOne = (FrameLayout) findViewById(R.id.frame_layout_one);
        frameLayoutTwo = (FrameLayout) findViewById(R.id.frame_layout_two);
        horizontalscrollView = (HorizontalScrollView) findViewById(R.id.frame_layout_big);
        linearLayout = (LinearLayout) findViewById(R.id.linear_tip);
        imgBack = (ImageView) findViewById(R.id.img_back);
        swipeBackLayoutTwo = (SwipeBackLayout) findViewById(R.id.swipe_layout_two);
        imgBack.setOnClickListener(this);
        imgBackSmall.setOnClickListener(this);

=======
>>>>>>> 80326f4f49bf17c33e59ac3ac859738fa8a9ce50

       
        pagerAdapter = new PictorialAuthorPagerAdapter(getSupportFragmentManager());
<<<<<<< HEAD


=======
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GRAY,Color.LTGRAY);
        tabLayout.setSelectedTabIndicatorColor(0xffffffff);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
>>>>>>> 80326f4f49bf17c33e59ac3ac859738fa8a9ce50

        final WindowManager wm = getWindowManager();
        width = wm.getDefaultDisplay().getWidth();



    }

    @Override
    protected void initData() {
<<<<<<< HEAD

        adapter= new AnthorPagerAdapter(this);
        Intent intent =getIntent();
       String str =  intent.getStringExtra("idAuthor");
        int id = Integer.parseInt(str);
        getTiltileState();
        getTabPosition();
        getNetRequest(id);
        getStoreNetRequest(id);


    }
    // TODO: 16/9/7 实现侧滑退出Activity 的监听


    // TODO: 16/9/6 获取PictorialStoreFragment的网络数据
    private void getStoreNetRequest(int id) {
        NetTool.getInstance().startRequest(API.PICTORIAL_STORE_FRAGMENT_ONE + id + API.PICTORIAL_STORE_FRAGMENT_TWO, StoreBean.class,
                new onHttpCallBack<StoreBean>() {
                    @Override
                    public void onSuccess(StoreBean response) {
                      PictorialAuthorActivity.response= response;
                        viewPager.setAdapter(pagerAdapter);
                        tabLayout.setupWithViewPager(viewPager);
                        tabLayout.setTabTextColors(Color.GRAY,Color.LTGRAY);
                        tabLayout.setSelectedTabIndicatorColor(0xffffffff);
                        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    // TODO: 16/9/5 获取Tablayout上面界面的网络数据
    private void getNetRequest(int id) {
=======
        Intent intent =getIntent();
       String str =  intent.getStringExtra("idAuthor");
        int id = Integer.parseInt(str);
>>>>>>> 80326f4f49bf17c33e59ac3ac859738fa8a9ce50
        NetTool.getInstance().startRequest(API.PICTORIAL_AUTHOR_ACTYVITY_VIEWPAGER_TOP_ONE + id + API.PICTORIAL_AUTHOR_ACTYVITY_VIEWPAGER_TOP_TWO, PictorialAuthorActivityViewPagerTopBean.class,
                new onHttpCallBack<PictorialAuthorActivityViewPagerTopBean>() {
                    @Override
                    public void onSuccess(PictorialAuthorActivityViewPagerTopBean response) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


<<<<<<< HEAD
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

    // TODO: 16/9/7 实现类似轮播图,
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
=======
>>>>>>> 80326f4f49bf17c33e59ac3ac859738fa8a9ce50
    }
    public static  StoreBean getResponse(){
        return response;
    }


}
