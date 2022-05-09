package com.github.therealroguewarlock.dirtbud;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Context;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.TimeLimitedPart;
import com.github.therealroguewarlock.dirtbud.repository.PartRepository;


public class DirtBikeTest {

    private Part defaultPartOne, defaultPartTwo;
    private DirtBike dirtBike;

    @Before
    public void setup() {

        defaultPartOne = new TimeLimitedPart("M3", "Bolt", "A common European Bolt", "Metallic", 20, 50);
        defaultPartTwo = new TimeLimitedPart("P230", "Piston", "The newest innovative piston", "Chrome", 10, 40);

        dirtBike = new DirtBike("Yamaha", 250,250,70,80,21,120,140.1f,true);
        dirtBike.addPart(defaultPartOne);
        dirtBike.addPart(defaultPartTwo);
    }



    @Test
    public void addHoursToDirtBike(){
        float partOneUseTimeBefore = defaultPartOne.getHoursUsed();
        float partTwoUseTimeBefore = defaultPartTwo.getHoursUsed();
        float hoursToAdd = 4.3f;
        dirtBike.addRideHours(hoursToAdd);
        float partTwoUseTimeAfter = defaultPartTwo.getHoursUsed();
        float partOneUseTimeAfter = defaultPartOne.getHoursUsed();

        // asserting the part hours increased by "hoursToAdd" after adding to dirt bike
        assertEquals(partOneUseTimeBefore+hoursToAdd,partOneUseTimeAfter, 0);
        assertEquals(partTwoUseTimeBefore+hoursToAdd,partTwoUseTimeAfter, 0);

    }


}
