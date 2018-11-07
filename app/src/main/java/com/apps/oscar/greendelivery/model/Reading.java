package com.apps.oscar.greendelivery.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Reading {

    @PrimaryKey//(autoGenerate = true)
    private int readId;
    private String record;
    private String meterNo;
    private String cname;
    private String prdate;

    /*public Reading(int readId, String record, String meterNo, String cname, String prdate) {
        this.readId = readId;
        this.record = record;
        this.meterNo = meterNo;
        this.cname = cname;
        this.prdate = prdate;
    }*/

    public int getReadId() {
        return readId;
    }

    public void setReadId(int readId) {
        this.readId = readId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPrdate() {
        return prdate;
    }

    public void setPrdate(String prdate) {
        this.prdate = prdate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reading)) return false;

        Reading Reading = (Reading) o;

        if (readId != Reading.readId) return false;
        return record != null ? record.equals(Reading.record) : Reading.record == null;
    }



    @Override
    public int hashCode() {
        int result = readId;
        result = 31 * result + (record != null ? record.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "ReadId=" + readId +
                ", content='" + record + '\'' +
                ", title='" + cname + '\'' +
                '}';
    }
}
