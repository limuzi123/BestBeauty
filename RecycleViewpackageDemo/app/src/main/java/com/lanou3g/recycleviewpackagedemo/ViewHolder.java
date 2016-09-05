package com.lanou3g.recycleviewpackagedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by dllo on 16/9/5.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private Context context;
    private View mView;//行布局
    //跟Map类似
    private SparseArray<View> mViewSparseArray;//用来存放View的集合



    public ViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        mView = itemView;
        mViewSparseArray = new SparseArray<>();
    }

    /**
     * 创建ViewHolder
     * @param context
     * @param parent
     * @param layoutId
     * @return
     */
    public  static ViewHolder createViewHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        ViewHolder holder = new ViewHolder(itemView,context);
        return holder;
    }

    /**
     * 通过id 获取我们想要的View
     *
     * @param layoutId
     * @param <T>
     * @return
     */
    //返回值类型是一个继承View的泛型
    public  <T extends View> T getView(int layoutId) {
        View view = mViewSparseArray.get(layoutId);
        if (view == null) {
            view = mView.findViewById(layoutId);
            mViewSparseArray.put(layoutId, view);
        }

        return (T) view;
    }

    public  ViewHolder setText(int id,String s){
        TextView textView = getView(id);
        textView.setText(s);
        return this;

    }
    public ViewHolder setImage(int id,String url){
        ImageView imageView = getView(id);
        Glide.with(context).load(url).into(imageView);
        return this;
    }

}
