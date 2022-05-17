package com.github.therealroguewarlock.dirtbud.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.therealroguewarlock.dirtbud.data_percistence.firebase.DirtBudFirebase;
import com.github.therealroguewarlock.dirtbud.data_percistence.firebase.DirtBudFirebaseImpl;
import com.github.therealroguewarlock.dirtbud.model.entities.User;

public class UserRepository {

    private DirtBudFirebase dirtBudFirebase;
    private static UserRepository instance;

    private UserRepository() {
        dirtBudFirebase = new DirtBudFirebaseImpl();

    }

    public static UserRepository getInstance() {
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }

    public LiveData<User> getUserData() {

        return new MutableLiveData<>(new User("Sjwqd2132","john","bob",21));

    }
}
