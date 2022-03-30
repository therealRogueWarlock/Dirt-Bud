package com.github.therealroguewarlock.dirtbud.model.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private int inventoryId;
	@NotNull
//	@Embedded
	private List<Part> partList;

	public Inventory() {
		partList = new ArrayList<>();
	}

}
