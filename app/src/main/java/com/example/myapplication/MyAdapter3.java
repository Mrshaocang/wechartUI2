package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {

    private List<Map<String,Object>> data;

    private Context context;
    private View inflater;
    public MyAdapter3(Context context,List<Map<String,Object>> data){
        this.data = data;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item_dome,viewGroup,false);
        MyViewHolder myviewholder=new MyViewHolder(inflater);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position ){
        holder.title.setText(data.get(position).get("标题").toString());
        holder.content.setText(data.get(position).get("简介").toString());
        holder.head_port.setImageResource((int)(data.get(position).get("头像")));
        holder.tipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("scc",(int)data.get(position).get("头像"));
                intent.putExtra("名字",data.get(position).get("简介").toString());
                intent.putExtra("介绍",data.get(position).get("介绍").toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView content;
        ImageView head_port;
        LinearLayout tipView;
        public MyViewHolder(View itemView) {
            super(itemView);
            head_port = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title_textview);
            content = itemView.findViewById(R.id.introduction_textview);
            tipView = itemView.findViewById(R.id.news_item);
        }
    }
}
