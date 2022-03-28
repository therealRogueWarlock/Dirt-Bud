package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "dirt_bike_table")
public class DirtBike {
	@PrimaryKey(autoGenerate = true)
	private int dirtBikeId;
	@NotNull
	private String brand;
	private int displacement;
	private int engineSize;
	private int rideHeight;
	private int forkHeight;
	private int wheelSize;
	private int weight;
	@NotNull
	private final List<Part> partList; // FIXME: What the hell do we do here? Ask Kasper
	private boolean isFourStrokeEngine;

	public DirtBike(String brand, int displacement, int engineSize, int rideHeight, int forkHeight, int wheelSize, int weight, List<Part> partList, boolean isFourStrokeEngine) {
		this.brand = (brand == null) ? "Brand Not Set" : brand;
		this.displacement = displacement;
		this.engineSize = engineSize;
		this.rideHeight = rideHeight;
		this.forkHeight = forkHeight;
		this.wheelSize = wheelSize;
		this.weight = weight;
		this.partList = (partList == null) ? new ArrayList<>() : partList;
		this.isFourStrokeEngine = isFourStrokeEngine;
	}

	public int getDirtBikeId() {
		return dirtBikeId;
	}

	public void setDirtBikeId(int dirtBikeId) {
		this.dirtBikeId = dirtBikeId;
	}

	@NonNull
	public String getBrand() {
		return brand;
	}

	public void setBrand(@NonNull String brand) {
		this.brand = brand;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
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

	@NonNull
	public List<Part> getPartList() {
		return partList;
	}

	public boolean isFourStrokeEngine() {
		return isFourStrokeEngine;
	}

	public void setFourStrokeEngine(boolean fourStrokeEngine) {
		isFourStrokeEngine = fourStrokeEngine;
	}

	@Override
	public String toString() {
		return "DirtBike{" +
				"brand='" + brand + '\'' +
				", engineSize=" + engineSize +
				'}';
	}
}
