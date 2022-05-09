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
	private float estimatedDurableHours;
	// total time used
	private float hoursUsed;

	public Part(@NotNull String partNumber, @NotNull String partName, String partDescription, String colour, float hoursUsed, float estimatedDurableHours) {
		this.partNumber = partNumber;
		this.partName = partName;
		this.partDescription = partDescription;
		this.colour = colour;
		this.hoursUsed = hoursUsed;
		this.estimatedDurableHours = estimatedDurableHours;
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

	public float getHoursUsed() {
		return hoursUsed;
	}

	public void setHoursUsed(float hoursUsed) {
		this.hoursUsed = hoursUsed;
	}
}
