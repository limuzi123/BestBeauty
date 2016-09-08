package com.lanou3g.mostbeauty.activity;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.lanou3g.mostbeauty.Bean.HaveHaveBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.base.MyApp;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;
import com.lanou3g.mostbeauty.myview.MyImageView;
import com.lanou3g.mostbeauty.myview.NewScrollView;
import com.lanou3g.mostbeauty.myview.NewScrollView.ScrollViewListener;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * 无画报网址
 * http://design.zuimeia.com/api/v1/product/1110/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld
 * 一个画报
 * http://design.zuimeia.com/api/v1/product/986/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld
 * Created by dllo on 16/9/5.
 */

public class HaveHaveActivity extends BaseActivity {
    private TextView digest, designerName, label, concept, name, desc;
    private DisplayImageOptions options;
    private ImageLoader imageLoader;
    private ImageView photo;
    private ListView listView;
    private ListViewAdapter adapter;
    private ViewPager viewPager;
    private ReturnAdapter returnAdapter;
    private ImageView [] tips;
    private LinearLayout linearLayout;
    private LinearLayout llLove,llCry;
    private ImageView ivLove,ivCry;
    private AnimationDrawable adLove,adCry;
    private TextView tvLove,tvCry;
    private LinearLayout loveLL,cryLL;
    private ImageView smile,cry;
    private ListView lvPaint;
    private LvPaintAdapter lvPaintAdapter;
    private LinearLayout llPaint,comment;
    private NewScrollView scrollView;
    private boolean flag = true;
    private MyImageView back;
    @Override
    protected int getLayout() {
        return R.layout.activity_have_have;
    }

