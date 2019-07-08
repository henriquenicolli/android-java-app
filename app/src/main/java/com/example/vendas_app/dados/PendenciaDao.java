package com.example.vendas_app.dados;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vendas_app.modelo.Pendencia;
import com.example.vendas_app.modelo.Venda;

import java.util.List;

@Dao
public interface PendenciaDao {

    @Query("SELECT * FROM pendencia")
    List<Pendencia> getAll();

    @Query("SELECT * FROM pendencia WHERE id = :id")
    Pendencia getById(int id);

    @Query("SELECT * FROM pendencia WHERE vendaId = :id")
    List<Pendencia> getByVendaId(int id);

    @Insert
    void insert(Pendencia pendencia);

    @Delete
    void remove(Pendencia pendencia);

    @Update
    void update(Pendencia pendencia);

}
