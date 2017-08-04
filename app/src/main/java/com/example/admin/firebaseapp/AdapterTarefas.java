package com.example.admin.firebaseapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterTarefas extends ArrayAdapter<Tarefas> {
    private Activity context;
    private List<Tarefas> tarefasList;

    public AdapterTarefas(Activity context, List<Tarefas> tarefasList) {
        super(context, R.layout.adapter_tarefas, tarefasList);
        this.context = context;
        this.tarefasList = tarefasList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.adapter_tarefas, parent, false);

        TextView textViewAssunto = (TextView) listViewItem.findViewById(R.id.list_item_assunto);
        TextView textViewData = (TextView) listViewItem.findViewById(R.id.list_item_data);
        TextView textViewDescricao = (TextView) listViewItem.findViewById(R.id.list_item_descricao);
        TextView textViewCurso = (TextView) listViewItem.findViewById(R.id.list_item_curso);
        TextView textViewMateria = (TextView) listViewItem.findViewById(R.id.list_item_materia);


        Tarefas tarefas = tarefasList.get(position);
        textViewAssunto.setText(tarefas.getAssunto());
        textViewData.setText(tarefas.getData());
        textViewDescricao.setText(tarefas.getDescricao());
        textViewCurso.setText(tarefas.getCurso());
        textViewMateria.setText(tarefas.getMateria());

        return listViewItem;
    }


}
