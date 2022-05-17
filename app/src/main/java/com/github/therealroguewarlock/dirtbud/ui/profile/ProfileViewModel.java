package com.github.therealroguewarlock.dirtbud.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.therealroguewarlock.dirtbud.model.UserModel;
import com.github.therealroguewarlock.dirtbud.model.entities.User;
import com.github.therealroguewarlock.dirtbud.model.impl.UserModelImpl;

public class ProfileViewModel extends ViewModel {

	private UserModel userModel;
	private final MutableLiveData<String> mText;

	public ProfileViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is the profile fragment :P");

		userModel = UserModelImpl.getInstance();

	}

	public LiveData<String> getText() {
		return mText;
	}

	public LiveData<User> getUserData(){
		return userModel.getUserDate();
	}
}