package com.bwei.sunyongzheng;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.sunyongzheng.fragment.FragmentOne;
import com.bwei.sunyongzheng.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private RadioGroup group;
    private List<Fragment> list=new ArrayList<>();
    private FragmentOne one;
    private FragmentTwo two;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        one=new FragmentOne();
        two=new FragmentTwo();
        list.add(one);
        list.add(two);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){

                    case 0:
                        group.check(R.id.but1);
                        break;
                    case 1:
                        group.check(R.id.but2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.but1:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        viewpager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        group = (RadioGroup) findViewById(R.id.group);
    }
}
