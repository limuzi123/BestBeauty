package com.lanou3g.mostbeauty.fragment.pictorialfragment;

import android.app.SearchManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;

import com.lanou3g.mostbeauty.Bean.PictorialBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.adapter.PictrialFragmentAdapter;
import com.lanou3g.mostbeauty.base.BaseFragment;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;
import com.wirelesspienetwork.overview.misc.Utilities;
import com.wirelesspienetwork.overview.views.Overview;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by dllo on 16/8/30.
 */
public class PictorialFragment extends BaseFragment implements Overview.RecentsViewCallbacks{
    boolean mVisible;
    Overview mRecentsView;
    private ArrayList<Integer> models;
    private PictrialFragmentAdapter adapter;
    @Override
    protected int initLayout() {
        return R.layout.fragment_pictorial;

    }

    @Override
    protected void initView() {
        mRecentsView = (Overview) getView().findViewById(R.id.recents_view);
        mRecentsView.setCallbacks(this);

    }

    @Override
    protected void initData() {

        models = new ArrayList<>();

        // Private API calls to make the shadows look better
        try {
            Utilities.setShadowProperty("ambientRatio", String.valueOf(1.5f));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        getNetRequest();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void getNetRequest() {
        mVisible = true;
        adapter = new PictrialFragmentAdapter(models,getContext());
        NetTool.getInstance().startRequest(API.PICTORIAL_FRAGMENT, PictorialBean.class, new onHttpCallBack<PictorialBean>() {
            @Override
            public void onSuccess(PictorialBean response) {
                adapter.setBean(response);
                mRecentsView.setTaskStack(adapter);
                for(int i = 0; i < response.getData().getArticles().size(); ++i){

                    models.add(response.getData().getArticles().size());
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d("PictorialFragment", "12345678");
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCardDismissed(int position) {

    }

    @Override
    public void onAllCardsDismissed() {

    }
}
