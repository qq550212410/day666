package com.example.guozhenwei20171123.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guozhenwei20171123.Bean.Toutiao1;
import com.example.guozhenwei20171123.R;
import com.example.guozhenwei20171123.Utile.NetUtil;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WangZhiQiang on 2017/11/23.
 */

public class Frag1_1 extends Fragment {
    public String urlToutiao = "http://www.93.gov.cn/93app/data.do?channelId=0&startNum=1";
    ArrayList<Toutiao1.DataBean> list = new ArrayList<>();
    private ListView lv1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_1, null);
        //获取控件
        lv1 = (ListView) view.findViewById(R.id.lv1);
        getData();//获取数据
        Myadpater md = new Myadpater();
        lv1.setAdapter(md);
        return view;
    }

    //获取数据
    private void getData() {
        new MyAsynctask().execute(urlToutiao);
    }

    private class Myadpater extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                 view = View.inflate(getActivity(), R.layout.data1, null);
            }
            TextView tv = view.findViewById(R.id.text1);
            tv.setText(list.get(i).getTITLE());
            ImageView img = view.findViewById(R.id.img1);
            ImageLoader.getInstance().displayImage((String) list.get(i).getIMAGEURL(),img);
            return view;
        }
    }

    //解析数据
    private class MyAsynctask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            return NetUtil.getNetJson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Toutiao1 toutiao1 = gson.fromJson(s, Toutiao1.class);
            List<Toutiao1.DataBean> data = toutiao1.getData();

            list.addAll(data);
        }
    }
}
