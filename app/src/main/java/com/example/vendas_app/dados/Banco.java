package com.example.vendas_app.dados;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.vendas_app.model.Pendencia;
import com.example.vendas_app.model.Venda;

@Database(entities = {Pendencia.class, Venda.class}, version = 1)
public abstract class Banco extends RoomDatabase {

    private static String DATABASE_NAME = "vendas_app";
    private static Banco INSTANCE;

    public abstract PendenciaDao pendenciaDao();
    public abstract VendaDao vendaDao();

    public static Banco getBanco(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), Banco.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
