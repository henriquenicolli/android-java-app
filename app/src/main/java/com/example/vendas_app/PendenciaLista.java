package com.example.vendas_app;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vendas_app.dados.Banco;
import com.example.vendas_app.modelo.Pendencia;
import com.example.vendas_app.modelo.Venda;

import java.util.List;

public class PendenciaLista extends RecyclerView.Adapter<PendenciaLista.MyViewHolder> {

    public List<Pendencia> pendencias;
    Context context;
    Activity activity;

    public PendenciaLista(List<Pendencia> pendencias, Context ctx, Activity activity){
        this.pendencias = pendencias;
        this.context = ctx;
        this.activity = activity;
    }


    @NonNull
    @Override
    public PendenciaLista.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_venda, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PendenciaLista.MyViewHolder myViewHolder, int i) {
        myViewHolder.titulo.setText(pendencias.get(i).getData_lancamento());
        myViewHolder.descricao.setText(pendencias.get(i).getData_vencimento());
        myViewHolder.preco.setText(pendencias.get(i).getObservacao());

        final Pendencia pendenciaSelecionada = pendencias.get(i);

        myViewHolder.acao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] valores = {
                        (activity.getString(R.string.remove)),
                        (activity.getString(R.string.edit)),
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(activity.getString(R.string.options));
                builder.setItems(valores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int index) {

                        if(valores[index].equals(activity.getString(R.string.remove))){
                            removerPendencia(pendenciaSelecionada);
                        }
                        else if (valores[index].equals(activity.getString(R.string.edit))){
                            Intent intent = new Intent(context , EditarPendencia.class);
                            intent.putExtra("data", pendenciaSelecionada.getId());
                            activity.startActivity(intent);
                        }

                    }
                });

                builder.show();
            }

        });
    }


    private void removerPendencia(final Pendencia pendenciaSelecionada) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.title));
        builder.setMessage(activity.getString(R.string.delete));
        builder.setPositiveButton(activity.getString(R.string.confirm), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Banco.getBanco(activity).pendenciaDao().remove(pendenciaSelecionada);
                Intent it = new Intent(context, MainActivity.class);
                context.startActivity(it);
            }
        });
        builder.setNegativeButton(activity.getString(R.string.negative), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        builder.create();
        builder.show();


    }

    @Override
    public int getItemCount() {
        return pendencias.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo;
        public TextView descricao;
        public TextView preco;
        public Button acao;

        public MyViewHolder(View v) {
            super(v);
            titulo = v.findViewById(R.id.txt_venda_titulo);
            descricao = v.findViewById(R.id.txt_venda_descricao);
            preco = v.findViewById(R.id.txt_preco);
            acao = v.findViewById(R.id.acoes);
        }
    }
}
