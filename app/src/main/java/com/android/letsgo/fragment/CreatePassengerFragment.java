package com.android.letsgo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.letsgo.R;

public class CreatePassengerFragment extends Fragment {

    public static CreatePassengerFragment newInstance() {
        return new CreatePassengerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_passenger, container, false);
    }
}