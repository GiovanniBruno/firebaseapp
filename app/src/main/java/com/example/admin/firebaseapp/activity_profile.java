package com.example.admin.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_profile extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button btnLogout;
    private Button btnAcessar;
    private TextView textViewUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth == null){
            finish();
            startActivity(new Intent(this,activity_logar.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Bem Vindo " + user.getEmail());
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);

        btnLogout.setOnClickListener(this);
        btnAcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == btnLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, activity_logar.class));
        }
        if (view == btnAcessar){
            finish();
            startActivity(new Intent(this, menu.class));
        }
    }
}

