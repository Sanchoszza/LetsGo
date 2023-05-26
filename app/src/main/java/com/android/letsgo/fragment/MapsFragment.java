package com.android.letsgo.fragment;

import android.Manifest;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.letsgo.R;

public class MapsFragment extends Fragment {

//    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 859;
//    private GoogleMap googleMap;
//    String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
//    Double lan, lon;
//    LocationManager locationManager;

    public static MapsFragment newInstance() {
        return new MapsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }
}