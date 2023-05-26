package com.android.letsgo.fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.letsgo.R;
import com.android.letsgo.activity.CreateTripActivity;
import com.android.letsgo.activity.StartActivity;
import com.android.letsgo.adapter.DriverAdapter;
import com.android.letsgo.db.Driver;
import com.android.letsgo.db.Passenger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class DriverFragment extends Fragment {

    public static DriverFragment newInstance() {
        return new DriverFragment();
    }

    String[] lable = { "ДОСТУПНЫЕ ПОЕЗДКИ"};
    RecyclerView rv;
    TabLayout tl;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Driver> data_driver;
    List<Passenger> data_passenger;
    ImageView addInfo, backArrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_driver, container, false);

        rv = v.findViewById(R.id.recycler_view);
        tl = v.findViewById(R.id.tab_view);
        tl.setSelectedTabIndicatorColor(ContextCompat.getColor(getContext(), R.color.color_for_reg));
        tl.setTabIndicatorFullWidth(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Data");
        addInfo = v.findViewById(R.id.add);
        addInfo.setOnClickListener(view->{
            Intent i = new Intent(getActivity(), CreateTripActivity.class);
            i.putExtra("type_info", 1);
            startActivity(i);
        });
        backArrow = v.findViewById(R.id.back_arrow);

        backArrow.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            startActivity(intent);
        });
        initViews();
        getDriver();
        return v;
    }

    private void initViews() {
        for (int i = 0; i < lable.length; i++) {
            tl.addTab(tl.newTab().setText(lable[i]));
        }
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getDriver();
                        break;
                    case 1:
//                        getPassenger();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void getPassenger() {

//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        CollectionReference collectionRef = db.collection("WorkingNeedData");
//
//        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    List<NeedWorking> data_need = new ArrayList<>();
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        String name = document.getString("name");
//                        String surname = document.getString("surname");
//                        String anim = document.getString("animals");
//                        String poroda = document.getString("poroda");
//                        String days = document.getString("days");
//                        String phone = document.getString("phone");
//                        String address = document.getString("address");
//                        NeedWorking animal = new NeedWorking(name, surname,phone,address,anim,poroda,days);
//                        data_need.add(animal);
//                    }
//
////                    PoteryashkiAnimalsAdapter adapter = new PoteryashkiAnimalsAdapter(getContext(), animalsList);
//                    NeedWorkAdapter adapter = new NeedWorkAdapter(getContext(), data_need);
//                    rv.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    rv.setAdapter(adapter);
//
//                } else {
//                    Log.d(TAG, "Ошибка при получении данных из Firestore: " + task.getException());
//                }
//            }
//        });
    }

    private void getDriver() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference collectionRef = db.collection("DriverData");

        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<Driver> data = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("name");
                        String surname = document.getString("surname");
                        String cityFrom = document.getString("cityFrom");
                        String cityTo = document.getString("cityTo");
                        String experience = document.getString("experience");
                        String phone = document.getString("phone");
                        String car = document.getString("car");
                        String carNumber = document.getString("carNumber");
                        String description = document.getString("description");
                        String price = document.getString("price");
                        String countPassenger = document.getString("countPassenger");
                        String date = document.getString("date");
                        String img = document.getString("imgURL");
                        String imgCar = document.getString("imgCarUrl");
                        Driver driver = new Driver(name, surname, cityFrom, cityTo, experience, phone,
                                car, carNumber, description, countPassenger, date, img, price, imgCar);
                        data.add(driver);
                    }

                    DriverAdapter adapter = new DriverAdapter(getContext(), data);
                    rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rv.setAdapter(adapter);

                } else {
                    Log.d(TAG, "Ошибка при получении данных из Firestore: " + task.getException());
                }
            }
        });
    }
}