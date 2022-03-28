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

	public int getMaxAmountOfDirtBikes(){
		return maxAmountOfDirtBikes;
	}

	public int getAmountOfDirtBikes(){
		return dirtBikes.size();
	}

	public void addDirtBike(DirtBike dirtBike){
		dirtBikes.add(dirtBike);
	}


}
