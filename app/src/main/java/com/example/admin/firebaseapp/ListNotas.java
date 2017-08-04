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

public class listNotas extends AppCompatActivity {

    private ListView listViewNotas;
    private DatabaseReference databaseNotas;
    List<Notas> notasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notas);
        listViewNotas = (ListView) findViewById(R.id.listView_notas);
        notasList = new ArrayList<>();
        databaseNotas = FirebaseDatabase.getInstance().getReference("notas");
        databaseNotas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notasList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Notas notas = snapshot.getValue(Notas.class);
                    notasList.add(notas);

                }
                //Adapter

                AdapterNotas adapter = new AdapterNotas(listNotas.this,notasList);

                listViewNotas.setAdapter(adapter);

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
                        Intent activityNotas = new Intent(getApplicationContext(), criarNotas.class);
                        startActivity(activityNotas);

                    }
                });
            }
        });
    }


}

