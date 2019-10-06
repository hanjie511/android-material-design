package com.example.navigationview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {
    private final int TYPE_NORMAL=0;
    private final int TYPE_FOOT=1;

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
    public MyAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        VH vh=null;
        if(i==TYPE_NORMAL){//为普通itemViewType时，返回普通itemView的ViewHolder
            View view= LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
            vh=new VH(view);
        }else if(i==TYPE_FOOT){//不为普通itemViewType时，返回footerItemView的ViewHolder
                View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footer_view,viewGroup,false);
                vh=new VH(view);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, int i) {
        if(getItemViewType(i)==TYPE_NORMAL){//不为footerItemView时才进行数据绑定
            VH vh=(VH)viewHolder;
            String path=list.get(i);
            Glide.with(context).load(path).into(vh.image);
        }

    }

    @Override
    public int getItemCount() {//为了显示footerView要多返回一个item
        if(list.size()>0){
            return list.size()+1;
        }else{
            return  0;
        }
    }

    @Override
    public int getItemViewType(int position) {//根据返回的itemViewType去执行onCreateViewHolder和onBindViewHolder方法
        if(position+1==getItemCount()){
            return TYPE_FOOT;
        }else{
            return  TYPE_NORMAL;
        }
    }
}
