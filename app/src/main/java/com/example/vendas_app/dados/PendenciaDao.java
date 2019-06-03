package com.example.vendas_app.dados;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vendas_app.model.Pendencia;

import java.util.List;

@Dao
public interface PendenciaDao {

    @Query("SELECT * FROM pendencia")
    List<Pendencia> getAll();

    @Insert
    void insert(Pendencia pendencia);

    @Delete
    void remove(Pendencia pendencia);

    @Update
    void update(Pendencia pendencia);

}
