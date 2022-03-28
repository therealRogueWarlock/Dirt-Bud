package com.github.therealroguewarlock.dirtbud.model.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "garage_table")
public class Garage {
	@PrimaryKey(autoGenerate = true)
	private int id;
	private final int maxAmountOfDirtBikes;
	private final List<DirtBike> dirtBikes;
	private final List<Part> parts;

	public Garage(int maxAmountOfBikes) {
		this.maxAmountOfDirtBikes = maxAmountOfBikes;
		this.parts = new ArrayList<>();
		dirtBikes = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxAmountOfDirtBikes() {
		return maxAmountOfDirtBikes;
	}

	public List<DirtBike> getDirtBikes() {
		return dirtBikes;
	}

	public int getAmountOfDirtBikes() {
		return dirtBikes.size();
	}

	public List<Part> getParts() {
		return parts;
	}

	public boolean addDirtBike(DirtBike newDirtBike) {

		if (getAmountOfDirtBikes() < maxAmountOfDirtBikes) {
			dirtBikes.add(newDirtBike);
			return true;
		} else {
			return false;
		}
	}

	public void addPart(Part newPart){
		parts.add(newPart);
	}
}
