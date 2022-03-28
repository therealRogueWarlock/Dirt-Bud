package com.github.therealroguewarlock.dirtbud.model.impl;

import com.github.therealroguewarlock.dirtbud.model.DummyData;
import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;

public class GarageModelImpl implements GarageModel {

    DummyData dummyData;


    public GarageModelImpl() {
        this.dummyData = new DummyData();
    }

    @Override
    public ArrayList<DirtBike> getDirtBikes() {

        return dummyData.getDirtBikes();
    }

    @Override
    public ArrayList<Part> getInventory() {
        return dummyData.getInventory();
    }
}
