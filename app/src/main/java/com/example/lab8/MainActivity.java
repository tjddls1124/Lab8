package com.example.lab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    GridAdapter adapter;
    AddFruit addFruit;
    GridView gridView;

    ArrayList<Fruit> fruitArrayList;


//    ArrayList<String> fruit_grid = new ArrayList<>();
    int imageList[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.grid);
        fruitArrayList = new ArrayList<>();
        adapter = new GridAdapter(fruitArrayList , this);
        gridView.setAdapter(adapter);



        addFruit = (AddFruit)findViewById(R.id.addFruit);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imgno) {
                adapter.addFruit(new Fruit(name, imgno));
                adapter.notifyDataSetChanged();
            }
        });


    }
}
