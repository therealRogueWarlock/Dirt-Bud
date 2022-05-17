package com.github.therealroguewarlock.dirtbud.model.impl;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.UserModel;
import com.github.therealroguewarlock.dirtbud.model.entities.User;
import com.github.therealroguewarlock.dirtbud.repository.UserRepository;

public class UserModelImpl implements UserModel {

    private UserRepository userRepository;
    private static UserModel instance;


    private UserModelImpl() {
        userRepository = UserRepository.getInstance();
    }


    public static UserModel getInstance() {
        if (instance==null)
            instance = new UserModelImpl();
        return instance;
    }

    @Override
    public LiveData<User> getUserDate() {
        return userRepository.getUserData();
    }
}
