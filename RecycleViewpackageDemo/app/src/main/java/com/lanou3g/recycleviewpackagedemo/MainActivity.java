package com.lanou3g.recycleviewpackagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
         data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("ggagaggag");

        }
        BaseAdapter<String> adapter = new BaseAdapter<String>(this,data,R.layout.item) {
            @Override
            public void convert(ViewHolder holder, String s) {
//                TextView tv = holder.getView(R.id.item_id);
//                tv.setText(s);
                holder.setText(R.id.item_id,s);
                holder.setImage(R.id.img_view,"");

            }

        };
       adapter.setListener(new OnMyListener() {
           @Override
           public void OnMyClick(View view, int position) {
               Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
           }
       });
        recyclerView.setAdapter(adapter);
    }
}
