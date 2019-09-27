package com.example.progandro_final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerViewItem> recyclerViewItems;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1,mTextView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textViewTitle);
            mTextView2 = itemView.findViewById(R.id.textViewDesc);
        }
    }

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> recyclerViews){
        recyclerViewItems = recyclerViews;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewItem currentItem = recyclerViewItems.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getJudul());
        holder.mTextView2.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

}
