package com.github.therealroguewarlock.dirtbud;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.TimeLimitedPart;
import com.github.therealroguewarlock.dirtbud.repository.PartRepository;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PartTest {
	private Part defaultPartOne, defaultPartTwo;
	private PartRepository repository;

	@Before
	public void setup() {
		Context c = InstrumentationRegistry.getInstrumentation().getTargetContext();
		repository = PartRepository.getInstance(c);

		defaultPartOne = new TimeLimitedPart("M3", "Bolt", "A common European Bolt", "Metallic", 20, 50);
		defaultPartTwo = new TimeLimitedPart("P230", "Piston", "The newest innovative piston", "Chrome", 10, 40);
	}

	@After
	public void tearDown() {
		repository.deleteAllParts();
	}

	@Test
	public void addDefaultPart() {
		repository.insert(defaultPartOne);
	}

}
