package com.example.admin.firebaseapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_logar extends AppCompatActivity implements View.OnClickListener {

    private Button btnAcessar;
    private EditText edEmail;
    private EditText edSenha;
    private TextView textInscrever;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        //profile activity aqui
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),activity_profile.class));
        }

        btnAcessar = (Button) findViewById(R.id.btnAcessar);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edSenha = (EditText) findViewById(R.id.edSenha);
        textInscrever = (TextView) findViewById(R.id.textInscrever);

        btnAcessar.setOnClickListener(this);
        textInscrever.setOnClickListener(this);
    }

    private void userLogin(){
        String email = edEmail.getText().toString().trim();
        String senha = edSenha.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //email vazio
            Toast.makeText(this, "Por favor, insira um email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(senha)){
            //senha vazia
            Toast.makeText(this, "Por favor, insira sua senha", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Acessando . . .");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            //start profile acitivty
                            finish();
                            startActivity(new Intent(getApplicationContext(),activity_profile.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == btnAcessar) {
            userLogin();
        }
            if (view == textInscrever){
                finish();
                startActivity(new Intent(this, activity_login.class));
            }
        }
    }

