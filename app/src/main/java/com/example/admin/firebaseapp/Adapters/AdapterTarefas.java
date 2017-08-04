package com.example.admin.firebaseapp.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.firebaseapp.R;
import com.example.admin.firebaseapp.Tarefas;

import java.util.List;

/**
 * Created by raphael on 03/08/17.
 */

public class AdapterTarefas  {

    private Activity context;
    List<Tarefas> listtarefa;

    public AdapterTarefas(Activity context, List<Tarefas> tarefases) {
        super(context, R.layout.layout_tarefas, tarefases);
        this.context = context;
        this.listtarefa = tarefases;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_artist_list, null, true);

       //

        return listViewItem;
    }}