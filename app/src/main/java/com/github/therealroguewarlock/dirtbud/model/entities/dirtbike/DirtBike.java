package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "dirtbike_table")
public class DirtBike {
	@PrimaryKey(autoGenerate = true)
	private int id;
	private int engineSize;
	private int rideHeight;
	private int forkHeight;
	private int wheelSize;
	private int weight;
	private List<Part> partList;

	public DirtBike(int engineSize, int rideHeight, int forkHeight, int wheelSize, int weight, List<Part> partList) {
		this.engineSize = engineSize;
		this.rideHeight = rideHeight;
		this.forkHeight = forkHeight;
		this.wheelSize = wheelSize;
		this.weight = weight;
		this.partList = partList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	public int getRideHeight() {
		return rideHeight;
	}

	public void setRideHeight(int rideHeight) {
		this.rideHeight = rideHeight;
	}

	public int getForkHeight() {
		return forkHeight;
	}

	public void setForkHeight(int forkHeight) {
		this.forkHeight = forkHeight;
	}

	public int getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(int wheelSize) {
		this.wheelSize = wheelSize;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Part> getPartList() {
		return partList;
	}

	public void setPartList(List<Part> partList) {
		this.partList = partList;
	}
}
