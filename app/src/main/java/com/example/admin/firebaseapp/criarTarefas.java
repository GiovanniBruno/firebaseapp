package com.example.admin.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static android.R.attr.rating;

public class criarTarefas extends AppCompatActivity {

    private EditText edAssunto;
    private EditText edData;
    private EditText edDescricao;
    private EditText edCurso;
    private EditText edMateria;
    private Button btnSalvar;
    private Button btnCancelar;
    DatabaseReference bancotarefa;
    List<Tarefas> listtarefases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criartarefas);
        edAssunto = (EditText) findViewById(R.id.edAssunto);
        edData = (EditText) findViewById(R.id.edData);
        edDescricao = (EditText) findViewById(R.id.edDescricao);
        edCurso = (EditText) findViewById(R.id.edCurso);
        edMateria = (EditText) findViewById(R.id.edMateria);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        bancotarefa =FirebaseDatabase.getInstance().getReference("tarefas");


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String assunto=(edAssunto.getText().toString());
                String data=(edData.getText().toString());
                String descricao=(edDescricao.getText().toString());
                String curso=(edCurso.getText().toString());
                String materias=(edMateria.getText().toString());

                String id  = bancotarefa.push().getKey();
                Tarefas tarefas = new Tarefas(id,assunto,data,descricao,curso,materias);
                bancotarefa.child(id).setValue(tarefas);
                finish();


            }

        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCancelar.setText(" ");
            }
        });

    }
}
