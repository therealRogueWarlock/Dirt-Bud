package com.github.therealroguewarlock.dirtbud.ui.garage.inventory;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;

public class InventoryViewModel extends AndroidViewModel {

    private final GarageModel garageModel;

    public InventoryViewModel(Application application) {
        super(application);
        garageModel = new GarageModelImpl(application);

    }


}
