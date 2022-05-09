package com.github.therealroguewarlock.dirtbud;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Context;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.github.therealroguewarlock.dirtbud.repository.PartRepository;


public class DirtBikeTest {

    private Part defaultPartOne, defaultPartTwo;
    private DirtBike dirtBike;

    @Before
    public void setup() {

        defaultPartOne = new Part("M3", "Bolt", "A common European Bolt", "Metallic", 20, 50);
        defaultPartTwo = new Part("P230", "Piston", "The newest innovative piston", "Chrome", 10, 40);



    }



    @Test
    public void addHoursToDirtBike(){



    }


}
