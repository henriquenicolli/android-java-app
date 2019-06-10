package com.example.vendas_app.modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pendencia", foreignKeys = @ForeignKey(entity = Venda.class, parentColumns = "id", childColumns = "vendaId"))
public class Pendencia {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "observacoes")
    public String observacao;

    @ColumnInfo(name = "data_vencimento")
    public String data_vencimento;

    @ColumnInfo(name = "data_lancamento")
    public String data_lancamento;

    @ColumnInfo(index = true)
    public int vendaId;

    public int getId() {
        return id;
    }

    public String getObservacao() {
        return observacao;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
}
