package com.example.vendas_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vendas_app.dados.Banco;
import com.example.vendas_app.modelo.Venda;

public class CadastraVenda extends AppCompatActivity {

    EditText edtTitutlo;
    EditText edtDescricao;
    EditText edtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_venda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_vendas));

          edtTitutlo = findViewById(R.id.produto);
          edtDescricao = findViewById(R.id.descricao);
          edtPreco = findViewById(R.id.preco);

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
                finish();
                return true;
                
            case R.id.action_save:
                cadastraVenda();
                
                
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cadastraVenda() {
        Toast.makeText(this,"Venda Cadastrada", Toast.LENGTH_LONG).show();

        Venda venda = new Venda();

        venda.setProduto(edtTitutlo.getText().toString());
        venda.setDescricao(edtDescricao.getText().toString());
        venda.setPreco(Float.valueOf(edtPreco.getText().toString()));

        Banco.getBanco(CadastraVenda.this).vendaDao().insert(venda);

        finish();
    }
}
