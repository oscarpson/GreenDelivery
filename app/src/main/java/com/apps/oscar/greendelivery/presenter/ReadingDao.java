package com.apps.oscar.greendelivery.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.support.annotation.RequiresPermission;

import com.apps.oscar.greendelivery.model.Reading;

import java.util.List;

@Dao
public interface ReadingDao {
    @Query("SELECT * FROM reading")
    LiveData<List<Reading>>readinglist();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Reading reading);

}
