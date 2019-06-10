package com.example.vendas_app.dados;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vendas_app.modelo.Venda;

import java.util.List;

@Dao
public interface VendaDao {

    @Query("SELECT * FROM venda")
    List<Venda> getAll();

    @Query("SELECT * FROM venda WHERE id = :id")
    Venda getById(int id);

    @Insert
    void insert(Venda venda);

    @Delete
    void remove(Venda venda);

    @Update
    void update(Venda venda);

}
