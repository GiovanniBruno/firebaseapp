package com.example.admin.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class criarTarefas extends AppCompatActivity {

    private EditText edAssunto;
    private EditText edData;
    private EditText edDescricao;
    private EditText edCurso;
    private EditText edMateria;
    private Button btnSalvar;
    private Button btnCancelar;

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


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dadosTarefas dadosDasTarefas = new dadosTarefas();
                dadosDasTarefas.setAssunto(edAssunto.getText().toString());
                dadosDasTarefas.setData(edData.getText().toString());
                dadosDasTarefas.setDescricao(edDescricao.getText().toString());
                dadosDasTarefas.setCurso(edCurso.getText().toString());
                dadosDasTarefas.setMateria(edMateria.getText().toString());

                Intent it = new Intent(criarTarefas.this, listTarefas.class);
                it.putExtra("assunto", edAssunto.getText().toString());
                it.putExtra("data", edData.getText().toString());
                it.putExtra("descrição", edDescricao.getText().toString());
                it.putExtra("curso", edCurso.getText().toString());
                it.putExtra("materia", edMateria.getText().toString());

                startActivity(it);

            }
        });


    }
}
