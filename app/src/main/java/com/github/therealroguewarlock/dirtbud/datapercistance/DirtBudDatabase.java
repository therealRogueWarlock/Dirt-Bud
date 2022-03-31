package com.github.therealroguewarlock.dirtbud.datapercistance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

@Database(entities = {Part.class, DirtBike.class}, version = 2)
public abstract class DirtBudDatabase extends RoomDatabase {
	private static DirtBudDatabase instance;

	public abstract DirtBudDAO getDirtBudDAO();

	public static synchronized DirtBudDatabase getInstance(Context applicationContext) {
		if (instance == null) {
			instance = Room.databaseBuilder(applicationContext, DirtBudDatabase.class, "dirt_bud_database").fallbackToDestructiveMigration().build();
		}
		return instance;
	}
}
