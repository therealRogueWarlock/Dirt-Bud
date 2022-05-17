package com.github.therealroguewarlock.dirtbud.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.therealroguewarlock.dirtbud.model.UserModel;
import com.github.therealroguewarlock.dirtbud.model.entities.User;
import com.github.therealroguewarlock.dirtbud.model.impl.UserModelImpl;

public class ProfileViewModel extends ViewModel {

	private UserModel userModel;

	public ProfileViewModel() {
		userModel = UserModelImpl.getInstance();

	}

	public LiveData<User> getUserData(){
		return userModel.getUserDate();
	}
}