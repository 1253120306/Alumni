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

public class message_RecyclerAdapter extends RecyclerView.Adapter {
    private List<Map<String,String>> mapList;
    private Context context;

    public message_RecyclerAdapter(List<Map<String,String>> mapList,Context context){
        this.mapList=mapList;
        this.context=context;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        MyViewHolder myViewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.message_item,parent,false));
        return myViewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
        Map<String,String> map=mapList.get(position);
        MyViewHolder myViewHolder=(MyViewHolder) holder;
        myViewHolder.message_content.setText(map.get("message_content"));
        myViewHolder.user_name.setText(map.get("message_username"));

    }
    public int getItemCount(){
        return mapList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView user_name;
        TextView message_content;
        public MyViewHolder(View view){
            super(view);
            user_name=view.findViewById(R.id.message_username);
            message_content=view.findViewById(R.id.message_content);

        }
    }
}
