package com.example.progandro_final;

public class RecyclerViewItem {
    private int mImageResource;
    private String mTitle;
    private String mDesc;

    public RecyclerViewItem(int imageResource, String judul, String description){
        mImageResource = imageResource;
        mTitle = judul;
        mDesc = description;
    }

    public int getImageResource(){
        return mImageResource;
    }

    public String getJudul(){
        return mTitle;
    }

    public String getDescription(){
        return mDesc;
    }
}
