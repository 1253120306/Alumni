package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import adapter.task_show_RecyclerAdapter;

import com.example.hasee.ping.R;
import com.example.hasee.ping.add_view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class homepage extends Fragment {
    private ImageView add_view_button;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.homepage_view,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        init();
    }
    public void initview(){
        add_view_button=getView().findViewById(R.id.add_view_button);

    }
    public void init(){

        List<Map<String,String> > mapList=new ArrayList<>();
        Map<String,String>  map;
        for(int i=0;i<5;i++){
            map=new HashMap<>();
            map.put("user_name",i+"号同学");
            map.put("task_label","外卖");
            map.put("task_title","task_title号同学");
            map.put("task_time","12:00-13:00");
            map.put("task_content","我是"+i+"task_content");
            mapList.add(map);
        }
       task_show_RecyclerAdapter recyclerAdapter=new task_show_RecyclerAdapter(mapList,getContext());
        RecyclerView recyclerView=getView().findViewById(R.id.homepage_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);

        add_view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getContext(),add_view.class);
                startActivity(intent);
            }
        });
    }
}
