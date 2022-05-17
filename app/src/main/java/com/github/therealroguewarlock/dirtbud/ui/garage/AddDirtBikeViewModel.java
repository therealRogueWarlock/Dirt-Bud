package com.github.therealroguewarlock.dirtbud.ui.garage;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;
import com.github.therealroguewarlock.dirtbud.repository.DirtBikeRepository;

public class AddDirtBikeViewModel extends AndroidViewModel {

    private final GarageModel garageModel;


    public AddDirtBikeViewModel(Application application) {
        super(application);
        garageModel = new GarageModelImpl(application.getApplicationContext());

    }

    public void addDirtBike(DirtBike dirtBike){
        garageModel.addDirtBike(dirtBike);
    }

}