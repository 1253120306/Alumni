package com.example.hasee.ping;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import TimeSelector.TimeSelector;


import com.example.hasee.ping.R;

public class add_view extends AppCompatActivity {
    private TimeSelector timeSelector;
    private EditText add_view_time;
    private TimeSelector.ResultHandler resultHandler;
    private String time;
    private  ImageView add_view_to_mainactivity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.add_view);
        initview();
        init();


    }

    public void show(View v) {
        timeSelector.show();
    }
    public void initview(){
        add_view_time=findViewById(R.id.add_view_time);
        resultHandler= new TimeSelector.ResultHandler() {
            @Override
            public void handle(String time) {
                add_view_time.setText(time);
            }
        };
        timeSelector = new TimeSelector(this,resultHandler, "2015-11-27 11:33", "2019-11-29 21:54");
       add_view_to_mainactivity_button=findViewById(R.id.add_view_to_mainactivity_button);

    }
    public void init(){

        timeSelector.setScrollUnit(TimeSelector.SCROLLTYPE.YEAR,TimeSelector.SCROLLTYPE.MONTH,TimeSelector.SCROLLTYPE.DAY,TimeSelector.SCROLLTYPE.HOUR, TimeSelector.SCROLLTYPE.MINUTE);
        add_view_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSelector.show();
            }
        });

        add_view_to_mainactivity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(add_view.this, Mainactivity.class);
                startActivity(intent);
            }
        });


    }
}