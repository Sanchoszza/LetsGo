package com.android.letsgo.fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.letsgo.R;
import com.android.letsgo.activity.StartActivity;
import com.android.letsgo.db.Driver;
import com.android.letsgo.db.Passenger;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateDriverFragment extends Fragment {

    LinearLayout experience_line, price_line, car_line,car_number_line,
            place_line, description_line, count_passenger_line, date_line;
    TabLayout tl;
    Button addPhoto, addZapis;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseFirestore db;

    String nameS,surnameS, phoneS, experienceS, cityFromS, cityToS, priceS, carS, carNumberS,
            descriptionS, countPlaceS, fromS, toWS, imgUrlS, imgCarUrlS, countPassengerS, dateS;
    EditText nameET, surnameET, phoneET ,experienceET, cityET, priceET, carET, carNumberET,
            countPlaceET, cityFromET, cityTowET, descriptionET, countPassengerET, dateET;
    ImageView backArrow;
    String[] labels = {"ИЩУ ПОПУТЧИКОВ","ИЩУ ПОЕЗДКУ"};

    public static CreateDriverFragment newInstance() {
        return new CreateDriverFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_driver, container, false);

        tl = v.findViewById(R.id.tab_view);
        tl.setSelectedTabIndicatorColor(ContextCompat.getColor(getContext(), R.color.color_for_reg));
        tl.setTabIndicatorFullWidth(true);
        backArrow = v.findViewById(R.id.back_arrow);

        nameET = v.findViewById(R.id.name_uesr);
        surnameET = v.findViewById(R.id.surname_uesr);
        phoneET = v.findViewById(R.id.phone_user);
        experienceET = v.findViewById(R.id.exp);
        carET =v.findViewById(R.id.car);
        carNumberET = v.findViewById(R.id.car_number_line);
        addZapis = v.findViewById(R.id.add_zapis);
        addPhoto = v.findViewById(R.id.add_photo);

        descriptionET = v.findViewById(R.id.description);
        countPlaceET = v.findViewById(R.id.count_place);
        cityET = v.findViewById(R.id.city);
        priceET = v.findViewById(R.id.price);
        cityFromET = v.findViewById(R.id.start_address);
        cityTowET = v.findViewById(R.id.finish_address);
        countPassengerET = v.findViewById(R.id.count_passenger);
        dateET = v.findViewById(R.id.date);

        experience_line = v.findViewById(R.id.experience_line);
        price_line = v.findViewById(R.id.price_line);
        car_line = v.findViewById(R.id.car_line);
        car_number_line = v.findViewById(R.id.car_number_line);
        place_line = v.findViewById(R.id.place_line);
        description_line = v.findViewById(R.id.description_line);
        count_passenger_line = v.findViewById(R.id.count_passenger_line);
        date_line = v.findViewById(R.id.date_line);

        backArrow.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            startActivity(intent);
        });
        initViews();
        addDriverTrip();

        return v;
    }

    private void initViews() {
        for (int i = 0; i < labels.length; i++) {
            tl.addTab(tl.newTab().setText(labels[i]));
        }
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        addDriverTrip();
                        break;
                    case 1:
//                        addPassengerTrip();
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void addToDriverDataBase(String name, String surname, String cityFrom, String cityTo, String experience,
                                     String phone, String car, String carNumber, String description, String price,
                                     String countPassenger, String date, String imgUrl,  String imgCarUrl) {
        db = FirebaseFirestore.getInstance();
        CollectionReference dbDrivers = db.collection("DriverData");
        Driver working = new Driver(name, surname, cityFrom, cityTo, experience, phone,
                car, carNumber, description, price, countPassenger, date, imgUrl, imgCarUrl);
        dbDrivers.add(working).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getContext(), "Ваше объявление успешно добавлено!", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Произошла ошибка, попробуйте позднее!", Toast.LENGTH_LONG).show();
            }

        });
    }

    private void addDriverTrip() {

        addZapis.setOnClickListener(v-> {
            if (!nameET.getText().toString().equals("") || nameET.getText() != null) {
                nameS = nameET.getText().toString();
            } else {
                nameET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!surnameET.getText().toString().equals("") || surnameET.getText() != null) {
                surnameS = surnameET.getText().toString();
            } else {
                surnameET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!phoneET.getText().toString().equals("") || phoneET.getText() != null) {
                phoneS = phoneET.getText().toString();
            } else {
                phoneET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!experienceET.getText().toString().equals("") || experienceET.getText() != null) {
                experienceS = experienceET.getText().toString();
            } else {
                experienceET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!cityFromET.getText().toString().equals("") || cityFromET.getText() != null) {
                cityFromS = cityFromET.getText().toString();
            } else {
                cityFromET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!cityTowET.getText().toString().equals("") || cityTowET.getText() != null) {
                cityToS = cityTowET.getText().toString();
            } else {
                cityTowET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!priceET.getText().toString().equals("") || priceET.getText() != null) {
                priceS = priceET.getText().toString();
            } else {
                priceET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            //   toWS;
            if (!carET.getText().toString().equals("") || carET.getText() != null) {
                carS = carET.getText().toString();
            } else {
                carET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!carNumberET.getText().toString().equals("") || carNumberET.getText() != null) {
                carNumberS = carNumberET.getText().toString();
            } else {
                carNumberET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!countPlaceET.getText().toString().equals("") || countPlaceET.getText() != null) {
                countPlaceS = countPlaceET.getText().toString();
            } else {
                countPlaceET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!dateET.getText().toString().equals("") || dateET.getText() != null) {
                dateS = dateET.getText().toString();
            } else {
                dateET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!cityFromET.getText().toString().equals("") || cityFromET.getText() != null) {
                fromS = cityFromET.getText().toString();
            } else {
                cityFromET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
            if (!cityTowET.getText().toString().equals("") || cityTowET.getText() != null) {
                toWS = cityTowET.getText().toString();
            } else {
                cityTowET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }

            imgUrlS = "a";
            imgCarUrlS = "a";
            if(!nameET.getText().toString().equals("")
                    && !surnameET.getText().toString().equals("")
                    && !cityFromET.getText().toString().equals("")
                    && !cityTowET.getText().toString().equals("")
                    && !experienceET.getText().toString().equals("")
                    && !phoneET.getText().toString().equals("")
                    && !carET.getText().toString().equals("")
                    && !carNumberET.getText().toString().equals("")
                    && !descriptionET.getText().toString().equals("")
                    && !priceET.getText().toString().equals("")
                    && !countPassengerET.getText().toString().equals("")
                    && !dateET.getText().toString().equals(""))

                addToDriverDataBase(nameS, surnameS, cityFromS, cityToS, experienceS, phoneS,
                        carS, carNumberS, descriptionS, priceS, countPassengerS, dateS, imgUrlS, imgCarUrlS);
        });
    }


//    private void addToPassengerDataBase(String name, String surname, String city,
//                                     String phone, String countPassengers, String description, String imgUrl) {
//        db = FirebaseFirestore.getInstance();
//        CollectionReference dbDrivers = db.collection("PassengerData");
//        Passenger working = new Passenger(name, surname, city, phone,
//                countPassengers, description, imgUrl);
//        dbDrivers.add(working).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//                Toast.makeText(getContext(), "Ваше объявление успешно добавлено!", Toast.LENGTH_LONG).show();
//                getActivity().finish();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getContext(), "Произошла ошибка, попробуйте позднее!", Toast.LENGTH_LONG).show();
//            }
//
//        });
//    }
//
//    private void addPassengerTrip() {
//
//        experience_line.setVisibility(View.GONE);
//        price_line.setVisibility(View.GONE);
//        car_line.setVisibility(View.GONE);
//        car_number_line.setVisibility(View.GONE);
//        place_line.setVisibility(View.GONE);
//        count_passenger_line.setVisibility(View.VISIBLE);
//
//
//        addZapis.setOnClickListener(v-> {
//            if (!nameET.getText().toString().equals("") || nameET.getText() != null) {
//                nameS = nameET.getText().toString();
//            } else {
//                nameET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
//            }
//            if (!surnameET.getText().toString().equals("") || surnameET.getText() != null) {
//                surnameS = surnameET.getText().toString();
//            } else {
//                surnameET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
//            }
//            if (!cityET.getText().toString().equals("") || cityET.getText() != null) {
//                cityFromS = cityET.getText().toString();
//            } else {
//                cityET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
//            }
//            if (!phoneET.getText().toString().equals("") || phoneET.getText() != null) {
//                phoneS = phoneET.getText().toString();
//            } else {
//                phoneET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
//            }
//            if (!countPassengerET.getText().toString().equals("") || countPassengerET.getText() != null) {
//                countPassengerS = countPassengerET.getText().toString();
//            } else {
//                countPassengerET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
//            }
//            if (!cityFromET.getText().toString().equals("") || cityFromET.getText() != null) {
//                fromS = cityFromET.getText().toString();
//            } else {
//                cityFromET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
//            }
//            if (!cityTowET.getText().toString().equals("") || cityTowET.getText() != null) {
//                toWS = cityTowET.getText().toString();
//            } else {
//                cityTowET.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
//            }
//
//            imgUrlS = "a";
//            imgCarUrlS = "a";
//            if(!nameET.getText().toString().equals("")
//                    && !surnameET.getText().toString().equals("")
//                    && !cityET.getText().toString().equals("")
//                    && !experienceET.getText().toString().equals("")
//                    && !phoneET.getText().toString().equals("")
//                    && !carET.getText().toString().equals("")
//                    && !carNumberET.getText().toString().equals("")
//                    && !descriptionET.getText().toString().equals(""))
//
//                addToPassengerDataBase(nameS, surnameS, cityFromS, phoneS,
//                        countPassengerS, descriptionS, imgUrlS);
//        });
//    }
}