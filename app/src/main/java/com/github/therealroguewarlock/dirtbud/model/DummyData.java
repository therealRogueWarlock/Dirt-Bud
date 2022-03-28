package com.github.therealroguewarlock.dirtbud.model;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;

public class DummyData {


    public ArrayList<DirtBike> getDirtBikes() {


        ArrayList<DirtBike> dummyDirtBikes = new ArrayList<>();

        dummyDirtBikes.add(new DirtBike("Yamaha", 125,125,150,120,19,115, getInventory(), false));
        dummyDirtBikes.add(new DirtBike("KTM", 250,250,150,130,19,115, getInventory(), true));
        dummyDirtBikes.add(new DirtBike("GASGAS", 450,250,150,125,21,120, getInventory(), true));


        return dummyDirtBikes;
    }


    public ArrayList<Part> getInventory() {
        ArrayList<Part> dummyParts = new ArrayList<>();

        dummyParts.add(new Part("m213", "piston", "The pistion in the motor", "metal", 12));
        dummyParts.add(new Part("m321", "clutch", "good clutch", "metal", 80));
        dummyParts.add(new Part("m513", "foot peck", "what you stand on", "metal", 70));
        dummyParts.add(new Part("m7613", "valves", "the valves in the motor", "metal", 50));


        return dummyParts;
    }

}
