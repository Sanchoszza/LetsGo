package com.android.letsgo.db;

public class Driver {
    private String name;
    private String surname;
    private String age;
    private String city;
    private String experience;
    private String phone;
    private String email;
    private String carNumber;
    private String description;
    private String rate;
    private String imgUrl;
    private String imgCarUrl;

    public Driver(String name, String surname, String age, String city,
                  String experience, String phone, String email, String carNumber, String description,
                  String rate, String imgUrl, String imgCarUrl){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.experience = experience;
        this.phone = phone;
        this.email = email;
        this.carNumber = carNumber;
        this.description = description;
        this.rate = rate;
        this.imgUrl = imgUrl;
        this.imgCarUrl = imgCarUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRate(String rate) {
        this.rate = rate;
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

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getExperience() {
        return experience;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getRate() {
        return rate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgCarUrl() {
        return imgCarUrl;
    }
}
