package com.lanou3g.mostbeauty.activity;

import android.content.Intent;
import android.widget.TextView;

import com.lanou3g.mostbeauty.Bean.HaveHaveBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/9/5.
 */
public class HaveHaveActivity extends BaseActivity {
    private TextView digest, designerName,label,concept,name,desc;
    @Override
    protected int getLayout() {
        return R.layout.activity_have_have;
    }

    @Override
    protected void initView() {
        digest= (TextView) findViewById(R.id.activity_have_have_digest);
        designerName = (TextView) findViewById(R.id.activity_have_have_name);
        label = (TextView) findViewById(R.id.activity_have_have_label);
        concept= (TextView) findViewById(R.id.activity_have_have_concept);
        name= (TextView) findViewById(R.id.activity_have_have_name_data);
        desc= (TextView) findViewById(R.id.activity_have_have_desc);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id=intent.getIntExtra("haveId",0);
        NetTool.getInstance().startRequest("http://design.zuimeia.com/api/v1/product/"+id+"/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld"
                , HaveHaveBean.class, new onHttpCallBack<HaveHaveBean>() {
                    @Override
                    public void onSuccess(HaveHaveBean response) {
                        digest.setText(response.getData().getDigest());
                        designerName.setText(response.getData().getDesigner().getName());
                        label.setText(response.getData().getDesigner().getLabel());
                        concept.setText(response.getData().getDesigner().getConcept());
                        name.setText(response.getData().getName());
                        desc.setText(response.getData().getDesc());









                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
