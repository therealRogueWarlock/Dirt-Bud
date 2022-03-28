package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "part_table")
public class Part {
	@PrimaryKey(autoGenerate = true)
	private int partId;
	@NotNull
	private final String partNumber;
	@NotNull
	private final String partName;
	private String partDescription;
	private final String colour;

	// Replacement Time
	private final int hoursUsed;

	public Part(@NotNull String partNumber, @NotNull String partName, String partDescription, String colour, int hoursUsed) {
		this.partNumber = partNumber;
		this.partName = partName;
		this.partDescription = partDescription;
		this.colour = colour;
		this.hoursUsed = hoursUsed;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	@NotNull
	public String getPartNumber() {
		return partNumber;
	}

	@NotNull
	public String getPartName() {
		return partName;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getColour() {
		return colour;
	}

	public int getHoursUsed() {
		return hoursUsed;
	}
}
