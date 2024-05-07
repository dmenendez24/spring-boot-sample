package com.example.testspring.services;

import com.example.testspring.entities.UserEntity;
import com.example.testspring.models.UserModel;
import com.example.testspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public List<UserModel> getUsers() {
        List<UserEntity> users = this.userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();
        for (UserEntity user : users) {
            userModels.add(new UserModel(user));
        }
        return userModels;
    }

    public boolean createUser(UserModel userModel) {
        List<UserEntity> users = this.userRepository.findAll();
        if (!users.stream().anyMatch(userEntity -> userEntity.getEmail().equals(userModel.email) || userEntity.getUserName().equals(userModel.userName))) {
            this.userRepository.save(new UserEntity(userModel));
            return true;
        } else {
            return false;
        }
    }
}
