package com.example.progandro_final;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewAdapter extends FragmentPagerAdapter {

    private Fragment[] activities;
    private String fr1 = "Home";
    private String fr2 = "About";

    public ViewAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        activities = new Fragment[]{
                new Homepage(),
                new Fragment()
        };
    }

    @Override
    public Fragment getItem(int position) {
        return activities[position];
    }

    @Override
    public int getCount(){
        return activities.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        String title = getItem(position).getClass().getName();
        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
    }

}
