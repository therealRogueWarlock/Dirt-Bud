package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

public class TimeLimitedPart extends Part {
	// Replacement Time
	private final int replaceHours;

	public TimeLimitedPart(String partId, String partName, String partDescription, String colour, int hoursUsed, int length, int width, int height, int replaceHours) {
		super(partId, partName, partDescription, colour, hoursUsed, length, width, height);
		this.replaceHours = replaceHours;
	}

	public int getReplaceHours() {
		return replaceHours;
	}
}
