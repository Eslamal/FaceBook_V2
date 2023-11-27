package com.example.facebook_v2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook_v2.R;
import com.example.facebook_v2.model.Posts;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
List<Posts>arrayList=new ArrayList<>();
    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
     Posts posts=arrayList.get(position);
     holder.textView.setText(posts.getTitle());
     holder.textView2.setText(posts.getId());
     holder.textView3.setText(posts.getContent());
    }
    public void setList(List<Posts>postsList){
        this.arrayList=postsList;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        TextView textView ,textView2,textView3;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
        }
    }
}
