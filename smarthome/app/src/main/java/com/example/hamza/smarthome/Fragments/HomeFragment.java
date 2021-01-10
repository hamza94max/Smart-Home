package com.example.hamza.smarthome.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.hamza.smarthome.R;


public class HomeFragment extends Fragment {


    public HomeFragment() {

    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch led1=v.findViewById(R.id.led1);
        Switch led2=v.findViewById(R.id.led2);
        Switch led3=v.findViewById(R.id.led3);
        Switch led4=v.findViewById(R.id.led4);
        Switch led5=v.findViewById(R.id.led5);
        return v;
    }
}