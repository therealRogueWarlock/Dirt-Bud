package com.github.therealroguewarlock.dirtbud.data_percistence;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PartRepository {
	// Singleton
	private static PartRepository instance;
	// Database Access
	private final DirtBudDAO dao;
	// LiveData used to automatically update the Viewport layers
	private final LiveData<List<Part>> allEntities;
	// Used for Async
	private final ExecutorService executorService;

	// Private Constructor, part of Singleton
	private PartRepository(Context applicationContext) {
		DirtBudDatabase database = DirtBudDatabase.getInstance(applicationContext);
		dao = database.getDirtBudDAO();
		allEntities = dao.getAllParts();
		executorService = Executors.newFixedThreadPool(2);
	}

	/**
	 * Access to Singleton Class, Repository.
	 *
	 * @param applicationContext Base Application Context of the process
	 * @return Instance of Singleton class, Repository
	 */
	public static PartRepository getInstance(Context applicationContext) {
		if (instance == null) {
			instance = new PartRepository(applicationContext);
		}
		return instance;
	}

	public LiveData<List<Part>> getAllEntities() {
		return allEntities;
	}

	/**
	 * Inserts a new Entity into local Storage
	 *
	 * @param newPart Entity to be added
	 */
	public void insert(Part newPart) {
		executorService.execute(() -> dao.insert(newPart));
	}

	/**
	 * Removes all Phrases in the local Storage
	 */
	public void deleteAllParts() {
		executorService.execute(dao::deleteAllParts);
	}

	/**
	 * Update existing Part by parsing a new Part with matching ID
	 *
	 * @param updatedPart Updated Part. Part with Matching ID will be updated
	 */
	public void updatePart(Part updatedPart) {
		executorService.execute(() -> dao.update(updatedPart));
	}

	public LiveData<List<Part>> getPartsFrom(int dirtBikeId) {
		MutableLiveData<List<Part>> parts = new MutableLiveData<>();
		executorService.execute(() -> parts.postValue(dao.getParts(dirtBikeId)));
		return parts;
	}
}
