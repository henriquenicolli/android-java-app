package com.example.vendas_app.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "venda")
public class Venda {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "produto")
    private String produto;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @ColumnInfo(name = "preco")
    private float preco;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
