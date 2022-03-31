package com.github.therealroguewarlock.dirtbud.ui.garage.inventory;

import androidx.lifecycle.ViewModel;

import com.github.therealroguewarlock.dirtbud.model.GarageModel;
import com.github.therealroguewarlock.dirtbud.model.impl.GarageModelImpl;

public class InventoryViewModel extends ViewModel {

    private final GarageModel garageModel;

    public InventoryViewModel() {
        garageModel = new GarageModelImpl();

    }


}
