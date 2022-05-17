package com.github.therealroguewarlock.dirtbud.data_percistence.firebase;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.therealroguewarlock.dirtbud.model.entities.User;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;


import java.util.List;
import java.util.Map;

public class DirtBudFirebaseImpl implements DirtBudFirebase {

    private FirebaseFirestore fireStoreDB;
    private static DirtBudFirebase instance;
    private final FirebaseUser firebaseUser;


    private DirtBudFirebaseImpl() {
        fireStoreDB = FirebaseFirestore.getInstance();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    }

    public static DirtBudFirebase getInstance() {
        if (instance == null) {
            instance = new DirtBudFirebaseImpl();
        }
        return instance;
    }

    public LiveData<User> getUser() {

        MutableLiveData<User> liveUser = new MutableLiveData<>();

        fireStoreDB.collection("users").document(firebaseUser.getUid()).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d("getUser", "DocumentSnapshot data: " + document.getData());
                                Map<String, Object> dataObj = document.getData();
                                Gson gson = new Gson();
                                JsonElement jsonElement = gson.toJsonTree(dataObj);
                                User user = gson.fromJson(jsonElement, User.class);
                                liveUser.postValue(user);
                            } else {
                                Log.d("getUser", "No such document");
                            }
                        } else {
                            Log.d("getUser", "get failed with ", task.getException());
                        }
                    }
                });

        return liveUser;
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
