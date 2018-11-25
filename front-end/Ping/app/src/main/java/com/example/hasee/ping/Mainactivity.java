package com.example.hasee.ping;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import adapter.mainactivity_ViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;

import fragment.homepage;
import fragment.message_view;
import fragment.my_view;
import fragment.record_view;

public class Mainactivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout l1;//首页按钮
    private LinearLayout l2;//信息按钮
    private LinearLayout l3;//记录按钮
    private LinearLayout l4;//我的按钮
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private ImageView i1;
    private ImageView i2;
    private ImageView i3;
    private ImageView i4;
    private ImageView i5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);//防重绘状态栏时卡顿
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);//状态栏透明
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initview();
        init();

    }

    public  void initview() {
        l1=findViewById(R.id.mainactivity_l1);
        l2=findViewById(R.id.mainactivity_l2);
        l3=findViewById(R.id.mainactivity_l3);
        l4=findViewById(R.id.mainactivity_l4);
        t1=findViewById(R.id.mainactivity_t1);
        t2=findViewById(R.id.mainactivity_t2);
        t3=findViewById(R.id.mainactivity_t3);
        t4=findViewById(R.id.mainactivity_t4);
        i1=findViewById(R.id.mainactivity_i1);
        i2=findViewById(R.id.mainactivity_i2);
        i3=findViewById(R.id.mainactivity_i3);
        i4=findViewById(R.id.mainactivity_i4);
        l1.setOnClickListener(new MyOnClickListenner(0));
        l2.setOnClickListener(new MyOnClickListenner(1));
        l3.setOnClickListener(new MyOnClickListenner(2));
        l4.setOnClickListener(new MyOnClickListenner(3));
        t1.setSelected(true);
        i1.setSelected(true);
        t5=t1;
        i5=i1;
        viewPager = findViewById(R.id.mainactivity_Viewpager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) { changeTab(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new homepage());
        fragments.add(new message_view());
        fragments.add(new record_view());
        fragments.add(new my_view());
        mainactivity_ViewPagerAdapter fragmentAdapter=new mainactivity_ViewPagerAdapter(fragmentManager,fragments);
        viewPager.setAdapter(fragmentAdapter);
    }
    public void init(){
        viewPager = findViewById(R.id.mainactivity_Viewpager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) { changeTab(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new homepage());
        fragments.add(new message_view());
        fragments.add(new record_view());
        fragments.add(new my_view());
        mainactivity_ViewPagerAdapter fragmentAdapter=new mainactivity_ViewPagerAdapter(fragmentManager,fragments);
        viewPager.setAdapter(fragmentAdapter);

    }
    //viewPager 相关函数
    public class MyOnClickListenner implements View.OnClickListener{
        private  int index =0;
        public MyOnClickListenner(int i){
            index=i;
        }
        public void onClick(View v){
            viewPager.setCurrentItem(index);

        }

    }
    private void changeTab(int id){
        t5.setSelected(false);
        i5.setSelected(false);
        switch (id){
            case R.id.mainactivity_l1:viewPager.setCurrentItem(0);
            case 0:
                t1.setSelected(true);
                i1.setSelected(true);
                i5=i1;
                t5=t1;
                break;
            case R.id.mainactivity_l2:viewPager.setCurrentItem(1);
            case 1:
                t2.setSelected(true);
                i2.setSelected(true);
                i5=i2;
                t5=t2;
                break;
            case R.id.mainactivity_l3:viewPager.setCurrentItem(2);
            case 2:
                t3.setSelected(true);
                i3.setSelected(true);
                i5=i3;
                t5=t3;
                break;
            case R.id.mainactivity_l4:viewPager.setCurrentItem(3);
            case 3:
                t4.setSelected(true);
                i4.setSelected(true);
                i5=i4;
                t5=t4;
                break;
            default:break;
        }
    }

}
