package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PictorialCommentActivityBean;
import com.lanou3g.mostbeauty.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/2.
 */
public class PictorialCommentActivityAdapter extends BaseAdapter {
    private Context context;
    private PictorialCommentActivityBean bean;

    public PictorialCommentActivityAdapter(Context context) {
        this.context = context;
    }

    public void setBean(PictorialCommentActivityBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean.getData().getComments().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getComments().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pictorial_activity_listview_list,parent,false);

            holder = new ViewHolder(convertView);
            convertView .setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.d("PictorialActivityListAd", "444444444"+bean.getData().getComments().get(position).getAuthor().getUsername());

        holder.tvName.setText(bean.getData().getComments().get(position).getAuthor().getUsername());
        holder.tvContent.setText(bean.getData().getComments().get(position).getContent());
        Glide.with(context).load(bean.getData().getComments().get(position).getAuthor().getAvatar_url()).placeholder(R.mipmap.best_beauty).bitmapTransform(new CropCircleTransformation(context)).into(holder.imageView);

        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView tvName,tvContent;
        public ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.img_comment);
            tvName = (TextView) view.findViewById(R.id.tv_name_list);
            tvContent = (TextView) view.findViewById(R.id.tv_content_content);

        }
    }
}
