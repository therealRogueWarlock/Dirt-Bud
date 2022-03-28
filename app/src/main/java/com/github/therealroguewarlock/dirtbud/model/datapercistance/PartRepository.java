package com.github.therealroguewarlock.dirtbud.model.datapercistance;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class PartRepository {
	// Singleton
	private static PartRepository instance;
	// Database Access
	private final DirtBudDAO dao;
	// LiveData used to automatically update the Viewport layers
	private final LiveData<List<Part>> allEntities;
	// Used for Async
	private final ExecutorService executorService;

	// Private Constructor, part of Singleton
	private PartRepository(Application application) {
		DirtBudDatabase database = DirtBudDatabase.getInstance(application);
		this.dao = database.getDirtBudDAO();
		allEntities = dao.getAllParts();
		executorService = Executors.newFixedThreadPool(2);
	}

	/**
	 * Access to Singleton Class, Repository.
	 *
	 * @param application Base Application of the process
	 * @return Instance of Singleton class, Repository
	 */
	public abstract PartRepository getInstance(Application application);

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
	public void deleteAllPhrases() {
		executorService.execute(dao::deleteAllParts);
	}

	/**
	 * Update existing Part by parsing a new Part with matching ID
	 *
	 * @param updatedPart Updated Part. Part with Matching ID will be updated
	 */
	public void updatePhrase(Part updatedPart) {
		executorService.execute(() -> dao.update(updatedPart));
	}
}
