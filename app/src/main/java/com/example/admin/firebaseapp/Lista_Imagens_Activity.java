package com.example.admin.firebaseapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Lista_Imagens_Activity extends AppCompatActivity {

    private DatabaseReference mDatabaseRef;
    private List<CarregarImagem> imagemList;
    private ListView lv;
    private ListaImagensAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__imagens_);

        imagemList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listviewImagens);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Espere o carregamento da lista de imagens por favor...");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(ArquivosActivity.FB_DATABASE_PATH);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                progressDialog.dismiss();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    CarregarImagem img = snapshot.getValue(CarregarImagem.class);
                    imagemList.add(img);
                }

                adapter = new ListaImagensAdapter(Lista_Imagens_Activity.this, R.layout.imagem_item, imagemList);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();
            }
        });


    }
}
