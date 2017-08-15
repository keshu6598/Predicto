package com.frontend.kanishk.predicto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Croppredictor extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Spinner spinnero;
    ArrayAdapter<CharSequence> adaptero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_croppredictor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     spinner = (Spinner) findViewById(R.id.spinner);
        spinnero=(Spinner) findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this,R.array.soil_names,R.layout.support_simple_spinner_dropdown_item);
        adaptero=ArrayAdapter.createFromResource(this,R.array.income_names,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinnero.setAdapter(adaptero);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
            }
                @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(getBaseContext(),"Please Select Something",Toast.LENGTH_LONG).show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.croppredictor, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getBaseContext(),MainActivity.class);
            startActivity(i1);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this,"Crop Predictor",Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getBaseContext(),Croppredictor.class);
            startActivity(i1);
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this,"About Us",Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getBaseContext(),Aboutus.class);
            startActivity(i1);
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this,"C",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.ddd) {
            Toast.makeText(this,"D",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.eee) {
            Toast.makeText(this,"E",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.fff){
            Toast.makeText(this,"F",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
