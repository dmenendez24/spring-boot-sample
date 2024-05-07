package com.example.testspring.entities;

import jakarta.persistence.*;

import java.util.List;

import com.example.testspring.models.UserModel;

@Entity(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SessionEntity> sessions;

    public UserEntity() {
    }

    public UserEntity(UserModel userModel) {
        this.email = userModel.email;
        this.id = userModel.id;
        this.userName = userModel.userName;
        this.password = userModel.password;
        this.firstName = userModel.firstName;
        this.lastName = userModel.lastName;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
