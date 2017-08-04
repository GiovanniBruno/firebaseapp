package com.example.admin.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class criarNotas extends AppCompatActivity {


    private EditText edMateriaNota;
    private EditText edNota;
    private Button btnSalvarnotas;
    DatabaseReference bancotarefa;
    List<Notas> listnotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criarnotas);

        edMateriaNota = (EditText) findViewById(R.id.edmaterianota);
        edNota = (EditText) findViewById(R.id.ednota);
        btnSalvarnotas = (Button) findViewById(R.id.btnSalvarnotas);

        bancotarefa = FirebaseDatabase.getInstance().getReference("notas");


        btnSalvarnotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String materiasnotas=(edMateriaNota.getText().toString());
                String nota=(edNota.getText().toString());


                String id  = bancotarefa.push().getKey();
                Notas notas = new Notas(id,materiasnotas,nota);
                bancotarefa.child(id).setValue(notas);
                finish();


            }

        });




    }
}



