package com.lanou3g.mostbeauty.fragment.pictorialfragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PivtorialAnthorInfo;
import com.lanou3g.mostbeauty.Bean.StoreBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.activity.pictorial.PictorialAuthorActivity;
import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialStoreFragment extends BaseFragment {
    private TextView tvCity, tvName, tvPlace;
    private ImageView imgName;


    @Override
    protected int initLayout() {
        return R.layout.fragment_pictorial_store;
    }

    @Override
    protected void initView() {
        tvCity = (TextView) getView().findViewById(R.id.tv_city);
        tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvPlace = (TextView) getView().findViewById(R.id.tv_place);
        imgName = (ImageView) getView().findViewById(R.id.img_name);

    }

    @Override
    protected void initData() {


        tvCity.setText(PictorialAuthorActivity.getResponse().getData().getShops().get(0).getCity());
        tvPlace.setText(PictorialAuthorActivity.getResponse().getData().getShops().get(0).getAddress());
        tvName.setText(PictorialAuthorActivity.getResponse().getData().getShops().get(0).getName());
        Glide.with(getContext()).load(PictorialAuthorActivity.getResponse().getData().getShop_image()).into(imgName);
    }


}
