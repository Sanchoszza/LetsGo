package com.android.letsgo.db;

public class Users {

    int type;
    private String name;
    private String surname;
    private String age;
    private String city;
    private String phone;
    private String email;
    private String description;
    private String imgUrl;

    public Users(int type, String name, String surname, String age, String city,
                   String phone, String email, String imgUrl){
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.imgUrl = imgUrl;
    }

    public void setType(int type) {
        this.type = type;
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


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public int getType() {
        return type;
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


    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
