package com.example.guozhenwei20171123.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guozhenwei20171123.Main2Activity;
import com.example.guozhenwei20171123.R;

import java.util.ArrayList;

public class Frag1 extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    private TextView tiao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_frag1, null);

        //获取控件
        tabLayout = (TabLayout) view.findViewById(R.id.table);
        viewPager = (ViewPager) view.findViewById(R.id.vp);
        tiao = (TextView) view.findViewById(R.id.tiao);

        //初始化数据
        initData();

        Myadpater md = new Myadpater(getChildFragmentManager());
        viewPager.setAdapter(md);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);//居中显示
        tabLayout.setupWithViewPager(viewPager);//关联

        //点击跳转事件
         intentMain2();
        return view;
    }

    private void intentMain2() {
        tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    //初始化数据
    private void initData() {
        fragments.add(new Frag1_1());
        fragments.add(new Frag1_2());
        fragments.add(new Frag1_3());
        fragments.add(new Frag1_4());
        fragments.add(new Frag1_5());
        fragments.add(new Frag1_6());
        fragments.add(new Frag1_7());
        fragments.add(new Frag1_8());

        list.add("头条");
        list.add("社会");
        list.add("国内");
        list.add("国际");
        list.add("娱乐");
        list.add("体育");
        list.add("军事");
        list.add("国际");
    }

    //适配器
    private class Myadpater extends FragmentPagerAdapter {
        public Myadpater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }
}
