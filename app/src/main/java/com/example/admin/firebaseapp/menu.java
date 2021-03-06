package com.example.admin.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;


public class menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout Taretas,Materias,Calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewByIds();
        onclick();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    private void findViewByIds() {
        Taretas=(LinearLayout)findViewById(R.id.tarefas);
        Materias=(LinearLayout)findViewById(R.id.materias);

    }
    private void onclick() {
        Taretas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(menu.this, "Tarefas", Toast.LENGTH_SHORT).show();
                //implementar


            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_sair) {
            finish();
        }

        return super.onOptionsItemSelected(item);


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent menu = new Intent(this, menu.class);
            startActivity(menu);

        } else if (id == R.id.nav_mural) {
            Intent activity_mural = new Intent(this, activity_mural.class);
            startActivity(activity_mural);

        } else if (id == R.id.nav_calendar) {
            Intent listTarefas = new Intent(this, listTarefas.class);
            startActivity(listTarefas);

        } else if (id == R.id.nav_notas) {
            Intent listNotas = new Intent(this, listNotas.class);
            startActivity(listNotas);


        } else if (id == R.id.nav_materiais) {
            Intent ArquivosActivity = new Intent(this, ArquivosActivity.class);
            startActivity(ArquivosActivity);

        } else if (id == R.id.nav_chat) {

            Intent chatActivity = new Intent(this, chatActivity.class);
            startActivity(chatActivity);
        }

        else if (id == R.id.nav_logout) {
            Intent activity_login = new Intent(this, activity_login.class);
            startActivity(activity_login);
        }
        else if (id == R.id.nav_sair) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
