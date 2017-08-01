package com.example.admin.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activityNotas extends AppCompatActivity {

    public void clique(View view){



        EditText Nota1 = (EditText) findViewById(R.id.Nota1);
        EditText Nota2 = (EditText) findViewById(R.id.Nota2);
        Button calcmedia = (Button) findViewById(R.id.btncalcular);
        TextView media = (TextView) findViewById(R.id.Media);

        if (Nota1.getText().length() > 0 && Nota2.getText().length() > 0 ){
            String Tnota1 = String.valueOf(Nota1);
            String Tnota2 = String.valueOf(Nota2);

            float n1 = Float.valueOf(Tnota1);
            float n2 = Float.valueOf(Tnota2);
            float m = (n1 + n2)/2;

            String Tmedia = Float.toString(m);
            media.setText(Tmedia);

            media.setText((int) m);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);





    }
};
