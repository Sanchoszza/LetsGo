package com.android.letsgo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.letsgo.R;
import com.android.letsgo.activity.StartActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class PersonalFragment extends Fragment {


    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }
    String name, surname, age, city, pol, phone, img;
    ImageView backArrow, avatar, exit;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;

    private TextView nameFr, surnameFr, ageFr, cityFr, phoneFr, imgFr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_personal, container, false);

        backArrow = v.findViewById(R.id.back_arrow);

        backArrow.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            startActivity(intent);
        });

        exit = v.findViewById(R.id.exit);
        exit.setOnClickListener(view -> {
            mAuth.signOut();
        });

        nameFr = v.findViewById(R.id.name);
        surnameFr = v.findViewById(R.id.surname);
        ageFr = v.findViewById(R.id.age);
        phoneFr = v.findViewById(R.id.phone);
        cityFr = v.findViewById(R.id.city);
        avatar = v.findViewById(R.id.avatar);
        initViews();
        return v;
    }

    private void initViews() {
        getInfoForPerson();
    }

    private void getInfoForPerson(){

        SharedPreferences sp = getActivity().getSharedPreferences("PERSONAL_INFO", Context.MODE_PRIVATE);

        nameFr.setText(sp.getString("name", nameFr.toString()));
        surnameFr.setText(sp.getString("surname", surnameFr.toString()));
        phoneFr.setText(sp.getString("phone", phoneFr.toString()));
        ageFr.setText(sp.getString("age", ageFr.toString()));
        cityFr.setText(sp.getString("city", cityFr.toString()));
//        Picasso.get().load(sp.getString("img", "")).into(avatar);
//        img =sp.getString("img", "");
    }
}