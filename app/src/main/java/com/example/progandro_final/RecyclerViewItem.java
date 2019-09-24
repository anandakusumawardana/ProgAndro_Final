package com.example.progandro_final;

public class RecyclerViewItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public RecyclerViewItem(int imageResource, String text1, String text2){
        mImageResource = imageResource;
        text1 = mText1;
        text2 = mText2;
    }

    public int getImageResource(){
        return mImageResource;
    }

    public String getText1(){
        return mText1;
    }

    public String getText2(){
        return mText2;
    }
}
