package com.android.letsgo.db;

public class Passenger {

    private String name;
    private String surname;
    private String city;
    private String phone;
    private String countPassengers;
    private String description;
    private String imgUrl;


    public Passenger(String name, String surname, String city,
                   String phone, String countPassengers, String description, String imgUrl){
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.phone = phone;
        this.countPassengers = countPassengers;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountPassengers(String countPassengers) {
        this.countPassengers = countPassengers;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }


    public String getPhone() {
        return phone;
    }

    public String getCountPassengers() {
        return countPassengers;
    }

    public String getDescription() {
        return description;
    }


    public String getImgUrl() {
        return imgUrl;
    }
}
