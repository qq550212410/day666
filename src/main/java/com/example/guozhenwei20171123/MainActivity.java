package com.example.guozhenwei20171123;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.guozhenwei20171123.Fragment.Frag1;
import com.example.guozhenwei20171123.Fragment.Frag2;
import com.example.guozhenwei20171123.Fragment.Frag3;
import com.example.guozhenwei20171123.Fragment.Frag4;

public class MainActivity extends AppCompatActivity {


    private RadioGroup group;
    private FragmentManager manager;
    private FragmentTransaction ft1;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        group = (RadioGroup) findViewById(R.id.group);
        //获取控制
        manager = getSupportFragmentManager();
        ft1 = manager.beginTransaction();
        frag1 = new Frag1();


        ft1.add(R.id.fl, frag1).commit();//添加默认界面

        //监听事件
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                hideFragment();
                FragmentTransaction ft2 = manager.beginTransaction();
                switch (i) {
                    case R.id.but1:
                        ft2.show(frag1).commit();
                        break;
                    case R.id.but2:
                        if (frag2 == null) {
                            frag2 = new Frag2();
                            ft2.add(R.id.fl, frag2).commit();
                        } else {
                            ft2.show(frag2).commit();
                        }

                        break;
                    case R.id.but3:
                        if (frag3 == null) {
                            frag3 = new Frag3();
                            ft2.add(R.id.fl, frag3).commit();
                        } else {
                            ft2.show(frag3).commit();
                        }

                        break;
                    case R.id.but4:
                        if (frag4 == null) {
                            frag4 = new Frag4();
                            ft2.add(R.id.fl, frag4).commit();
                        } else {
                            ft2.show(frag4).commit();
                        }


                        break;

                }
            }
        });


    }

    public void hideFragment() {
        FragmentTransaction ft3 = manager.beginTransaction();
        if (frag1 != null && frag1.isAdded()) {
            ft3.hide(frag1);
        }
        if (frag2 != null && frag2.isAdded()) {
            ft3.hide(frag2);
        }
        if (frag3 != null && frag3.isAdded()) {
            ft3.hide(frag3);
        }
        if (frag4 != null && frag4.isAdded()) {
            ft3.hide(frag4);
        }
        ft3.commit();
    }

}
