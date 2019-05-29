package com.example.vendas_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vendas_app.adapter.RecyclerItemClickListener;
import com.example.vendas_app.adapter.VendasAdapter;
import com.example.vendas_app.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Venda> vendas = new ArrayList<>();
    public static Venda vendaSelecionada;

    private RecyclerView recyclerView;
    private VendasAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.title_principal));

        recyclerView = findViewById(R.id.rv_vendas);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new VendasAdapter(vendas);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        showAlertDialog(position);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // not implemented
                    }
                })
        );


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CadastraVendaActivity.class);
                startActivity(it);
            }
        });
    }

    private void showAlertDialog(int position) {
        vendaSelecionada = vendas.get(position);

        final String[] options = {
                ("Editar"),
                ("Remover"),
                ("Inserir pendência")
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Opções");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (options[which].equals("Inserir pendência")){
                    Intent it = new Intent(MainActivity.this, PendenciaActivity.class);
                    //it.putExtra("data",selectedOcurrence);
                    startActivity(it);
                }
                else if(options[which].equals("Remover")){
                    //remove(selectedOcurrence);
                }
            }
        });
        builder.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent it = new Intent(MainActivity.this, ConfiguracaoActivity.class);
            startActivity(it);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
