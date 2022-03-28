package com.github.therealroguewarlock.dirtbud.model.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "garage_table")
public class Garage {
	@PrimaryKey(autoGenerate = true)
	private int id;
	private final int maxAmountOfDirtBikes;
	private final List<DirtBike> dirtBikes;

	public Garage(int maxAmountOfBikes) {
		this.maxAmountOfDirtBikes = maxAmountOfBikes;
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

	public boolean addDirtBike(DirtBike dirtBike) {

		if (getAmountOfDirtBikes() < maxAmountOfDirtBikes) {
			dirtBikes.add(dirtBike);
			return true;
		} else {
			return false;
		}
	}

}
