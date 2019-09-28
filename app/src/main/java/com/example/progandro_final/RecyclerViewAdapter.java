package com.example.progandro_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<RecyclerViewItem> recyclerViewItemList;

    public RecyclerViewAdapter(Context mContext, List<RecyclerViewItem> recyclerViewItemList){
        this.mContext = mContext;
        this.recyclerViewItemList = recyclerViewItemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.movie_item,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.judul.setText(recyclerViewItemList.get(position).getJudul());
        holder.descMovie.setText(recyclerViewItemList.get(position).getDescription());
        holder.img.setImageResource(recyclerViewItemList.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return recyclerViewItemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView judul;
        private TextView descMovie;
        private ImageView img;
        public MyViewHolder(View itemView){
            super(itemView);

            judul = (TextView) itemView.findViewById(R.id.textViewTitle);
            descMovie = (TextView) itemView.findViewById(R.id.textViewDesc);
            img = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
