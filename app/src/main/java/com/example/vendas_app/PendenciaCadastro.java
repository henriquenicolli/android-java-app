package com.example.vendas_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vendas_app.dados.Banco;
import com.example.vendas_app.modelo.Pendencia;

public class PendenciaCadastro extends AppCompatActivity {

    EditText edt1;
    EditText edt2;
    EditText edt3;
    int vendaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendencia);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pendências");

        Intent i = getIntent();
        vendaId = i.getIntExtra("data", 0);

        edt1 = findViewById(R.id.editText);
        edt2 = findViewById(R.id.editText2);
        edt3 = findViewById(R.id.editText3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastra_venda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_save:
                cadastraPendencia();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cadastraPendencia() {
        Toast.makeText(this,"Pendencia cadastrada", Toast.LENGTH_SHORT).show();

        Pendencia pendencia = new Pendencia();
        pendencia.setObservacao(edt1.getText().toString());
        pendencia.setData_lancamento(edt2.getText().toString());
        pendencia.setData_vencimento((edt3.getText().toString()));
        pendencia.setVendaId(vendaId);

        Banco.getBanco(PendenciaCadastro.this).pendenciaDao().insert(pendencia);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
