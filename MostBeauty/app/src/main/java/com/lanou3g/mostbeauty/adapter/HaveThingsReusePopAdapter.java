package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

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
        return bean.getData().getCategories().get(item).getSub_categories().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getCategories().get(item).getSub_categories().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PopViewHolder holder = null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.adapter_have_things_reuse_pop_adapter,parent,false);
            holder=new PopViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (PopViewHolder) convertView.getTag();
        }
        holder.button.setText(bean.getData().getCategories().get(item).getSub_categories().get(position).getName());

        return convertView;
    }
    public class PopViewHolder{
        private Button button;
        public PopViewHolder(View view) {
            button= (Button) view.findViewById(R.id.adapter_have_things_reuse_pop_btn);
        }
    }
}

