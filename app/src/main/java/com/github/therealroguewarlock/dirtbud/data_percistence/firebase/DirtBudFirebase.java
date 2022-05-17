package com.github.therealroguewarlock.dirtbud.data_percistence.firebase;

import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.User;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.List;

public interface DirtBudFirebase {

    void insert(DirtBike dirtBike);

    void update(DirtBike dirtBike);

    void delete(DirtBike dirtBike);

    void deleteAllDirtBikes();

    LiveData<User> getUser();

    LiveData<List<DirtBike>> getAllDirtBikes();

    DirtBike getDirtBike(int dirtBikeId);

    void insert(Part part);

    void update(Part part);

    void delete(Part part);

    void deleteAllParts();

    LiveData<List<Part>> getAllParts();

    Part getPart(int partId);

    List<Part> getParts(int dirtBikeId);
}

