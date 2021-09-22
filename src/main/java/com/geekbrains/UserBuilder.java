package com.geekbrains;

public class UserBuilder {

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String birthDate;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public User build() {
        User user = new User();
        user.setAddress(address);
        user.setName(name);
        user.setPhone(phone);
        user.setSurname(surname);
        user.setBirthDate(birthDate);
        return user;
    }

}
