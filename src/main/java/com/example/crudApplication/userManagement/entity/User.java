package com.example.crudApplication.userManagement.entity;

import jakarta.persistence.*;

//User class-> In which there are all properties of a User
@Entity
@Table
public class User {

    @Id
    private String id;
    @Column(unique = true)
    private String userName;
    //The value of username is need to be unique
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String mobileNumber;
    //The value of mobileNumber is need to be unique
    private String emailId;
    private String address1;
    private String address2;

//Default constructor
    public User() {
    }

    //parameterised constructor
    public User(String id, String userName, String firstName, String lastName, String mobileNumber, String emailId, String address1, String address2) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.address1 = address1;
        this.address2 = address2;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}
