package com.github.therealroguewarlock.dirtbud.model;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.List;

public interface GarageModel {

	/**
	 * Get all DirtBikes
	 *
	 * @return LiveData List of all DirtBikes
	 */
	LiveData<List<DirtBike>> getDirtBikes();

	/**
	 * Get a single DirtBike
	 *
	 * @param dirtBikeId ID of DirtBike to get
	 * @return LiveData DirtBike with Matching ID
	 */
	LiveData<DirtBike> getDirtBike(int dirtBikeId);

	/**
	 * Get all Parts
	 *
	 * @return LiveData List of all Parts
	 */
	LiveData<List<Part>> getInventory();

	/**
	 * Get a set of Parts which correspond to a specific DirtBike
	 *
	 * @param dirtBikeId ID of DirtBike which Parts to get
	 * @return LiveData List of Parts which are "bound" to the DirtBike
	 */
	LiveData<List<Part>> getParts(int dirtBikeId);

	/**
	 * Set ridetime for a DirtBike and its Parts
	 *
	 * @param dirtBikeId ID for the DirtBike which Hours are to be set
	 * @param hours      Hours to set for DirtBike and its parts
	 */
	void setHours(int dirtBikeId, int hours);

	/**
	 * Add ridetime to a DirtBike and its Parts
	 *
	 * @param dirtBikeId ID for the DirtBike which Hours are to be added
	 * @param hours      Hours to added to DirtBike and its parts
	 */
	void addHours(int dirtBikeId, int hours);


	void addDirtBike(DirtBike dirtBike);
}
