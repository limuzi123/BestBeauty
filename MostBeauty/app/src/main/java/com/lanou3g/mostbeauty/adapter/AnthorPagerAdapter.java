package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PictorialAuthorActivityViewPagerTopBean;
import com.lanou3g.mostbeauty.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/3.
 */
public class AnthorPagerAdapter extends PagerAdapter implements OnPageChangeListener{
    private PictorialAuthorActivityViewPagerTopBean bean;
    private Context context;
    private ViewPager viewPager;
    private ImageView[] tips;
    private ArrayList<Integer> images;

    public AnthorPagerAdapter(Context context) {
        this.context = context;
    }

    public void setBean(PictorialAuthorActivityViewPagerTopBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void setTips(ImageView[] tips) {
        this.tips = tips;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return bean.getData().getIntroduce_images().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tips,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_top);

        Glide.with(context).load(bean.getData().getIntroduce_images().get(position)).into(imageView);
        Log.d("AnthorPagerAdapter", "aaaaaaaa"+bean.getData().getIntroduce_images().get(position));
        container.addView(view);

        viewPager.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i <tips.length ; i++) {
            if(i == position){
                tips[i].setImageResource(R.mipmap.ic_point_selected);
            }else {
                tips[i].setImageResource(R.mipmap.ic_point_unselected);
            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
