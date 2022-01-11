package com.csseifms.seshat.master.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table
public class User {
    @Column
    String name, address;
    @Column
    City city;
    int age;
    //// TODO

    @Column(name = "user_type")
    String userType;

    //    @OneToMany
//    @JoinColumn
//    Collection<Interest> interests;
    String interests;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public User(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
    private User(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.age = builder.age;
        this.city = builder.city;
        this.userType = builder.user_type;
        this.address = builder.address;
    }



    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    //    public Collection<Interest> getInterests() {
//        return interests;
//    }
//
//    public void setInterests(Collection<Interest> interests) {
//        this.interests = interests;
//    }
    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", type=" + userType +
                ", interests=" + interests +
                ", id=" + id +
                '}';
    }

    public static class Builder{
        String name, address;
        City city;
        int age;
        String user_type;
        String interests;
        long id;

        public Builder(String name) {
            this.id = new Random().nextLong();
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder interests(String interests) {
            this.interests = interests;
            return this;
        }

        public User build(){
            User user = new User(this);
            user.userType = UserType.BUILDER.name();
            return user;
        }


    }
}
