package com.github.therealroguewarlock.dirtbud.model.entities;


import  com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

import java.util.ArrayList;

public class Garage {
	private final int maxAMountOfDirtBikes;
	private ArrayList<DirtBike> dirtBikes;

	public Garage(int maxAmountOfBikes) {
		this.maxAMountOfDirtBikes = maxAmountOfBikes;
		dirtBikes = new ArrayList<>();
	}

	public int getMaxAmountOfDirtBikes(){
		return maxAMountOfDirtBikes;
	}

	public int getAmountOfDirtBikes(){
		return dirtBikes.size();
	}

	public void addDirtBike(DirtBike dirtBike){
		dirtBikes.add(dirtBike);
	}


}
