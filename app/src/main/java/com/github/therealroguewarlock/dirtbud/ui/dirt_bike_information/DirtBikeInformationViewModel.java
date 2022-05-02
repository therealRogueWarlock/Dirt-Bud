package com.github.therealroguewarlock.dirtbud.ui.dirt_bike_information;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;

public class DirtBikeInformationViewModel extends AndroidViewModel {
	private LiveData<DirtBike> dirtBikeLiveData;

	private final GarageModel garageModel;

	public DirtBikeInformationViewModel(@NonNull Application application) {
		super(application);
		garageModel = new GarageModelImpl(application);
	}

	public void findDirtBike(int dirtBikeId) {
		dirtBikeLiveData = garageModel.getDirtBike(dirtBikeId);
	}

	public LiveData<DirtBike> getDirtBikeLiveData() {
		return dirtBikeLiveData;
	}
}
