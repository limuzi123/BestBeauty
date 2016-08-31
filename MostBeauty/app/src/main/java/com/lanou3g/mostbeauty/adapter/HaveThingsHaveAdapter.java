package com.lanou3g.mostbeauty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lanou3g.mostbeauty.Bean.HaveThingsHaveBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;

/**
 * Created by dllo on 16/8/31.
 * 布局只有一个ListView
 */
public class HaveThingsHaveAdapter extends BaseAdapter {
    private Context context;
    private String[] id;
    private HaveThingsHaveItemAdapter adapter;

    public HaveThingsHaveAdapter(Context context) {
        this.context = context;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return id.length;
    }

    @Override
    public Object getItem(int position) {
        return id[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_have_things_have, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        getNetData(id[position], holder);
        // TODO: 16/8/31 listView第一个有尾布局 都有头布局
        return convertView;
    }


    public class ViewHolder {
        private ListView listView;

        public ViewHolder(View view) {
            listView = (ListView) view.findViewById(R.id.adapter_have_things_have_lv);

        }
    }

    private void getNetData(String id, final ViewHolder holder) {
        String url = API.Have_Things_Have_Adapter +
                id +
                API.Have_Things_Have_Adapter_End;
        NetTool.getInstance().startRequest(url, HaveThingsHaveBean.class
                , new onHttpCallBack<HaveThingsHaveBean>() {
                    @Override
                    public void onSuccess(HaveThingsHaveBean response) {
                        // TODO: 16/8/31 绑适配器
                        adapter = new HaveThingsHaveItemAdapter(context);
                        adapter.setBean(response);
                        holder.listView.setAdapter(adapter);
                        setListViewHeightBasedOnChildren(holder.listView);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    /**
     * 重新计算高度
     * 一定要在setAdapter后调用
     *
     * @param listView
     */
    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1)) + 5;
        listView.setLayoutParams(params);
    }

}
