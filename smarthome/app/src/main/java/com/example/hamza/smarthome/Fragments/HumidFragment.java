package com.example.hamza.smarthome.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hamza.smarthome.R;


public class HumidFragment extends Fragment {


    public HumidFragment() {
        // Required empty public constructor
    }


    public static HumidFragment newInstance() {
        HumidFragment fragment = new HumidFragment();
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
        return inflater.inflate(R.layout.fragment_humid, container, false);
    }
}