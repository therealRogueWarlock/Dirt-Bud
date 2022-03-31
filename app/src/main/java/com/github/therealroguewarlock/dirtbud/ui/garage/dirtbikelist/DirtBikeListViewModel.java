package com.github.therealroguewarlock.dirtbud.ui.garage.dirtbikelist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;

import java.util.ArrayList;
import java.util.List;

public class DirtBikeListViewModel extends AndroidViewModel {

	private final GarageModel garageModel;
	private MutableLiveData<String> mText;

	private LiveData<List<DirtBike>> dirtBikes;
	private MutableLiveData<ArrayList<Part>> partInventory;

	public DirtBikeListViewModel(Application application) {
		super(application);
		garageModel = new GarageModelImpl(application.getApplicationContext());

		initLiveData();
	}

	public LiveData<String> getText() {
		return mText;
	}

	public LiveData<List<DirtBike>> getDirtBikes() {
		return dirtBikes;
	}

	public MutableLiveData<ArrayList<Part>> getPartInventory() {
		return partInventory;
	}

	private void initLiveData() {
		// TODO: Remove test text
		mText = new MutableLiveData<>();
		mText.setValue("This is the garage my dude");

		// load dirt bike data into live data
		dirtBikes = garageModel.getDirtBikes();

		partInventory = new MutableLiveData<>();
		partInventory.setValue(garageModel.getInventory());

	}

}