package com.lanou3g.mostbeauty.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.mostbeauty.Bean.HaveThingsReuseTitleBean;
import com.lanou3g.mostbeauty.R;

/**
 * Created by dllo on 16/9/2.
 */
public class HaveThingsReusePopAdapter extends BaseAdapter {
    private HaveThingsReuseTitleBean bean;
    private Context context;
    private int item;

    public HaveThingsReusePopAdapter(Context context) {
        this.context = context;
    }

    public void setHaveThingsReuseTitleBean(HaveThingsReuseTitleBean haveThingsReuseTitleBean) {
        this.bean = haveThingsReuseTitleBean;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public int getCount() {
        return bean.getData().getCategories().get(item).getSub_categories().size()+1;
    }

    @Override
    public Object getItem(int position) {
        if (position==1){
            return null;
        }else {
            return bean.getData().getCategories().get(item).getSub_categories().get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PopViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_have_things_reuse_pop_adapter, parent, false);
            holder = new PopViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (PopViewHolder) convertView.getTag();
        }

        if (position == 0) {
            holder.tv.setText("全部");

        } else {
            holder.tv.setText(bean.getData().getCategories().get(item).getSub_categories().get(position-1).getName());
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("have", Activity.MODE_PRIVATE);
        int choosePosition = sharedPreferences.getInt("position",0);
        if (position==choosePosition){
            holder.tv.setTextColor(0xff2C2C2C);
            holder.tv.setBackgroundResource(R.drawable.shape_button_select);
        }else {
            holder.tv.setTextColor(0xffF7F7F7);
            holder.tv.setBackgroundResource(R.drawable.shape_button);
        }

        return convertView;
    }
    public class PopViewHolder{
        private TextView tv;
        public PopViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.adapter_have_things_reuse_pop_btn);
        }
    }
}

