package com.example.vendas_app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vendas_app.R;
import com.example.vendas_app.model.Venda;

import java.util.List;

public class VendasAdapter extends RecyclerView.Adapter<VendasAdapter.MyViewHolder> {

    public List<Venda> vendas;


    public VendasAdapter(List<Venda> vendas){
        this.vendas = vendas;
    }


    @NonNull
    @Override
    public VendasAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_venda, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VendasAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.titulo.setText(vendas.get(i).getProduto());
        myViewHolder.descricao.setText(vendas.get(i).getDescricao());
        myViewHolder.preco.setText(Float.toString(vendas.get(i).getPreco()));
    }

    @Override
    public int getItemCount() {
        return vendas.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo;
        public TextView descricao;
        public TextView preco;

        public MyViewHolder(View v) {
            super(v);
            titulo = v.findViewById(R.id.txt_venda_titulo);
            descricao = v.findViewById(R.id.txt_venda_descricao);
            preco = v.findViewById(R.id.txt_preco);
        }
    }
}
