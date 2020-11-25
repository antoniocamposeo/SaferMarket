package com.example.asuper;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import java.util.ArrayList;

public class Ricerca_Prodotto extends AppCompatActivity {

    private ListView listView;
    public static ArrayList<Supermarket> arrayList= new ArrayList<Supermarket>();
    private ArrayAdapter<Supermarket>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca__prodotto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listview);

        adapter = new ArrayAdapter<Supermarket>(Ricerca_Prodotto.this , android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.listview);

        return super.onCreateOptionsMenu(menu);
    }
}