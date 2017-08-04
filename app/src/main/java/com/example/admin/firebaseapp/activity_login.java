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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_login extends AppCompatActivity implements View.OnClickListener {


    private Button btnCadastrar;
    private EditText edEmail;
    private EditText edSenha;
    private TextView textAcessar;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),activity_profile.class));
        }
        progressDialog = new ProgressDialog(this);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edSenha = (EditText) findViewById(R.id.edSenha);
        textAcessar = (TextView) findViewById(R.id.textAcessar);

        btnCadastrar.setOnClickListener(this);
        textAcessar.setOnClickListener(this);
    }

    private void registerUser(){
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

            progressDialog.setMessage("Registrando usuário . . .");
            progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                                finish();
                                startActivity(new Intent(getApplicationContext(),menu.class));
                        }else{
                            Toast.makeText(activity_login.this, "Não pode se registrar... Tente novamente",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == btnCadastrar){
            registerUser();
        }
            if (view == textAcessar){

                startActivity(new Intent(this, activity_logar.class));
            }
        }

    }
