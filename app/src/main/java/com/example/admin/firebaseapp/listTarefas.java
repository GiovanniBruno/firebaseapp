package com.example.admin.firebaseapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class listTarefas extends AppCompatActivity {

    private TextView textViewAssunto;
    private TextView textViewData;
    private TextView textViewDescricao;
    private TextView textViewCurso;
    private TextView textViewMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tarefas);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent criarTarefas = new Intent (getApplicationContext(),criarTarefas.class);
                        startActivity(criarTarefas);

                    }
                });
            }
        });

        textViewAssunto = (TextView) findViewById(R.id.textViewAssunto);
        textViewData = (TextView) findViewById(R.id.textViewData);
        textViewDescricao = (TextView) findViewById(R.id.textViewDescricao);
        textViewCurso = (TextView) findViewById(R.id.textViewCurso);
        textViewMateria = (TextView) findViewById(R.id.textViewMateria);

        String assunto = getIntent().getStringExtra("assunto");
        String data = getIntent().getStringExtra("data");
        String descricao = getIntent().getStringExtra("descrição");
        String curso = getIntent().getStringExtra("curso");
        String materia = getIntent().getStringExtra("materia");


        textViewAssunto.setText(assunto);
        textViewData.setText(data);
        textViewDescricao.setText(descricao);
        textViewCurso.setText(curso);
        textViewMateria.setText(materia);



    }
}



