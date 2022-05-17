package com.github.therealroguewarlock.dirtbud.model.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.data_percistence.firebase.DirtBudFirebase;
import com.github.therealroguewarlock.dirtbud.data_percistence.firebase.DirtBudFirebaseImpl;
import com.github.therealroguewarlock.dirtbud.repository.DirtBikeRepository;
import com.github.therealroguewarlock.dirtbud.repository.PartRepository;
import com.github.therealroguewarlock.dirtbud.model.DummyData;
import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.List;

public class GarageModelImpl implements GarageModel {
	private final DirtBikeRepository bikeRepository;
	private final PartRepository partRepository;
	private LiveData<List<DirtBike>> dirtBikeList;
	private DummyData dummyData;

	public GarageModelImpl(Context applicationContext) {
		bikeRepository = DirtBikeRepository.getInstance(applicationContext);
		partRepository = PartRepository.getInstance(applicationContext);


		this.dummyData = new DummyData();
	}

	@Override
	public LiveData<List<DirtBike>> getDirtBikes() {
		dirtBikeList = bikeRepository.getAllEntities();
		return dirtBikeList;
	}

	@Override
	public LiveData<DirtBike> getDirtBike(int dirtBikeId) {
		return bikeRepository.getDirtBike(dirtBikeId);
	}

	@Override
	public LiveData<List<Part>> getInventory() {
		return partRepository.getAllEntities();
	}

	@Override
	public LiveData<List<Part>> getParts(int dirtBikeId) {
		return partRepository.getPartsFrom(dirtBikeId);
	}

	@Override
	public void setHours(int dirtBikeId, int hours) {

		// TODO: Implement
	}

	@Override
	public void addHours(int dirtBikeId, int hours) {
		// TODO: Implement
	}

	@Override
	public void addDirtBike(DirtBike dirtBike) {
		bikeRepository.addDirtBikeToFirebase(dirtBike);
	}

}
