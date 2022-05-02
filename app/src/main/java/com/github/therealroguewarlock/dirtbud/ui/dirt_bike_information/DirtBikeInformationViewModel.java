package com.github.therealroguewarlock.dirtbud.ui.dirt_bike_information;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;

import java.util.List;

public class DirtBikeInformationViewModel extends AndroidViewModel {
	// TODO: Get DirtBike and DirtBikeParts initiated, with information from the Fragment
	private LiveData<DirtBike> dirtBike;
	private LiveData<List<Part>> dirtBikeParts;

	private final GarageModel garageModel;

	public DirtBikeInformationViewModel(@NonNull Application application) {
		super(application);
		garageModel = new GarageModelImpl(application);

		initLiveData();
	}

	private void initLiveData() {

	}

	public LiveData<List<Part>> getParts() {
		return dirtBikeParts;
	}

	public void findDirtBike(int dirtBikeId) {
		dirtBike = garageModel.getDirtBike(dirtBikeId);
		dirtBikeParts = garageModel.getParts(dirtBikeId);
	}

	public LiveData<DirtBike> getDirtBike() {
		return dirtBike;
	}
}
