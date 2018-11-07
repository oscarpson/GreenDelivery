package com.apps.oscar.greendelivery.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.RequiresPermission;

import com.apps.oscar.greendelivery.model.Reading;
import com.apps.oscar.greendelivery.presenter.ReadingDao;

@Database(entities = {Reading.class},version =2 )
public abstract class ReadDatabase extends RoomDatabase {
    public abstract ReadingDao readingDao();
     /*public static ReadDatabase readDatabase;
     public static ReadDatabase getInstance(Context context){
         if(null==readDatabase){
             readDatabase= Room.databaseBuilder( context.getApplicationContext(),
                     ReadDatabase.class,
                     "reading-db")
                     .allowMainThreadQueries()
                     .addMigrations(MIGRATION_1_2)
                     .build();
         }
         return readDatabase;
     }
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
// Since we didn't alter the table, there's nothing else to do here.
        }
    };*/
     /*
     here test for delete and update
      */
}
