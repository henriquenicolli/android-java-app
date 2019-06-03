package com.example.vendas_app.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "pendencia")
public class Pendencia {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "cityName")
    public String cityName;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(index = true)
    private int ocurrenceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getOcurrenceId() {
        return ocurrenceId;
    }

    public void setOcurrenceId(int ocurrenceId) {
        this.ocurrenceId = ocurrenceId;
    }
}
