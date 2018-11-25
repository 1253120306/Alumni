package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasee.ping.R;
import adapter.message_RecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class message_view  extends Fragment {
    private RecyclerView message_view_recycler;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.message_view,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        init();
    }
    public void initview(){
        message_view_recycler=getView().findViewById(R.id.message_view_recycler);
    }
    public void init(){

        List<Map<String,String>> mapList=new ArrayList<>();
        Map<String,String>  map;
        for(int i=0;i<5;i++){
            map=new HashMap<>();
            map.put("message_username",i+"号同学");
            map.put("message_content","人或有一死，或轻于鸿毛，或重于泰山");
            mapList.add(map);
        }
         message_RecyclerAdapter recyclerAdapter=new message_RecyclerAdapter(mapList,getContext());

        message_view_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        message_view_recycler.setAdapter(recyclerAdapter);
      }


}