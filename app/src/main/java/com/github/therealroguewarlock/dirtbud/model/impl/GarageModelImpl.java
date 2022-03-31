package com.github.therealroguewarlock.dirtbud.model.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.datapercistence.DirtBikeRepository;
import com.github.therealroguewarlock.dirtbud.model.DummyData;
import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;
import java.util.List;

public class GarageModelImpl implements GarageModel {
	private final DirtBikeRepository repository;
	private LiveData<List<DirtBike>> dirtBikeList;
	private DummyData dummyData;

	public GarageModelImpl(Context applicationContext) {
		repository = DirtBikeRepository.getInstance(applicationContext);
		this.dummyData = new DummyData();
	}

	@Override
	public LiveData<List<DirtBike>> getDirtBikes() {
		dirtBikeList = repository.getAllEntities();
		return dirtBikeList;
	}

	@Override
	public ArrayList<Part> getInventory() {
		return dummyData.getInventory();
	}
}
