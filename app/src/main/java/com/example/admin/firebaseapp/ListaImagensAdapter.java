package com.example.admin.firebaseapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 01/08/2017.
 */

public class ListaImagensAdapter extends ArrayAdapter<CarregarImagem> {

    private Activity context;
    private int resource;
    private List<CarregarImagem> imagemList;

    public ListaImagensAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<CarregarImagem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        imagemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater Inflater = context.getLayoutInflater();

        View v = Inflater.inflate(resource, null);
        TextView tvName = (TextView) v.findViewById(R.id.tvImagemName);
        ImageView img = (ImageView) v.findViewById(R.id.imgView);

        tvName.setText(imagemList.get(position).getName());
        Glide.with(context).load(imagemList.get(position).getUrl()).into(img);

        return v;
    }
}


