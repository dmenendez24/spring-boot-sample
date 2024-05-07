package com.example.testspring.models;

import com.example.testspring.entities.UserEntity;

public class UserModel {
    public Long id;
    public String userName;
    public String password;
    public String email;
    public String firstName;
    public String lastName;

    public UserModel(String userName, String password, String email, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserModel(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.userName = userEntity.getUserName();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
    }
}
