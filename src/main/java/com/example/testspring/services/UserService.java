package com.example.testspring.services;

import com.example.testspring.entities.UserEntity;
import com.example.testspring.exceptions.UserAlreadyExistsException;
import com.example.testspring.models.UserModel;
import com.example.testspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService() {
    }

    public List<UserModel> getUsers() {
        Iterable<UserEntity> users = this.userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();
        for (UserEntity user : users) {
            userModels.add(new UserModel(user));
        }
        return userModels;
    }

    public boolean createUser(UserModel userModel) {
        Iterable<UserEntity> users = this.userRepository.findAll();
        if (!StreamSupport.stream(users.spliterator(), false).anyMatch(userEntity -> userEntity.getEmail().equals(userModel.email) || userEntity.getUserName().equals(userModel.userName))) {
            userModel.password = encoder.encode(userModel.password);
            this.userRepository.save(new UserEntity(userModel));
            return true;
        } else {
            throw new NullPointerException();
        }
    }
}
