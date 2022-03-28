package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

import androidx.annotation.NonNull;

public class TimeLimitedPart extends Part {
	// Replacement Time
	private final int replaceHours;

	public TimeLimitedPart(@NonNull String partNumber, @NonNull String partName, String partDescription, String colour, int hoursUsed, int replaceHours) {
		super(partNumber, partName, partDescription, colour, hoursUsed);
		this.replaceHours = replaceHours;
	}

	public int getReplaceHours() {
		return replaceHours;
	}
}
