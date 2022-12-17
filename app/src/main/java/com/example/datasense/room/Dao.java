package com.example.datasense.room;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(DataModel model);

    @Query("SELECT * FROM data_table")
    LiveData<List<DataModel>> getAllData();
}
