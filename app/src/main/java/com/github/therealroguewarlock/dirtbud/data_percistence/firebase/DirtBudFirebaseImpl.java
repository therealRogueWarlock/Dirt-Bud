package com.github.therealroguewarlock.dirtbud.data_percistence.firebase;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.*;


import java.util.List;

public class DirtBudFirebaseImpl implements DirtBudFirebase{

    private FirebaseFirestore fireStoreDB;
    private static DirtBudFirebase instance;


    private DirtBudFirebaseImpl() {
        fireStoreDB = FirebaseFirestore.getInstance();
        Log.d("fireStore test", "FirebaseImple init");
        fireStoreDB.collection("users")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d("fireStore test", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.w("fireStore test", "Error getting documents.", task.getException());
                    }
                });
    }

    public static DirtBudFirebase getInstance() {
        if (instance == null) {
            instance = new DirtBudFirebaseImpl();
        }
        return instance;
    }

    @Override
    public void insert(DirtBike dirtBike) {

    }

    @Override
    public void update(DirtBike dirtBike) {

    }

    @Override
    public void delete(DirtBike dirtBike) {

    }

    @Override
    public void deleteAllDirtBikes() {

    }

    @Override
    public LiveData<List<DirtBike>> getAllDirtBikes() {
        return null;
    }

    @Override
    public DirtBike getDirtBike(int dirtBikeId) {
        return null;
    }

    @Override
    public void insert(Part part) {

    }

    @Override
    public void update(Part part) {

    }

    @Override
    public void delete(Part part) {

    }

    @Override
    public void deleteAllParts() {

    }

    @Override
    public LiveData<List<Part>> getAllParts() {
        return null;
    }

    @Override
    public Part getPart(int partId) {
        return null;
    }

    @Override
    public List<Part> getParts(int dirtBikeId) {
        return null;
    }
}
