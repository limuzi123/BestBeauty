package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
    public View getView(int position, View convertView, final ViewGroup parent) {
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
        final int heightSmile = bean.getData().getActivities().get(position).getProduct().getLike_user_num();
        final int heightCry = bean.getData().getActivities().get(position).getProduct().getUnlike_user_num();

        final ViewHolder finalHolder = holder;
        holder.smile.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopCry(heightCry/2+200).showAsDropDown(finalHolder.cry,0,-(heightCry/2+200));
                createPopLove(heightSmile/2+200).showAsDropDown(finalHolder.smile,0,-(heightSmile/2+200));
            }
        });
        holder.cry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopCry(heightCry/2+200).showAsDropDown(finalHolder.cry,0,-(heightCry/2+200));
                createPopLove(heightSmile/2+200).showAsDropDown(finalHolder.smile,0,-(heightSmile/2+200));
            }
        });

        return convertView;
    }
    public class ViewHolder{
        private ImageView images,designerAvatar,smile,cry;
        private TextView productName,digest,designerName,desigerLabel;
        public ViewHolder(View view) {
            images= (ImageView) view.findViewById(R.id.adapter_have_things_have_item_images);
            designerAvatar = (ImageView) view.findViewById(R.id.adapter_have_things_have_item_designer_avatar);
            //productName= (TextView) view.findViewById(R.id.adapter_have_things_have_item_product_name);
            digest= (TextView) view.findViewById(R.id.adapter_have_things_have_item_digest);
            designerName= (TextView) view.findViewById(R.id.adapter_have_things_have_item_designer_name);
            desigerLabel= (TextView) view.findViewById(R.id.adapter_have_things_have_item_desiger_label);
            smile= (ImageView) view.findViewById(R.id.adapter_have_things_have_item_smile);
            cry= (ImageView) view.findViewById(R.id.adapter_have_things_have_item_cry);
        }
    }
    public void initGlide(ImageView imageView,String url){
        Glide.with(context).load(url).priority(Priority.HIGH).thumbnail(0.1f)
                .bitmapTransform(new CropCircleTransformation(context)).into(imageView);
//获得图片大小
//        Glide.with(context).load(url).asBitmap().priority(Priority.HIGH)
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        Log.d("HaveThingsHaveItemAdapt", "resource.getWidth():" + resource.getWidth());
//                        Log.d("HaveThingsHaveItemAdapt", "resource.getHeight():" + resource.getHeight());
//                    }
//                });
    }
    public PopupWindow createPopLove(int height){
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setHeight(height);
        popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_have_things_have_item_pop,null);
        popupWindow.setContentView(view);
        Drawable d = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(d);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }
    public PopupWindow createPopCry(int height){
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setHeight(height);
        popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_have_things_have_item_pop_hate,null);
        popupWindow.setContentView(view);
        Drawable d = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(d);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }






}
