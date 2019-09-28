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

    public void setFoto(){
        this.mImageResource = mImageResource;
    }

    public String getJudul(){

        return mTitle;
    }

    public void setNama(String mTitle){
        this.mTitle = mTitle;
    }

    public String getDescription(){

        return mDesc;
    }

    public void setDescription(){
        this.mDesc = mDesc;
    }
}
