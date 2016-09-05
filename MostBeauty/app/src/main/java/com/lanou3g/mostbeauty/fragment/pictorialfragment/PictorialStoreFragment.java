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
import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialStoreFragment extends BaseFragment {
    private TextView tvCity,tvName,tvPlace;
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
        Intent intent = getActivity().getIntent();
        String str =  intent.getStringExtra("idAuthor");
        int id = Integer.parseInt(str);
        NetTool.getInstance().startRequest(API.PICTORIAL_STORE_FRAGMENT_ONE + id + API.PICTORIAL_STORE_FRAGMENT_TWO, StoreBean.class,
                new onHttpCallBack<StoreBean>() {
                    @Override
                    public void onSuccess(StoreBean response) {
                      if(response.getData().getShops().size() != 0){
                        tvCity.setText(response.getData().getShops().get(0).getCity());
                        tvPlace.setText(response.getData().getShops().get(0).getAddress());
                        tvName.setText(response.getData().getShops().get(0).getName());
                        Glide.with(getContext()).load(response.getData().getShop_image()).into(imgName);}

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


    }


}
