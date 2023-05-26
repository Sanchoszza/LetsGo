package com.android.letsgo.db;

public class Driver {
    private String name;
    private String surname;
    private String cityFrom;
    private String cityTo;
    private String experience;
    private String phone;
    private String car;
    private String carNumber;
    private String description;
    private String price;
    private String countPassenger;
    private String date;
    private String imgUrl;
    private String imgCarUrl;

    public Driver(String name, String surname, String cityFrom, String cityTo,
                  String experience, String phone, String car, String carNumber, String description,
                  String price, String countPassenger, String date, String imgUrl, String imgCarUrl){
        this.name = name;
        this.surname = surname;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.experience = experience;
        this.phone = phone;
        this.car = car;
        this.carNumber = carNumber;
        this.description = description;
        this.price = price;
        this.countPassenger = countPassenger;
        this.date = date;
        this.imgUrl = imgUrl;
        this.imgCarUrl = imgCarUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCountPassenger(String countPassenger) {
        this.countPassenger = countPassenger;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setImgCarUrl(String imgCarUrl) {
        this.imgCarUrl = imgCarUrl;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public String getExperience() {
        return experience;
    }

    public String getPhone() {
        return phone;
    }

    public String getCar() {
        return car;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCountPassenger() {
        return countPassenger;
    }

    public String getDate() {
        return date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgCarUrl() {
        return imgCarUrl;
    }
}
