package com.github.therealroguewarlock.dirtbud.model.datapercistance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBikeWithPart;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

@Database(entities = {Part.class}, version = 1)
public abstract class DirtBudDatabase extends RoomDatabase {
	private static DirtBudDatabase instance;

	public abstract DirtBudDAO getDirtBudDAO();

	public static synchronized DirtBudDatabase getInstance(Context context) {
		if (instance == null) {
			instance = Room.databaseBuilder(context.getApplicationContext(), DirtBudDatabase.class, "dirt_bud_database").fallbackToDestructiveMigration().build();
		}
		return instance;
	}
}
