package com.example.asuper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.asuper.R.menu.menu;

public class Ricerca_Supermercato extends AppCompatActivity {
    private ListView listView;
    public static ArrayList<Supermarket> supermarkets= new ArrayList<>();
    private ArrayAdapter<Supermarket>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca__prodotto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new ArrayAdapter<Supermarket>(Ricerca_Supermercato.this , android.R.layout.simple_list_item_1,supermarkets);
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