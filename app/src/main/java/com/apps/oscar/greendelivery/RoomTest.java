package com.apps.oscar.greendelivery;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.oscar.greendelivery.database.ReadDatabase;
import com.apps.oscar.greendelivery.database.ReadRepository;
import com.apps.oscar.greendelivery.model.Reading;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

public class RoomTest extends AppCompatActivity {
    ReadDatabase readDb;
    Reading readmodel;
    List<Reading> readingList;
    TextView txtsample;
    Button btnclick,btnadd;
    EditText edtname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //txtsample = findViewById(R.id.txtsample);
        btnclick = findViewById(R.id.btnclick);
        edtname=findViewById(R.id.edtname);
        btnadd=findViewById(R.id.btnadd);
        final ReadRepository readRepository=new ReadRepository(getApplicationContext());
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();

                readmodel = new Reading();
                readmodel.setReadId(random.nextInt());
                readmodel.setRecord("hyt");
                readmodel.setMeterNo("meterNo");
                readmodel.setCname(edtname.getText().toString().trim());
                readmodel.setPrdate("12/12");
                readRepository.insertRead(readmodel,"nothing");
            }
        });

        // new InsertReading(RoomTest.this,readmodel).execute();
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getReadings();
               // ReadRepository readRepository=new ReadRepository(getApplicationContext());
                //LiveData<List<Reading>> readingList=readRepository.getReadings();

                LifecycleOwner appContext;
                readRepository.getReadings().observe(RoomTest.this,new Observer<List<Reading>>() {
                    @Override
                    public void onChanged(@Nullable List<Reading> readings) {
                        for(Reading reading: readings) {
                            Log.e("dxtest", reading.getCname()+"/t"+readings.size());
                        }
                    }
                });
            }
        });


    }
}
/*
    private void getReadings() {
        readDb=ReadDatabase.getInstance(RoomTest.this);

        new RetrievReading(this).execute();
    }

    private void setResult(Reading readmodel, int flag){
        setResult(flag,new Intent().putExtra("reading", (Serializable) readmodel));
        finish();
    }

    public static class InsertReading extends AsyncTask<Void,Void,Boolean> {
        private WeakReference<RoomTest> activityReference;
        private Reading readmodel;

        InsertReading(RoomTest context, Reading readmodel) {
            activityReference = new WeakReference<>(context);
            this.readmodel = readmodel;

        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            activityReference.get().readDb.readingDao().insert(readmodel);
            Log.e("roomxi",activityReference.get().readDb.readingDao().readinglist().size()+"");

            return true;
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool){
                activityReference.get().setResult(readmodel,1);
                Log.e("roomxi",activityReference.get().readDb.readingDao().readinglist().size()+"");
            }
        }
    }

    public static class RetrievReading  extends AsyncTask<Void,Void,List<Reading>> {
         WeakReference<RoomTest> activityReference;

            // only retain a weak reference to the activity
        RetrievReading(RoomTest contextb) {
            activityReference = new WeakReference<>(contextb);
        }

        @Override
        protected List<Reading> doInBackground(Void... voids) {
            if (activityReference.get()!=null)
                return activityReference.get().readDb.readingDao().readinglist();
            else
                return null;
        }

        @Override
        protected void onPostExecute(List<Reading> readingList) {
            Log.e("roomsz",readingList.size()+"");
            if (readingList!=null && readingList.size()>0 ) {
                activityReference.get().readingList = readingList;
                activityReference.get().txtsample.setText("Test");
                Log.e("roomdx",readingList.get(0).getCname().toString()+"/t"+readingList.size());
            }
        }
    }
}*/
