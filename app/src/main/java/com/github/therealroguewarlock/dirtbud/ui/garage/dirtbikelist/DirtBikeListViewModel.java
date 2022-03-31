package com.github.therealroguewarlock.dirtbud.ui.garage.dirtbikelist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;

import java.util.List;

public class DirtBikeListViewModel extends AndroidViewModel {

	private final GarageModel garageModel;
	private LiveData<List<DirtBike>> dirtBikes;

	public DirtBikeListViewModel(Application application) {
		super(application);
		garageModel = new GarageModelImpl(application.getApplicationContext());

		initLiveData();
	}

	public LiveData<List<DirtBike>> getDirtBikes() {
		return dirtBikes;
	}

	private void initLiveData() {
		// load dirt bike data into live data
		dirtBikes = garageModel.getDirtBikes();
	}

}
