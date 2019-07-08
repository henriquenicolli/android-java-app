package com.example.vendas_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vendas_app.dados.Banco;
import com.example.vendas_app.modelo.Pendencia;
import com.example.vendas_app.modelo.Venda;

import java.util.ArrayList;
import java.util.List;

public class VerPendencias extends AppCompatActivity {


    public static List<Pendencia> pendencias = new ArrayList<>();
    public static Pendencia pendenciaSelecionada;

    private RecyclerView recyclerView;
    private PendenciaLista adapter;
    private RecyclerView.LayoutManager layoutManager;

    private int vendaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pendencias);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(this.getString(R.string.pendent));


        Intent i = getIntent();
        vendaId = i.getIntExtra("data", 0);


        recyclerView = findViewById(R.id.rv_pendencias);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PendenciaLista(pendencias, this,this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    protected void onResume() {
        super.onResume();

        pendencias = Banco.getBanco(VerPendencias.this).pendenciaDao().getByVendaId(vendaId);
        adapter = new PendenciaLista(pendencias, this,this);
        recyclerView.setAdapter(adapter);
       
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
