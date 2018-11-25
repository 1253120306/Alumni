package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hasee.ping.R;

public class task_show extends Fragment {

    private ImageView user_photo;
    private TextView  user_name;
    private TextView task_label;
    private TextView task_title;
    private TextView task_time;
    private TextView task_content;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
         View view=inflater.inflate(R.layout.task_show_item,container,false);
         return view;
     }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
    private void init(){
        user_photo=getView().findViewById(R.id.user_photo);
        user_name=getView().findViewById(R.id.user_name);
        task_content=getView().findViewById(R.id.task_content);
        task_label=getView().findViewById(R.id.task_label);
        task_title=getView().findViewById(R.id.task_title);
        task_time=getView().findViewById(R.id.task_time);
    }
}
