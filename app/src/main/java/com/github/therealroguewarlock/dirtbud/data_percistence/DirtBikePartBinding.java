package com.github.therealroguewarlock.dirtbud.data_percistence;

import androidx.room.Entity;

@Entity(tableName = "part_binding", primaryKeys = {"partId", "dirtBikeId"})
public class DirtBikePartBinding {
	int partId;
	int dirtBikeId;
}
