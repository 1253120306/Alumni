package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hasee.ping.R;
import com.example.hasee.ping.my_task;
import com.example.hasee.ping.user_information;

import TimeSelector.TimeSelector;

public class my_view extends Fragment {
    private TimeSelector timeSelector;
    private LinearLayout user_information_enter;
    private LinearLayout my_task_button;//我发布的按钮
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.my_view,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        init();

    }
    public void initview(){
        user_information_enter=getView().findViewById(R.id.user_information_enter);
        my_task_button=getView().findViewById(R.id.my_task_button);
    }
    public void init(){
        user_information_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getContext(),user_information.class);
                startActivity(intent);
            }
        });
        my_task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getContext(),my_task.class);
                startActivity(intent);
            }
        });
    }
}