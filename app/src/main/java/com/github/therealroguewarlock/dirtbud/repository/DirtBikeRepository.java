package com.github.therealroguewarlock.dirtbud.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.therealroguewarlock.dirtbud.data_percistence.DirtBudDAO;
import com.github.therealroguewarlock.dirtbud.data_percistence.DirtBudDatabase;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DirtBikeRepository {
	// Singleton
	private static DirtBikeRepository instance;
	// Database Access
	private final DirtBudDAO dao;
	// LiveData used to automatically update the Viewport layers
	private final LiveData<List<DirtBike>> allEntities;
	// Used for Async
	private final ExecutorService executorService;

	// Private Constructor, part of Singleton
	private DirtBikeRepository(Context applicationContext) {
		DirtBudDatabase database = DirtBudDatabase.getInstance(applicationContext);
		dao = database.getDirtBudDAO();
		allEntities = dao.getAllDirtBikes();
		executorService = Executors.newFixedThreadPool(2);
	}

	/**
	 * Access to Singleton Class, Repository.
	 *
	 * @param applicationContext Base Application of the process
	 * @return Instance of Singleton class, Repository
	 */
	public static DirtBikeRepository getInstance(Context applicationContext) {
		if (instance == null) {
			instance = new DirtBikeRepository(applicationContext);
		}
		return instance;
	}

	public LiveData<List<DirtBike>> getAllEntities() {
		return allEntities;
	}

	/**
	 * Inserts a new Entity into local Storage
	 *
	 * @param newDirtBike Entity to be added
	 */
	public void insert(DirtBike newDirtBike) {
		executorService.execute(() -> dao.insert(newDirtBike));
	}

	/**
	 * Removes all Phrases in the local Storage
	 */
	public void deleteAllEntities() {
		executorService.execute(dao::deleteAllDirtBikes);
	}

	/**
	 * Update existing DirtBike by parsing a new DirtBike with matching ID
	 *
	 * @param updatedDirtBike Updated DirtBike. DirtBike with Matching ID will be updated
	 */
	public void updateEntity(DirtBike updatedDirtBike) {
		executorService.execute(() -> dao.update(updatedDirtBike));
	}

	public LiveData<DirtBike> getDirtBike(int dirtBikeId) {
		MutableLiveData<DirtBike> dirtBikeMutableLiveData = new MutableLiveData<>();
		executorService.execute(() -> {
			DirtBike bike = dao.getDirtBike(dirtBikeId);
			bike.addParts(dao.getParts(dirtBikeId));
			dirtBikeMutableLiveData.postValue(bike);
		});
		return dirtBikeMutableLiveData;
	}
}
