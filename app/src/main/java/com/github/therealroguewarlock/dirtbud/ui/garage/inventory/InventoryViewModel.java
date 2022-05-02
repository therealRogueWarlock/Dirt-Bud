package com.github.therealroguewarlock.dirtbud.ui.garage.inventory;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;

import java.util.List;

public class InventoryViewModel extends AndroidViewModel {

	private final GarageModel garageModel;
	private LiveData<List<Part>> parts;

	public InventoryViewModel(Application application) {
		super(application);
		garageModel = new GarageModelImpl(application);

		initLiveData();
	}

	public LiveData<List<Part>> getParts() {
		return parts;
	}

//	public LiveData<List<Part>> getFilteredParts(int dirtBikeId) {
//		// TODO: Implement this feature. Needs to be done in DAO as well
//		return null;
//	}

	private void initLiveData() {
		parts = garageModel.getInventory();
	}
}
