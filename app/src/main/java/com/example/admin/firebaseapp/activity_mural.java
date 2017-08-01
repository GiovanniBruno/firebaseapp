package com.example.admin.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class activity_mural extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mural);

        pdfView = (PDFView) findViewById(R.id.pdfcalendario);

        pdfView.fromAsset("calendario2017.pdf").load();
    }
}
