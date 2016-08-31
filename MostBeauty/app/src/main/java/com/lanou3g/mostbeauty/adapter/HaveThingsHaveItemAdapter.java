package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.lanou3g.mostbeauty.Bean.HaveThingsHaveBean;
import com.lanou3g.mostbeauty.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/8/31.
 */
public class HaveThingsHaveItemAdapter extends BaseAdapter {
    private Context context;
    private HaveThingsHaveBean bean;

    public void setBean(HaveThingsHaveBean bean) {
        this.bean = bean;
    }

    public HaveThingsHaveItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.getData().getActivities().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getActivities().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.adapter_have_things_have_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {

            holder= (ViewHolder) convertView.getTag();
        }
        //holder.productName.setText(bean.getData().getActivities().get(position).getProduct().getName());
        String str  = bean.getData().getActivities().get(position).getDigest();

        holder.digest.setText(str);
        holder.designerName.setText(bean.getData().getActivities().get(position).getDesigner().getName());
        holder.desigerLabel.setText(bean.getData().getActivities().get(position).getDesigner().getLabel());
        initGlide(holder.images,bean.getData().getActivities().get(position).getImages().get(0));
        initGlide(holder.designerAvatar,bean.getData().getActivities().get(position).getDesigner().getAvatar_url());
        return convertView;
    }
    public class ViewHolder{
        private ImageView images,designerAvatar;
        private TextView productName,digest,designerName,desigerLabel;
        public ViewHolder(View view) {
            images= (ImageView) view.findViewById(R.id.adapter_have_things_have_item_images);
            designerAvatar = (ImageView) view.findViewById(R.id.adapter_have_things_have_item_designer_avatar);
            //productName= (TextView) view.findViewById(R.id.adapter_have_things_have_item_product_name);
            digest= (TextView) view.findViewById(R.id.adapter_have_things_have_item_digest);
            designerName= (TextView) view.findViewById(R.id.adapter_have_things_have_item_designer_name);
            desigerLabel= (TextView) view.findViewById(R.id.adapter_have_things_have_item_desiger_label);
        }
    }
    public void initGlide(ImageView imageView,String url){
        Glide.with(context).load(url).priority(Priority.HIGH).thumbnail(0.1f).bitmapTransform(new CropCircleTransformation(context)).into(imageView);
    }
}
