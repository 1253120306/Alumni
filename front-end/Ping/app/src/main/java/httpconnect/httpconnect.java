package httpconnect;

import android.content.Intent;
import android.os.Looper;
import android.os.StrictMode;
import android.widget.Toast;

import com.example.hasee.ping.Login;
import com.example.hasee.ping.Mainactivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class httpconnect {

    private  String post(String url,Map<String,String> map) {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
                PrintWriter out = null;
                BufferedReader in = null;
                String result = "";
                HttpURLConnection conn = null;
    //    http://192.168.191.1:8080/pinserver/service/Register
                try {
                    //设置url
                    URL realUrl = new URL(url);
                    conn = (HttpURLConnection) realUrl.openConnection();
                    //设置发送请求属性
                    conn.setRequestProperty("accept", "*/*");
                    conn.setRequestProperty("connection", "Keep-Alive");
                    conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1   ;SV1)");
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoInput(true);
                    //out为输出流
                    out = new PrintWriter(conn.getOutputStream());
                    String data = "";
                    //map集合里放的是请求数据
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        data += entry.getKey() + "=" + entry.getValue() + "&";
                    }

                    out.print(data);
                    out.flush();
                    //in为服务器返回的响应
                    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        result += line;
                    }
                    result=JSON_into_data(result);
                    if ( result.equals("username already exist")) {
                        //Looper.prepare();
                        Toast.makeText(MainContext.getContext(), "用户已存在", Toast.LENGTH_SHORT).show();
                        //Looper.loop();
                    }else if(result.equals("注册失败")){
                        Toast.makeText(MainContext.getContext(), "连接失败", Toast.LENGTH_SHORT).show();
                    }else{
                        //Looper.prepare();
                        Toast.makeText(MainContext.getContext(), result+"", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainContext.getContext(), data+"", Toast.LENGTH_SHORT).show();
                       // Looper.loop();
                    }
                } catch (Exception e) {
                    Looper.prepare();
                    System.out.println("发送异常" + e);
                    e.printStackTrace();
                    Looper.loop();
                } finally {
                    try {
                        if (out != null)
                            out.close();
                        if (in != null)
                            in.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    if (conn != null) {
                        conn.disconnect();
                    }

                }
              return result;
            }


    private  String login(String url,Map<String,String> map) {
        //new Thread(new Runnable() {
        // public void run() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        PrintWriter out = null;
        BufferedReader in = null;
        String result ="" ;
        HttpURLConnection conn = null;
        //"http://192.168.191.1:8080/pinserver/service/Login"
        try {
            //设置url
            URL realUrl = new URL(url );
            conn = (HttpURLConnection) realUrl.openConnection();
            //设置发送请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1   ;SV1)");
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoInput(true);
            //out为输出流
            out = new PrintWriter(conn.getOutputStream());
            String data = "";
            //map集合里放的是请求数据
            for (Map.Entry<String, String> entry : map.entrySet()) {
                data += entry.getKey() + "=" + entry.getValue() + "&";
            }

            out.print(data);
            out.flush();
            //in为服务器返回的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            result=JSON_into_data(result);
            if ( result.equals("successul")) {
                //Looper.prepare();
                Toast.makeText(MainContext.getContext(), "登录成功！", Toast.LENGTH_SHORT).show();
                // Looper.loop();
            }else if(result.equals("连接异常")){
                Toast.makeText(MainContext.getContext(), "连接失败", Toast.LENGTH_SHORT).show();
            }else if (result.equals("服务器异常")) {
                Toast.makeText(MainContext.getContext(), "服务器异常", Toast.LENGTH_SHORT).show();
            }else if (result.equals("error username or password")) {
                Toast.makeText(MainContext.getContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            // Looper.prepare();
            System.out.println("发送异常" + e);
            e.printStackTrace();
            // Looper.loop();
        } finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();


            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (conn != null) {
                conn.disconnect();
            }

        }
         return result;
    }
    //}//).start();
    // }

    //数据解析
    private String JSON_into_data (String jsonData){
        String result=null;
        try
        {
            JSONObject jsonObject=new JSONObject(jsonData);
            result=jsonObject.getString("result");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }


}