    @Override
    protected void initView() {
        viewPager= (ViewPager) findViewById(R.id.activity_have_have_vp);
        digest = (TextView) findViewById(R.id.activity_have_have_digest);
        designerName = (TextView) findViewById(R.id.activity_have_have_name);
        label = (TextView) findViewById(R.id.activity_have_have_label);
        concept = (TextView) findViewById(R.id.activity_have_have_concept);
        name = (TextView) findViewById(R.id.activity_have_have_name_data);
        desc = (TextView) findViewById(R.id.activity_have_have_desc);
        initMyOptions();
        imageLoader = ImageLoader.getInstance();
        photo= (ImageView) findViewById(R.id.activity_have_have_iv);
        listView = (ListView) findViewById(R.id.activity_have_have_lv);
        listView.setDividerHeight(0);
        adapter=new ListViewAdapter(this);
        returnAdapter=new ReturnAdapter(this);
        linearLayout= (LinearLayout) findViewById(R.id.activity_have_have_ll);
        loveLL= (LinearLayout) findViewById(R.id.activity_have_have_smile);
        cryLL = (LinearLayout) findViewById(R.id.activity_have_have_cry);
        smile= (ImageView) findViewById(R.id.activity_have_have_smile_iv);
        cry = (ImageView) findViewById(R.id.activity_have_have_cry_iv);
        lvPaint= (ListView) findViewById(R.id.activity_have_have_paint);//画报
        lvPaintAdapter = new LvPaintAdapter(this);
        llPaint= (LinearLayout) findViewById(R.id.activity_have_have_ll_paint);
        scrollView = (NewScrollView) findViewById(R.id.activity_have_have_scroll);
        comment= (LinearLayout) findViewById(R.id.activity_have_have_comment);
        back = (MyImageView) findViewById(R.id.activity_have_have_back);
    }
    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("haveId", 0);
        getNetData(id);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        final TranslateAnimation down = new TranslateAnimation(width,0,0,0);
        down.setDuration(2000);
        comment.setAnimation(down);
        final TranslateAnimation dismiss = new TranslateAnimation(0,width,0,0);
        dismiss.setDuration(2000);
        comment.setAnimation(dismiss);
        final TranslateAnimation backShow  = new TranslateAnimation(0,0,-300,0);
        backShow.setDuration(2000);
        backShow.setInterpolator(new BounceInterpolator());
        back.setAnimation(backShow);
        final TranslateAnimation backDismiss = new TranslateAnimation(0,0,0,-300);
        backDismiss.setDuration(2000);
        back.setAnimation(backDismiss);
        scrollView.setScrollViewListener(new ScrollViewListener() {
            @Override
            public void onScrollChanged(View scrollView, int x, int y, int oldx, int oldy) {

                if ((y>scrollView.getHeight()/2)&&(flag == true) ){
                    comment.setVisibility(View.VISIBLE);
                    comment.startAnimation(down);
                    back.startAnimation(backDismiss);
                    back.setVisibility(View.GONE);
                    flag=false;

                }else if ((y<=scrollView.getHeight()/2)&&(flag==false)){
                    comment.setVisibility(View.GONE);
                    comment.startAnimation(dismiss);

                    back.setVisibility(View.VISIBLE);
                    back.startAnimation(backShow);
                    back.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    flag=true;
                }
            }
        });

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ArgbEvaluator evaluator = new ArgbEvaluator();
                ArgbEvaluator evaluator1 = new ArgbEvaluator();
                int evaluate = (int) evaluator.evaluate(positionOffset,0xff8080ff,0xffff8080);
                int evaluate1 = (int) evaluator1.evaluate(positionOffset,0xffff8080,0xff8080ff);
                if (position%2 == 0){
                    back.setGradient(0xff8080ff,0xffff8080);
                    back.setGradient(evaluate,evaluate1);
                }else {
                    back.setGradient(0xffff8080,0xff8080ff);
                    back.setGradient(evaluate1,evaluate);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void getNetData(int id) {
        NetTool.getInstance().startRequest("http://design.zuimeia.com/api/v1/product/" + id + "/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld"
                , HaveHaveBean.class, new onHttpCallBack<HaveHaveBean>() {
                    @Override
                    public void onSuccess(final HaveHaveBean response) {
                        digest.setText(response.getData().getDigest());
                        designerName.setText(response.getData().getDesigner().getName());
                        label.setText(response.getData().getDesigner().getLabel());
                        concept.setText(response.getData().getDesigner().getConcept());
                        name.setText(response.getData().getName());
                        desc.setText(response.getData().getDesc());
                        imageLoader.displayImage(response.getData().getDesigner().getAvatar_url(),photo,options);
                        adapter.setBean(response);
                        listView.setAdapter(adapter);
                        setListViewHeightBasedOnChildren(listView);
                        setReturn(response);

                        int loveH = response.getData().getLike_user_num();
                        int cryH = response.getData().getUnlike_user_num();
                        setPop(smile,cry,loveH,cryH,loveLL,cryLL);
                        if (response.getData().getRefer_articles()!=null){
                            llPaint.setVisibility(View.VISIBLE);
                            lvPaintAdapter.setBean(response);
                            lvPaint.setAdapter(lvPaintAdapter);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    /**
     * 设置轮播图
     * @param response
     */
    private void setReturn(final HaveHaveBean response) {
        tips=new ImageView[response.getData().getCover_images().size()];
        for (int i = 0; i < response.getData().getCover_images().size(); i++) {
            ImageView imageDot = new ImageView(MyApp.getContext());
            tips[i]=imageDot;
            if (i==0){
                imageDot.setImageResource(R.mipmap.ic_point_selected);
            }else {
                imageDot.setImageResource(R.mipmap.ic_point_unselected);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20,30);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin=20;
            layoutParams.bottomMargin=20;
            linearLayout.addView(imageDot,layoutParams);
        }
        returnAdapter.setBean(response);
        //returnAdapter.setViewPager(viewPager);
        viewPager.setAdapter(returnAdapter);
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < response.getData().getCover_images().size(); i++) {
                    if (i==position%(response.getData().getCover_images().size())){
                        tips[i].setImageResource(R.mipmap.ic_point_selected);
                    }else {
                        tips[i].setImageResource(R.mipmap.ic_point_unselected);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        final Handler handler = new Handler(new Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                return false;
            }
        });
        Boolean run = true;
        final Boolean flag = true;
        if (run){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag) {
                        try {
                            Thread.sleep(5000);
                            handler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            run=false;
        }
    }

    /**
     * 解析
     */
    public void initMyOptions() {
        // 使用DisplayImageOptions.Builder()创建DisplayImageOptions
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(100)) // 设置成圆角图片
                .build(); // 构建完成
    }

    /**
     * listView的Adapter
     */
    public class ListViewAdapter extends BaseAdapter{
        private Context context;
        private HaveHaveBean bean;


        public ListViewAdapter(Context context) {
            this.context = context;
        }

        public void setBean(HaveHaveBean bean) {
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getData().getImages().size();
        }

        @Override
        public Object getItem(int position) {
            return bean.getData().getImages().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView==null){
                convertView= LayoutInflater.from(context).inflate(R.layout.adapter_have_have_item,parent,false);
                holder=new ViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            imageLoader.displayImage(bean.getData().getCover_images().get(position),holder.imageView,options);

            return convertView;
        }

        public class ViewHolder{
            private ImageView imageView;
            public ViewHolder(View view) {
                imageView= (ImageView) view.findViewById(R.id.adapter_have_have_iv);
            }
        }


    }

    /**
     * 轮播图的Adapter
     */
    public class ReturnAdapter extends PagerAdapter {
        private HaveHaveBean bean;
        private Context context;
        //private ViewPager viewPager;
        //private ImageView[] tips;

        public ReturnAdapter(Context context) {
            this.context = context;
        }

        public void setBean(HaveHaveBean bean) {
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getData().getCover_images()==null?0:Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_have_have_return,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.adapter_have_have_iv);
            imageLoader.displayImage(bean.getData().getCover_images().get(position%(bean.getData().getCover_images().size())),imageView,options);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }

    /**
     * 重新计算高度
     * 一定要在setAdapter后调用
     *
     * @param listView
     */
    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1)) + 5;
        listView.setLayoutParams(params);
    }

    public PopupWindow createPopLove(int height, int total){
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setHeight(height/2+200);
        popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.adapter_have_things_have_item_pop_love,null);
        llLove= (LinearLayout) view.findViewById(R.id.adapter_have_things_have_item_pop_love);
        ivLove= (ImageView) view.findViewById(R.id.adapter_have_things_have_item_pop_love_iv);
        adLove= (AnimationDrawable) ivLove.getBackground();
        adLove.setOneShot(true);
        tvLove= (TextView) view.findViewById(R.id.adapter_have_things_have_item_pop_love_tv);
        tvLove.setText(height*100/total+"%");
        popupWindow.setContentView(view);
        Drawable d = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(d);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.pop);
        return popupWindow;
    }
    public PopupWindow createPopCry(int height,int total){
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setHeight(height/2+200);
        popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.adapter_have_things_have_item_pop_cry,null);
        llCry= (LinearLayout) view.findViewById(R.id.adapter_have_things_have_item_pop_cry);
        ivCry= (ImageView) view.findViewById(R.id.adapter_have_things_have_item_pop_cry_iv);
        adCry= (AnimationDrawable) ivCry.getBackground();
        adCry.setOneShot(true);
        tvCry= (TextView) view.findViewById(R.id.adapter_have_things_have_item_pop_cry_tv);
        tvCry.setText(height*100/total+"%");
        popupWindow.setContentView(view);
        Drawable d = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(d);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.pop);
        return popupWindow;
    }
    private void setPop(final ImageView smile, final ImageView cry, final int heightSmile , final int heightCry, final LinearLayout smileLL, final LinearLayout cryLL) {
        smile.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupWindow popCry = createPopCry(heightCry,heightCry+heightSmile);
                final PopupWindow popSmile =  createPopLove(heightSmile,heightCry+heightSmile);
                if (!popCry.isShowing()&&!popSmile.isShowing()) {
                    llLove.setBackgroundResource(R.drawable.shape_face_yellow);
                    llCry.setBackgroundResource(R.drawable.shape_face);
                    popCry.showAsDropDown(cry, 0, -(heightCry/2+200));
                    popSmile.showAsDropDown(smile, 0, -(heightSmile/2+200 ));
                    adLove.start();
                    popSmile.setOnDismissListener(
                            new OnDismissListener() {
                                @Override
                                public void onDismiss() {
                                    smile.setBackgroundResource(R.mipmap.like_10);
                                    cry.setBackgroundResource(R.mipmap.dislike_1);
                                    //cry.setImageResource(R.mipmap.dislike_1);
                                    smileLL.setBackgroundResource(R.drawable.shape_face_yellow);
                                    cryLL.setBackgroundResource(R.drawable.shape_face);
                                }
                            });
                }
            }
        });
        cry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupWindow popCry = createPopCry(heightCry, heightCry+heightSmile);
                final PopupWindow popSmile =  createPopLove(heightSmile,heightCry+heightSmile);
                if (!popCry.isShowing()&&!popSmile.isShowing()) {
                    llLove.setBackgroundResource(R.drawable.shape_face);
                    llCry.setBackgroundResource(R.drawable.shape_face_yellow);
                    popCry.showAsDropDown(cry, 0, -(heightCry/2+200 ));
                    popSmile.showAsDropDown(smile, 0, -(heightSmile /2+200));
                    adCry.start();
                    popCry.setOnDismissListener(new OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            cry.setBackgroundResource(R.mipmap.dislike_9);
                            smile.setBackgroundResource(R.mipmap.like_1);
                            cryLL.setBackgroundResource(R.drawable.shape_face_yellow);
                            smileLL.setBackgroundResource(R.drawable.shape_face);
                        }
                    });
                }

            }
        });
    }

    /**
     * 画报的Adapter
     */
    private class LvPaintAdapter extends BaseAdapter{
        private HaveHaveBean bean;
        private Context context;

        public LvPaintAdapter(Context context) {
            this.context = context;
        }

        public void setBean(HaveHaveBean bean) {
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getData().getRefer_articles().size();
        }

        @Override
        public Object getItem(int position) {
            return bean.getData().getRefer_articles().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LvPaintViewHolder holder = null;
            if (convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.adapter_have_have_list_view,parent,false);
                holder = new LvPaintViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder = (LvPaintViewHolder) convertView.getTag();
            }
            holder.title.setText(bean.getData().getRefer_articles().get(position).getTitle());
            holder.text.setText(bean.getData().getRefer_articles().get(position).getSub_title());
            imageLoader.displayImage(bean.getData().getRefer_articles().get(position).getImage_url(),holder.imageView,options);
            return convertView;
        }
        public class LvPaintViewHolder{
            private TextView title,text;
            private ImageView imageView;
            public LvPaintViewHolder(View view) {
                title = (TextView) view.findViewById(R.id.activity_have_have_list_view_title);
                text= (TextView) view.findViewById(R.id.activity_have_have_list_view_tv);
                imageView = (ImageView) view.findViewById(R.id.activity_have_have_list_view_iv);

            }
        }
    }
}