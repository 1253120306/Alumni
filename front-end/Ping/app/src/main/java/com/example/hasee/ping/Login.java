package com.example.hasee.ping;

import android.content.Intent;
import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;
import httpconnect.MainContext;

public class Login extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private TextView zhuce_Button;
    private Button  landing_Button;
    private Map<String,String> map=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);//防重绘状态栏时卡顿
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);//状态栏透明
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        //加载通讯客户端
        JMessageClient.setDebugMode(true);
        JMessageClient.init(this);

        password = findViewById(R.id.passerword);
        userName = findViewById(R.id.userName);
        zhuce_Button = findViewById(R.id.validateNum_btn);
        landing_Button = findViewById(R.id.landing_btn);
        landing_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "正在登录", Toast.LENGTH_SHORT).show();
                String str1 = userName.getText().toString();
                String str2 = password.getText().toString();
                if (str1.equals("") || str2.equals("")) {
                    Toast.makeText(Login.this, "用户名或者密码为空", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Login.this, str1 + " ", Toast.LENGTH_SHORT).show();
                } else {
                    //集合放入数据
                    if(map.containsKey("username")){
                        map.remove("username");
                        map.remove("password");
                        map.put("username", userName.getText().toString());
                        map.put("password", password.getText().toString());

                    }
                    else{
                        map.put("username", userName.getText().toString());
                        map.put("password", password.getText().toString());

                    }
                    BasicCallback callback = new BasicCallback() {
                        @Override
                        public void gotResult(int i, String s) {
                            if (i == 0) {
                                Toast.makeText(Login.this, "登录成功", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent();
                                intent.setClass(Login.this, Mainactivity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(Login.this, s, Toast.LENGTH_SHORT).show();
                        }
                    };
                    JMessageClient.login(str1, str2,callback);
                    }

                //Intent intent = new Intent();
                //intent.setClass(Login.this, Mainactivity.class);
               // startActivity(intent);
            }
        });
        zhuce_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "正在注册", Toast.LENGTH_SHORT).show();
                String str1 = userName.getText().toString();
                String str2 = password.getText().toString();
                if (str1.equals("") || str2.equals("")) {
                    Toast.makeText(Login.this, "用户名或者密码为空", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Login.this, str1 + " ", Toast.LENGTH_SHORT).show();
                } else {
                    //集合放入数据
                    if(map.containsKey("username")){
                        map.remove("username");
                        map.remove("password");
                        map.put("username", userName.getText().toString());
                        map.put("password", password.getText().toString());
                    }
                    else {
                        map.put("username", userName.getText().toString());
                        map.put("password", password.getText().toString());


                    }
              BasicCallback callback = new BasicCallback() {
                        @Override
                        public void gotResult(int i, String s) {
                            if (i == 0)
                                Toast.makeText(Login.this,  "注册成功", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(Login.this, s, Toast.LENGTH_SHORT).show();
                        }
                    };
                    JMessageClient.register(userName.getText().toString(), password.getText().toString(), callback);;
                }
            }
        });

    }





}
