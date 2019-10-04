package com.example.navigationview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {
    ArrayList<String> list=null;
    int layout=0;
    Context context;
    static class VH extends RecyclerView.ViewHolder{
        ImageView image;
        public VH(View view){
            super(view);
            image=view.findViewById(R.id.imageView);
        }
    }
    public MyAdapter(ArrayList<String> list, int layout, Context context){
        this.list=list;
        this.layout=layout;
        this.context=context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        VH vh=new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        String path=list.get(i);
        System.out.println("path:"+path);
        Glide.with(context).load(path).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
