package com.github.therealroguewarlock.dirtbud.datapercistance;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.List;

@Dao
public interface DirtBudDAO {
//	// DirtBike
//	@Insert(onConflict = OnConflictStrategy.ABORT,entity = DirtBike.class)
//	void insert(DirtBike dirtBike);
//
//	@Update(onConflict = OnConflictStrategy.ABORT,entity = DirtBike.class)
//	void update(DirtBike dirtBike);
//
//	@Delete()
//	void delete(DirtBike dirtBike);
//
//	@Query("DELETE FROM dirt_bike_table")
//	void deleteAllDirtBikes();
//
//	@Query("SELECT * FROM dirt_bike_table")
//	LiveData<List<DirtBike>> getAllDirtBikes();
//
//	@Query("SELECT * FROM dirt_bike_table WHERE dirtBikeId = :dirtBikeId")
//	DirtBike getDirtBike(int dirtBikeId);

	// Part
	@Insert(onConflict = OnConflictStrategy.ABORT, entity = Part.class)
	void insert(Part part);

	@Update(onConflict = OnConflictStrategy.ABORT, entity = Part.class)
	void update(Part part);

	@Delete()
	void delete(Part part);

	@Query("DELETE FROM part_table")
	void deleteAllParts();

	@Query("SELECT * FROM part_table")
	LiveData<List<Part>> getAllParts();

	@Query("SELECT * FROM part_table WHERE partId = :partId")
	Part getPart(int partId);
}
