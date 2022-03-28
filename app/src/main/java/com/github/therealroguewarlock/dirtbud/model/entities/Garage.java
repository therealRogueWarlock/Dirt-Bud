package com.github.therealroguewarlock.dirtbud.model.entities;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	private final int maxAmountOfDirtBikes;
	private List<DirtBike> dirtBikes;

	public Garage(int maxAmountOfBikes) {
		this.maxAmountOfDirtBikes = maxAmountOfBikes;
		dirtBikes = new ArrayList<>();
	}

	public int getMaxAmountOfDirtBikes() {
		return maxAmountOfDirtBikes;
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
