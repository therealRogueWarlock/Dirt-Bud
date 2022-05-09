package com.github.therealroguewarlock.dirtbud.model;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.TimeLimitedPart;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class DummyData {
	private final int MAX_DUMMY_DATA = 100;

	public ArrayList<DirtBike> getDirtBikes() {

		ArrayList<DirtBike> dummyDirtBikes = new ArrayList<>();

		dummyDirtBikes.add(new DirtBike("Yamaha", 125, 125, 150, 120, 19, 115, 100, false));
		dummyDirtBikes.add(new DirtBike("KTM", 250, 250, 150, 130, 19, 115, 230, true));
		dummyDirtBikes.add(new DirtBike("GASGAS", 450, 250, 150, 125, 21, 120, 56, true));

		Random r = new Random();
		byte[] chars = new byte[7];
		for (int i = 0; i < MAX_DUMMY_DATA; i++) {
			r.nextBytes(chars);
			dummyDirtBikes.add(
					new DirtBike(
							new String(chars, StandardCharsets.ISO_8859_1),
					100 + r.nextInt(300),
					50 + r.nextInt(300),
					100 + r.nextInt(80),
					150 + r.nextInt(40),
					120 + r.nextInt(50),
					80 + r.nextInt(40), r.nextInt(1000), r.nextBoolean()
					)
			);
		}

		return dummyDirtBikes;
	}

	public ArrayList<Part> getInventory() {
		ArrayList<Part> dummyParts = new ArrayList<>();

		dummyParts.add(new TimeLimitedPart("m213", "piston", "The pistion in the motor", "metal", 12,60));
		dummyParts.add(new TimeLimitedPart("m321", "clutch", "good clutch", "metal", 80,53));
		dummyParts.add(new TimeLimitedPart("m513", "foot peck", "what you stand on", "metal", 70,33));
		dummyParts.add(new TimeLimitedPart("m7613", "valves", "the valves in the motor", "metal", 50, 55));

		return dummyParts;
	}

}
