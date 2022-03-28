package com.github.therealroguewarlock.dirtbud.model.datapercistance;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class DirtBikeRepository {
	// Singleton
	private static DirtBikeRepository instance;
	// Database Access
	private final DirtBudDAO dao;
	// LiveData used to automatically update the Viewport layers
//	private final LiveData<List<DirtBike>> allEntities; // TODO
	// Used for Async
	private final ExecutorService executorService;

	// Private Constructor, part of Singleton
	private DirtBikeRepository(Application application) {
		DirtBudDatabase database = DirtBudDatabase.getInstance(application);
		this.dao = database.getDirtBudDAO();
//		allEntities = dao.getAllDirtBikes(); // TODO
		executorService = Executors.newFixedThreadPool(2);
	}

	/**
	 * Access to Singleton Class, Repository.
	 *
	 * @param application Base Application of the process
	 * @return Instance of Singleton class, Repository
	 */
	public abstract DirtBikeRepository getInstance(Application application);

//	public LiveData<List<DirtBike>> getAllEntities() { // TODO
//		return allEntities;
//	}

	/**
	 * Inserts a new Entity into local Storage
	 *
	 * @param newDirtBike Entity to be added
	 */
	public void insert(DirtBike newDirtBike) {
//		executorService.execute(() -> dao.insert(newDirtBike)); // TODO
	}

	/**
	 * Removes all Phrases in the local Storage
	 */
	public void deleteAllPhrases() {
//		executorService.execute(dao::deleteAllDirtBikes); // TODO
	}

	/**
	 * Update existing DirtBike by parsing a new DirtBike with matching ID
	 *
	 * @param updatedDirtBike Updated DirtBike. DirtBike with Matching ID will be updated
	 */
	public void updatePhrase(DirtBike updatedDirtBike) {
//		executorService.execute(() -> dao.update(updatedDirtBike)); // TODO
	}
}
