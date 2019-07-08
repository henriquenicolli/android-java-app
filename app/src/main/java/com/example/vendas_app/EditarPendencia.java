package com.example.vendas_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vendas_app.dados.Banco;
import com.example.vendas_app.modelo.Pendencia;
import com.example.vendas_app.modelo.Venda;

public class EditarPendencia extends AppCompatActivity {

    Button botaoSalvar;
    EditText edt1;
    EditText edt2;
    EditText edt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pendencia);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.edit));

        edt1 = findViewById(R.id.edt_produto1);
        edt2 = findViewById(R.id.edt_preco1);
        edt3 = findViewById(R.id.edt_descricao1);

        botaoSalvar = findViewById(R.id.salvarbotao);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getIntent();
                int pendenciaId = i.getIntExtra("data", 0);

                Pendencia pendencia = Banco.getBanco(getApplicationContext()).pendenciaDao().getById(pendenciaId);
                pendencia.setData_lancamento(edt1.getText().toString());
                pendencia.setData_vencimento(edt2.getText().toString());
                pendencia.setObservacao(edt3.getText().toString());

                Banco.getBanco(getBaseContext()).pendenciaDao().update(pendencia);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
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
