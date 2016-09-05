package com.lanou3g.mostbeauty.activity.pictorial;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION_CODES;
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
import android.view.View.OnScrollChangeListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
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

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialAuthorActivity extends BaseActivity{
    private ViewPager viewPagerTop,viewPager;
    private TabLayout tabLayout;
    private ImageView imgName;
    private TextView tvName,tvSmall,tvContent,tvMore;
    private PictorialAuthorPagerAdapter pagerAdapter;
    private AnthorPagerAdapter adapter;
    private android.app.FragmentManager manager;
    private ScrollView scrollView;
    private ImageView imgBackSmall;
  //  private int width;
    private int l;


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
        scrollView = (ScrollView) findViewById(R.id.scroll_View);
        imgBackSmall = (ImageView) findViewById(R.id.img_back_small);
        scrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d("PictorialAuthorActivity", + viewPager.getTop()-scrollY-tabLayout.getHeight()+"");
                if(viewPager.getTop()-scrollY-tabLayout.getHeight()==0){
                    imgBackSmall.setVisibility(View.VISIBLE);
                   scrollView.removeViewInLayout(tabLayout);

                }
            }
        });
//        scrollView.setOnTouchListener(new OnTouchListener() {
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//       if (event.getAction()==  MotionEvent.ACTION_MOVE){
//           Log.d("PictorialAuthorActivity", + viewPager.getTop()+"");
//           if(viewPager.getTop()-tabLayout.getHeight()== 0){
//
//               return true;
//           }
//       }
//        return false;
//    }
//});

       
        pagerAdapter = new PictorialAuthorPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GRAY,Color.LTGRAY);
        tabLayout.setSelectedTabIndicatorColor(0xffffffff);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        l = display.getWidth();
        Log.d("PictorialAuthorActivity", "1237698-09=-0=e"+l/2);
        tabLayout.setPadding(l/2,0,0,0);



        getTabPosition();


    }

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

    @Override
    protected void initData() {
        adapter= new AnthorPagerAdapter(this);


        Intent intent =getIntent();
       String str =  intent.getStringExtra("idAuthor");
        int id = Integer.parseInt(str);

        getNetRequest(id);


    }

    // TODO: 16/9/5 获取Tablayout上面界面的网络数据
    private void getNetRequest(int id) {
        NetTool.getInstance().startRequest(API.PICTORIAL_AUTHOR_ACTYVITY_VIEWPAGER_TOP_ONE + id + API.PICTORIAL_AUTHOR_ACTYVITY_VIEWPAGER_TOP_TWO, PictorialAuthorActivityViewPagerTopBean.class,
                new onHttpCallBack<PictorialAuthorActivityViewPagerTopBean>() {
                    @Override
                    public void onSuccess(PictorialAuthorActivityViewPagerTopBean response) {
                        adapter.setBean(response);
                        viewPagerTop.setAdapter(adapter);
                        adapter.setViewPager(viewPagerTop);
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
}
