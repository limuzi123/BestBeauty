package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PictorialActivityBean;
import com.lanou3g.mostbeauty.R;

/**
 * Created by dllo on 16/9/1.
 */
public class PictorialActivityGridAdapter extends BaseAdapter{
    private Context context;
    private PictorialActivityBean bean;

    public PictorialActivityGridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.getData().getRefer_products().size();
    }

    public void setBean(PictorialActivityBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getRefer_products().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pictorial_activity_gridview_list,parent,false);
           holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Log.d("PictorialActivityGridAd", "wwwwwwww"+bean.getData().getRefer_products().get(position).getCover_images());
        Glide.with(context).load(bean.getData().getRefer_products().get(position).getCover_images().get(0)).into(holder.imageView);



        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;

        public ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.img_view);

        }
    }
}
