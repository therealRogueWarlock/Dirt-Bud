package com.github.therealroguewarlock.dirtbud.model.entities;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Part> partList; // TODO: Convert to a simple List<Part>?

	public Inventory() {
		partList = new ArrayList<>();
	}

	public void addPart(Part part){
		partList.add(part);
	}
}
