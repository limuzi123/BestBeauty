package com.lanou3g.mostbeauty.fragment.haveThingsFragments;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lanou3g.mostbeauty.Bean.HaveThingsReuseBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.adapter.HaveThingsAdapter;
import com.lanou3g.mostbeauty.adapter.HaveThingsReuseAdapter;
import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/8/30.
 */
public class ReuseFragment extends BaseFragment {
    private String start = "http://design.zuimeia.com/api/v1/products/category/";
    private String end = "/?page=1&page_size=30&device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    private GridView gridView,gvPop;
    private HaveThingsReuseAdapter gvAdapter;
    private TextView textView;
    private ImageView imageView;
    private Boolean flag=true;
    private PopupWindow popupWindow;
    private LinearLayout linearLayout;
    @Override
    protected int initLayout() {
        return R.layout.fragment_have_reuse;
    }

    @Override
    protected void initView() {
        gridView= (GridView) getView().findViewById(R.id.fragment_have_reuse_gv);
        gvAdapter=new HaveThingsReuseAdapter(getContext());
        textView= (TextView) getView().findViewById(R.id.fragment_have_reuse_tv);
        imageView= (ImageView) getView().findViewById(R.id.fragment_have_reuse_iv);
        popupWindow=CreatePop();
        linearLayout = (LinearLayout) getView().findViewById(R.id.fragment_have_reuse_ll);
        linearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==true) {
                    textView.setVisibility(View.INVISIBLE);
                    imageView.setImageResource(R.mipmap.icon_category_fold);
                    popupWindow.showAsDropDown(linearLayout, 0, 0);
                    flag=false;
                }else {
                    textView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.mipmap.icon_category_unfold);
                    popupWindow.dismiss();
                    flag=true;
                }
            }
        });
    }

    @Override
    protected void initData() {
        int id= HaveThingsAdapter.getId(getPosition());
        getNetData(id);
    }
    protected void getNetData(int id){
        String url = start+id+end;
        NetTool.getInstance().startRequest(url, HaveThingsReuseBean.class, new onHttpCallBack<HaveThingsReuseBean>() {
            @Override
            public void onSuccess(HaveThingsReuseBean response) {
                gvAdapter.setHaveThingsReuseBean(response);
                gridView.setAdapter(gvAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
    private PopupWindow CreatePop(){
        PopupWindow popupWindow = new PopupWindow(getContext());
        popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_have_reuse_pop,null);
        gvPop = (GridView) view.findViewById(R.id.fragment_have_reuse_pop_gv);
        // TODO: 16/9/2 帮适配器
        popupWindow.setContentView(view);
        Drawable d = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(d);
        return popupWindow;
    }






//Fragment复用 以下两个方法把Fragment和位置绑定到一起//////////////////////////////////////////////////////////////////////////
    /**
     * Fragment绑定TabLayout 用于Fragment的复用 在GuideViewPagerAdapter里调用
     * @param position
     * @return
     */
    public static ReuseFragment newInstant(int position){
        Bundle args=new Bundle();
        args.putInt("position",position);
        ReuseFragment fragment = new ReuseFragment();
        fragment.setArguments(args);
        return fragment;
    }
    /**
     * 获取Fragment绑定的TabLayout 在GuideViewPagerAdapter里调用 对应的标题位置
     * @return
     */
    private int getPosition(){
        int position;
        Bundle args=getArguments();
        //获得传入Bundle的位置信息 并取出
        if (args!=null) {
            position = args.getInt("position");
            return position;
        }else return 0;
    }
}
