package com.example.admin.firebaseapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class listTarefas extends AppCompatActivity {
    private ListView listViewTarefas;
    private DatabaseReference databaseTarefas;
    List<Tarefas> tarefasList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tarefas);
        listViewTarefas = (ListView) findViewById(R.id.listView_tarefas);
        tarefasList = new ArrayList<>();
        databaseTarefas = FirebaseDatabase.getInstance().getReference("tarefas");
        databaseTarefas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tarefasList.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Tarefas  tarefas = snapshot.getValue(Tarefas.class);
                    tarefasList.add(tarefas);

                }
                //Adapter

                AdapterTarefas adapter = new AdapterTarefas(listTarefas.this,tarefasList );

                listViewTarefas.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent criarTarefas = new Intent(getApplicationContext(), criarTarefas.class);
                        startActivity(criarTarefas);

                    }
                });
            }
        });

    }


}



