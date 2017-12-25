package com.example.guozhenwei20171123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    private GridView gridView1;
    private GridView gridView2;
    private Myadpater md;
    private Myadpater2 md2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //获取控件
        gridView1 = (GridView) findViewById(R.id.g1);
        md = new Myadpater();
        gridView1.setAdapter(md);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list1.remove(i);
                md.notifyDataSetChanged();


            }
        });


        gridView2 = findViewById(R.id.g2);
        md2 = new Myadpater2();
        gridView2.setAdapter(md2);
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = list2.get(i);
                list1.add(s);
                md2.notifyDataSetChanged();
                md.notifyDataSetChanged();

            }
        });

        //初始化数据
        initData();
    }

    private void initData() {
        list1.add("科技");
        list1.add("视频");
        list1.add("数码");
        list1.add("汽车");
        list1.add("问答");

        list2.add("时尚");
        list2.add("历史");
        list2.add("手机");
        list2.add("旅游");
        list2.add("三农");

    }

    //我的适配器
    private class Myadpater extends BaseAdapter {
        @Override
        public int getCount() {
            return list1.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= View.inflate(Main2Activity.this,R.layout.datatext1,null);
            TextView viewById = view.findViewById(R.id.t1);
            viewById.setText(list1.get(i));
            return view;
        }
    }

    private class Myadpater2 extends BaseAdapter {
        @Override
        public int getCount() {
            return list2.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= View.inflate(Main2Activity.this,R.layout.datatext2,null);
            TextView viewById = view.findViewById(R.id.t2);
            viewById.setText(list2.get(i));
            return view;
        }
    }
}
