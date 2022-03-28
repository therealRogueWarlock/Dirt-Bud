package com.github.therealroguewarlock.dirtbud.model;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;

public interface GarageModel {


    ArrayList<DirtBike> getDirtBikes();
    ArrayList<Part> getInventory();



}
