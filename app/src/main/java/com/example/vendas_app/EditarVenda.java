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
import com.example.vendas_app.modelo.Venda;

public class EditarVenda extends AppCompatActivity {

    Button botaoSalvar;
    EditText edt1;
    EditText edt2;
    EditText edt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_venda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_vendas));

        edt1 = findViewById(R.id.edt_produto1);
        edt2 = findViewById(R.id.edt_preco1);
        edt3 = findViewById(R.id.edt_descricao1);

        botaoSalvar = findViewById(R.id.salvarbotao);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getIntent();
                int vendaId = i.getIntExtra("data", 0);

                Venda venda = Banco.getBanco(getApplicationContext()).vendaDao().getById(vendaId);
                venda.setProduto(edt1.getText().toString());
                venda.setPreco(Integer.parseInt(edt2.getText().toString()));
                venda.setDescricao(edt3.getText().toString());

                Banco.getBanco(getBaseContext()).vendaDao().update(venda);

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
