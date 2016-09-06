package com.lanou3g.mostbeauty.fragment.pictorialfragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lanou3g.mostbeauty.Bean.PictorialActivityBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.adapter.PictorialActivityGridAdapter;
import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;
import com.lanou3g.mostbeauty.myview.StationGridview;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialProductionFragment extends BaseFragment {
    private StationGridview gridView;
    private PictorialActivityGridAdapter gridAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_production;
    }

    @Override
    protected void initView() {
        gridView = (StationGridview)getView().findViewById(R.id.grid_view);

    }

    @Override
    protected void initData() {
        gridAdapter = new PictorialActivityGridAdapter(getContext());
        Intent intent = getActivity().getIntent();
        String str = intent.getStringExtra("id");
        int id = Integer.parseInt(str);
        getNetRequest(id);

    }

    // TODO: 16/9/6 获取网络数据
    private void getNetRequest(int id) {
        NetTool.getInstance().startRequest(API.PICTORIAL_ACTIVITY_ONE + id + API.PICTORIAL_ACTIVITY_TWO,
                PictorialActivityBean.class, new onHttpCallBack<PictorialActivityBean>() {
                    @Override
                    public void onSuccess(PictorialActivityBean response) {

                        gridView.setVisibility(View.VISIBLE);
                        gridAdapter.setBean(response);
                        gridView.setAdapter(gridAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
