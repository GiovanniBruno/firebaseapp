package com.example.admin.firebaseapp;

/**
 * Created by Admin on 01/08/2017.
 */

public class CarregarImagem {

    public String name;
    public String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public CarregarImagem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public CarregarImagem(){}
}
