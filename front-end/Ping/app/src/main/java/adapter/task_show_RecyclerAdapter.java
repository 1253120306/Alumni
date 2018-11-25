package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasee.ping.R;

import java.util.List;
import java.util.Map;

public class task_show_RecyclerAdapter extends RecyclerView.Adapter {
    private List<Map<String,String>> mapList;
    private Context context;

    public task_show_RecyclerAdapter(List<Map<String,String>> mapList,Context context){
        this.mapList=mapList;
        this.context=context;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        MyViewHolder myViewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.task_show_item,parent,false));
        return myViewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
        Map<String,String> map=mapList.get(position);
        MyViewHolder myViewHolder=(MyViewHolder) holder;
        myViewHolder.task_content.setText(map.get("task_content"));
        myViewHolder.user_name.setText(map.get("user_name"));
        myViewHolder.task_time.setText(map.get("task_time"));
        myViewHolder.task_label.setText(map.get("task_label"));
        myViewHolder.task_title.setText(map.get("task_title"));

    }
    public int getItemCount(){
        return mapList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
                TextView user_name;
                TextView task_label;
                TextView task_title;
                TextView task_time;
                TextView task_content;
                LinearLayout ping_Button;
                public MyViewHolder(View view){
                    super(view);
                    user_name=view.findViewById(R.id.user_name);
                    task_content=view.findViewById(R.id.task_content);
                    task_label=view.findViewById(R.id.task_label);
                    task_title=view.findViewById(R.id.task_title);
                    task_time=view.findViewById(R.id.task_time);
                    ping_Button=view.findViewById(R.id.ping_Button);
                    ping_Button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(),"我是Ping"+mapList.get(2).get("user_name").toString(),Toast.LENGTH_SHORT).show();
                        }
                    });

                }
    }
}
