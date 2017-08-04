package com.example.admin.firebaseapp;

/**
 * Created by Admin on 04/08/2017.
 */

public class Notas {
    public String getIdNotas(){return idNotas; }

    private String idNotas;
    private String materianota;
    private String nota;

    public Notas() {
    }

    public Notas(String idNotas, String materianota, String nota) {
        this.idNotas = idNotas;
        this.materianota = materianota;
        this.nota = nota;
    }
    public void setIdNotas(String idNotas) {this.idNotas = idNotas;}

    public String getMaterianota() {
        return materianota;
    }

    public void setMaterianota(String materianota) {
        this.materianota = materianota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


    }



