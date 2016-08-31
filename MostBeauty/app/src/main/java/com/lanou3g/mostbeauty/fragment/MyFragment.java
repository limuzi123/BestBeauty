package com.lanou3g.mostbeauty.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.MaterialActivity;
import com.lanou3g.mostbeauty.base.BaseFragment;

/**
 * Created by dllo on 16/8/30.
 */
public class MyFragment extends BaseFragment{
    private Button button;
    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
     button = (Button) getView().findViewById(R.id.btn_one);
    }

    @Override
    protected void initData() {
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(getActivity(), MaterialActivity.class));
          }
      });
    }
}
