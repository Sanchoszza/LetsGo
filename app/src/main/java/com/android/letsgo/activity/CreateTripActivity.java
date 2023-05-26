package com.android.letsgo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.android.letsgo.R;
import com.android.letsgo.fragment.CreateDriverFragment;
import com.android.letsgo.fragment.CreatePassengerFragment;

public class CreateTripActivity extends AppCompatActivity {

    FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);

        container = findViewById(R.id.container);

        Bundle b = getIntent().getExtras();
        if(b.getInt("type_info") == 0){
            replaceFragment(CreateDriverFragment.newInstance(), false);
        }
//        else if (b.getInt("type_info") == 1) {
//            replaceFragment(CreatePassengerFragment.newInstance(), false);
//        }
    }
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}