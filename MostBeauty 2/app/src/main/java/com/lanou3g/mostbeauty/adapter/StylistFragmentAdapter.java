package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.StylistFragmentBean;
import com.lanou3g.mostbeauty.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/2.
 */
public class StylistFragmentAdapter extends BaseAdapter {
    private Context context;
    private StylistFragmentBean bean;

    public StylistFragmentAdapter(Context context) {
        this.context = context;
    }

    public void setBean(StylistFragmentBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean.getData().getDesigners().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getDesigners().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_stylist_fragment_list,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(bean.getData().getDesigners().get(position).getName());
        holder.tvSmall.setText(bean.getData().getDesigners().get(position).getLabel());
        Glide.with(context).load(bean.getData().getDesigners().get(position).getAvatar_url())
                .bitmapTransform(new CropCircleTransformation(context)).into(holder.imgName);
        Glide.with(context).load(bean.getData().getDesigners().get(position).getRecommend_images().get(0)).into(holder.imgTop);
        return convertView;
    }
    class ViewHolder{
        private ImageView imgName,imgTop;
        private TextView tvName,tvSmall;
        public ViewHolder(View view){
            imgName = (ImageView) view.findViewById(R.id.img_name);
            imgTop = (ImageView) view.findViewById(R.id.img_top);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvSmall = (TextView) view.findViewById(R.id.tv_small);

        }
    }
}
