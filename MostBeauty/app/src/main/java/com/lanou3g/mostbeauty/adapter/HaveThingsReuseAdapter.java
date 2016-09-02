package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.HaveThingsReuseBean;
import com.lanou3g.mostbeauty.R;

/**
 * Created by dllo on 16/9/2.
 */
public class HaveThingsReuseAdapter extends BaseAdapter {
    private HaveThingsReuseBean bean;
    private Context context;

    public HaveThingsReuseAdapter(Context context) {
        this.context = context;
    }

    public void setHaveThingsReuseBean(HaveThingsReuseBean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.getData().getProducts().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getProducts().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.fragment_have_reuse_grid_view_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(bean.getData().getProducts().get(position).getCover_images().get(0)).into(holder.imageView);
        return convertView;
    }
    public class ViewHolder{
        private ImageView imageView;
        public ViewHolder(View view) {
            imageView= (ImageView) view.findViewById(R.id.fragment_have_reuse_gv_item);
        }
    }
}
