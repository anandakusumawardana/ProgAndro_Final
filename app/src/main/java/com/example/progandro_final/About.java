package com.example.progandro_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class About extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, viewGroup, savedInstanceState);
            View rootView = inflater.inflate(R.layout.about_fragment, viewGroup, false);
            return rootView;
        }
    }