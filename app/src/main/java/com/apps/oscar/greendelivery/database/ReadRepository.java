package com.apps.oscar.greendelivery.database;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;

import com.apps.oscar.greendelivery.model.Reading;

import java.util.List;

public class ReadRepository {
    private String DB_NAME="reading-db";
    private ReadDatabase readDatabase;

    public ReadRepository(Context context){
        readDatabase= Room.databaseBuilder(context,ReadDatabase.class,DB_NAME).addMigrations(MIGRATION_2_3).build();
    }
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
// Since we didn't alter the table, there's nothing else to do here.
        }
    };
     public void insertRead(Reading reading,String something){
        insertRead(reading);
     }

     public void insertRead(final Reading reading) {
         new AsyncTask<Void, Void, Void>() {

             @Override
             protected Void doInBackground(Void... voids) {
                 readDatabase.readingDao().insert(reading);
                 return null;
             }

         }.execute();
     }

     public LiveData<List<Reading>>getReadings(){

        return readDatabase.readingDao().readinglist();
     }



}
