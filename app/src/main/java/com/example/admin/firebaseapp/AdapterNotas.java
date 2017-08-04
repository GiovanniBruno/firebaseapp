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

/**
 * Created by Admin on 04/08/2017.
 */

public class AdapterNotas extends ArrayAdapter<Notas> {
    private Activity context;
    private List<Notas> notasList;

    public AdapterNotas(Activity context, List<Notas> notasList) {
        super(context, R.layout.adapter_notas, notasList);
        this.context = context;
        this.notasList = notasList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.adapter_notas, parent, false);

        TextView textViewMateriaNota = (TextView) listViewItem.findViewById(R.id.list_item_materianota);
        TextView textViewNota = (TextView) listViewItem.findViewById(R.id.list_item_nota);


        Notas notas = notasList.get(position);
        textViewMateriaNota.setText(notas.getMaterianota());
        textViewNota.setText(notas.getNota());

        return listViewItem;
    }
}

