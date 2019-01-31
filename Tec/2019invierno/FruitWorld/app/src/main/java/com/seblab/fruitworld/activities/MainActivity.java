package com.seblab.fruitworld.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.seblab.fruitworld.R;
import com.seblab.fruitworld.models.Fruit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GridView gridView;

    private List<Fruit> fruits;

    private final int SWITCH_TO_LIST_VIEW = 0;
    private final int SWITCH_TO_GRID_VIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.forzarIconoBar();

        fruits=this.insertarDatosLista();

        listView= findViewById(R.id.listView);
        gridView=findViewById(R.id.gridView);

    }

    private void forzarIconoBar(){
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    //CRUD
    private List<Fruit> insertarDatosLista(){
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("Manzana","Chilpancingo",R.mipmap.ic_apple));

        return list;
    }
}
