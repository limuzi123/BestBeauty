package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.mostbeauty.Bean.HaveThingsHaveBean;
import com.lanou3g.mostbeauty.R;

/**
 * Created by dllo on 16/9/1.
 */
public class HaveThingsHaveChooseAdapter extends BaseAdapter {
    private HaveThingsHaveBean bean;
    private Context context;

    public HaveThingsHaveChooseAdapter(Context context) {
        this.context = context;
    }

    public void setBean(HaveThingsHaveBean bean) {
        this.bean = bean;
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
            convertView= LayoutInflater.from(context).inflate(R.layout.adapter_have_things_have_foot_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(position+1+"");
        holder.textView.getPaint().setFakeBoldText(true);//字体加粗
        return convertView;
    }
    public class ViewHolder{
        private TextView textView;
        public ViewHolder(View view) {
            textView= (TextView) view.findViewById(R.id.adapter_have_things_have_foot_item_tv);
        }
    }
}
