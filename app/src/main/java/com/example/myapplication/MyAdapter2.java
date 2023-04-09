package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.myViewHolder> {

    private List<Friend> list;
    private Context context;
    private View inflater;

    public MyAdapter2(List<Friend> friendList) {
        list = friendList;
    }

    @NonNull
    @Override
    public MyAdapter2.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dome2,parent,false);
        myViewHolder myViewHolder = new myViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.myViewHolder holder, int position) {
        Friend friend = list.get(position);
        holder.friendImage.setImageResource(friend.getImageId());
        holder.friendName.setText(friend.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        View friendView;
        ImageView friendImage;
        TextView friendName;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            friendView = itemView;
            friendImage = itemView.findViewById(R.id.imageViewPlayerPicture);
            friendName = itemView.findViewById(R.id.textViewPlayerName);
        }
    }

}
