package com.github.therealroguewarlock.dirtbud.model;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;
import java.util.List;

public interface GarageModel {


    LiveData<List<DirtBike>> getDirtBikes();
    ArrayList<Part> getInventory();



}
