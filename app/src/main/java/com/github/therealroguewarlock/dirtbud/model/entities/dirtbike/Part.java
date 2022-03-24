package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

public class Part {

    private final String partId;
    private final String partName;
    private String partDescription;

    // Replacement Time
    private final int replaceHours;
    private int currentHours;

    // Size
    private int length;
    private int width;
    private int height;

    public Part(String partId, String partName, String partDescription, int replaceHours, int currentHours, int length, int width, int height) {
        this.partId = partId;
        this.partName = partName;
        this.partDescription = partDescription;
        this.replaceHours = replaceHours;
        this.currentHours = currentHours;
        this.length = length;
        this.width = width;
        this.height = height;
    }
}
