package com.example.progandro_final;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends Fragment {
    private RecyclerView recyclerView;
    private List<RecyclerViewItem> recyclerViewItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        super.onCreateView(inflater,viewGroup,savedInstanceState);
        View rootView = inflater.inflate(R.layout.home_fragment, viewGroup, false);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recycleViewAdapter = new RecyclerViewAdapter(getContext(),recyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_movie,"Avengers","Heroes of Earth"));
    }
}
