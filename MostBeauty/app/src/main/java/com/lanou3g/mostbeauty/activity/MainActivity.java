package com.lanou3g.mostbeauty.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.lanou3g.mostbeauty.R;

import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.fragment.HaveThingsFragment;
import com.lanou3g.mostbeauty.fragment.MyFragment;
import com.lanou3g.mostbeauty.fragment.PictorialFragment;
import com.lanou3g.mostbeauty.fragment.StylistFragment;

public class MainActivity extends BaseActivity implements OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private PictorialFragment pictorial;
    private RadioButton button;





    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.main_radio);
        button = (RadioButton) findViewById(R.id.pictal_radio);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    protected void initData() {
        pictorial = new PictorialFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, pictorial).commit();
        button.setChecked(true);

    }
        @Override
        public void onCheckedChanged (RadioGroup group,int checkedId){
            switch (checkedId) {
                case R.id.pictal_radio:
                    pictorial = new PictorialFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, pictorial).commit();
                    break;
                case R.id.havething_radio:
                    HaveThingsFragment haveThings = new HaveThingsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, haveThings).commit();
                    break;
                case R.id.stailst_radio:
                    StylistFragment stylist = new StylistFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, stylist).commit();
                    break;
                case R.id.my_radio:
                    MyFragment my = new MyFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, my).commit();
                    break;
            }
        }
    }
