package com.github.therealroguewarlock.dirtbud.ui.garage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GarageViewModel extends ViewModel {


    private final MutableLiveData<String> mText;

    public GarageViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is the garage my dude");
    }

    public LiveData<String> getText() {
        return mText;
    }


}
