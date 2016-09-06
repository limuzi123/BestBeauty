package com.lanou3g.recycleviewpackagedemo;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dllo on 16/9/5.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder>{
    private Context context;
    private List<T> data;
    private int layoutId;
    private ViewHolder holder;
    private OnMyListener listener;

    public void setListener(OnMyListener listener) {
        this.listener = listener;
    }

    public BaseAdapter(Context context, List<T> data, int layoutId) {
        this.context = context;
        this.data = data;
        this.layoutId = layoutId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        holder = ViewHolder.createViewHolder(context,parent,layoutId);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       convert(holder,data.get(position));
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                listener.OnMyClick(view,pos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public abstract void convert(ViewHolder holder,T t);




}
