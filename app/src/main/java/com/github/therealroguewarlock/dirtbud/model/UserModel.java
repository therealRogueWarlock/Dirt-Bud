package com.github.therealroguewarlock.dirtbud.model;


import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.User;

public interface UserModel {


    LiveData<User> getUserDate();

}
