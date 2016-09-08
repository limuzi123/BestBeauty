package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PictorialActivityBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.pictorial.PictorialActivity;
import com.lanou3g.mostbeauty.activity.pictorial.ReaderActivity;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/1.
 */
public class PictorialActivityListAdapter extends BaseAdapter {
    private Context context;
    private PictorialActivityBean bean;

    public PictorialActivityListAdapter(Context context) {
        this.context = context;
    }

    public void setBean(PictorialActivityBean bean) {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pictorial_activity_listview_list, parent, false);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.d("PictorialActivityListAd", "444444444" + bean.getData().getComments().get(position).getAuthor().getUsername());
        final int id = bean.getData().getComments().get(position).getAuthor().getId();
        holder.tvName.setText(bean.getData().getComments().get(position).getAuthor().getUsername());
        holder.tvContent.setText(bean.getData().getComments().get(position).getContent());
        Glide.with(context).load(bean.getData().getComments().get(position).getAuthor().getAvatar_url()).placeholder(R.mipmap.best_beauty).bitmapTransform(new CropCircleTransformation(context)).into(holder.imageView);
        holder.imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ReaderActivity.class);
                intent.putExtra("id", Integer.toString(id));
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder {
        private ImageView imageView;
        private TextView tvName, tvContent;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.img_comment);
            tvName = (TextView) view.findViewById(R.id.tv_name_list);
            tvContent = (TextView) view.findViewById(R.id.tv_content_content);

        }
    }


}
