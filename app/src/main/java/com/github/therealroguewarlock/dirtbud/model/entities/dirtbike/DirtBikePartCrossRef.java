package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

import androidx.room.Entity;

@Entity(primaryKeys = {"dirtBikeId", "partId"})
public class DirtBikePartCrossRef {
	public int dirtBikeId;
	public int partId;
}
