package com.github.therealroguewarlock.dirtbud.model.entities.dirtbike;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class DirtBikeWithParts {
	@Embedded
	public DirtBike dirtBike;
	@Relation(parentColumn = "dirtBikeId", entityColumn = "partId", associateBy = @Junction(DirtBikePartCrossRef.class))
	public List<Part> partList;
}
