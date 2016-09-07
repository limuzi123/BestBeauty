package com.lanou3g.mostbeauty.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.adapter.LeadGuideAdapter;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.other.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/7.
 */
public class LeadGuideActivity extends BaseActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private LeadGuideAdapter adapter;
    private List<View> views;
    private Button startbtn;
    //引导页图片资源
    private static final int[] pics = {R.layout.guide_view_lead,
            R.layout.guide_view_one, R.layout.guide_view_two};
    //底部小点图片
    private ImageView[] dots;

    //记录当前选中的位置
    private int currentIndex;

    @Override
    protected int getLayout() {
        return R.layout.activity_guide_lead;
    }

    @Override
    protected void initView() {
        views = new ArrayList<>();
        //初始化引导视图列表
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);

            if (i == pics.length - 1) {
                startbtn = (Button) view.findViewById(R.id.btn_enter);

                startbtn.setTag("enter");
                startbtn.setOnClickListener(this);
            }
            views.add(view);
        }
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        adapter = new LeadGuideAdapter(views);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new PageChangeListener());
        initDots();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 如果切换到后台，就设置下次不进入功能引导页
        SharedPreferencesUtil.putBoolean(this, SharedPreferencesUtil.FIRST_OPEN, false);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void initData() {
        SharedPreferences sharedPreferences = getSharedPreferences("count", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first", false);
        editor.commit();
    }

    private void initDots() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[pics.length];
        //循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            //得到一个LinearLayout下面的每一个子元素
            dots[i] = (ImageView) linearLayout.getChildAt(i);
            dots[i].setEnabled(false);//都设置成灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);//设置位置tag,方便取出与当前位置对应
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(true);//设置为白色,即选中状态

    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        viewPager.setCurrentItem(position);
    }

    /**
     * 设置当前指示点
     *
     * @param position
     */
    private void setCurDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }


    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {
            enterWelcomeActivity();
            return;
        }
        int position = (int) v.getTag();
        setCurView(position);
        setCurDot(position);
    }

    private void enterWelcomeActivity() {
        Intent intent = new Intent(LeadGuideActivity.this,WelcomeActivity.class);
        startActivity(intent);
        SharedPreferencesUtil.putBoolean(LeadGuideActivity.this,SharedPreferencesUtil.FIRST_OPEN,false);
        finish();
//        Intent intent = new Intent(this,WelcomeActivity.class);
//        startActivity(intent);
//        finish();
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int position) {

        }

        @Override
        public void onPageScrolled(int position, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            // 设置底部小点选中状态
            setCurDot(position);
        }

    }
}
