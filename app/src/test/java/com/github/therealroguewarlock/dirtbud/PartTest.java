package com.github.therealroguewarlock.dirtbud;

import com.github.therealroguewarlock.dirtbud.model.datapercistance.DirtBudDatabase;
import com.github.therealroguewarlock.dirtbud.model.datapercistance.PartRepository;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import org.junit.Before;
import org.junit.Test;

public class PartTest {
	Part defaultPartOne, defaultPartTwo;
	PartRepository repository;

	@Before
	public void setup() {

//		repository = DirtBudDatabase.getInstance();
		defaultPartOne = new Part("M3", "Bolt", "A common European Bolt", "Metallic", 20);
		defaultPartTwo = new Part("P230", "Piston", "The newest innovative piston", "Chrome", 1203);
	}

	@Test
	public void addDefaultPart() {

	}
}
