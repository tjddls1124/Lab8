package com.example.lab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    GridAdapter adapter;
    AddFruit addFruit;
    GridView gridView;
    CheckBox checkBox;
    Button button, bt_add;
    ImageView iv;

    EditText et_price;
    AutoCompleteTextView at_name;

    ArrayList<Fruit> fruitArrayList;

    int last_position=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.grid);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        button = (Button) findViewById(R.id.button);
        et_price = (EditText) findViewById(R.id.f_price);
        at_name = (AutoCompleteTextView) findViewById(R.id.f_name);
        bt_add = (Button) findViewById(R.id.b_add);
        iv = (ImageView)findViewById(R.id.image1);

        fruitArrayList = new ArrayList<>();
        final ArrayList<Fruit> cartArray = new ArrayList<>();
        adapter = new GridAdapter(fruitArrayList, this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                GridView gridView = (GridView) parent;
                et_price.setText(fruitArrayList.get(position).price);
                at_name.setText(fruitArrayList.get(position).name);
                bt_add.setText("M");

                Toast.makeText(getApplicationContext(), Fruit.fruit[fruitArrayList.get(position).index] + "가 카트에 담겼습니다.", Toast.LENGTH_SHORT).show();
                cartArray.add(fruitArrayList.get(position));
                last_position = position;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                for (int i = 0; i < cartArray.size(); i++) {
                    if (i == cartArray.size() - 1)
                        s += cartArray.get(i).name;

                    else {
                        s += cartArray.get(i).name;
                        s += ", ";
                    }

                }
                Toast.makeText(getApplicationContext(), s + "가 카트에 담겨있습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()) for (int i = 0; i < fruitArrayList.size(); i++)
                    fruitArrayList.get(i).isPriceVisible = true;
                else for (int i = 0; i < fruitArrayList.size(); i++)
                    fruitArrayList.get(i).isPriceVisible = false;

                adapter.notifyDataSetChanged();
            }
        });


        addFruit = (AddFruit) findViewById(R.id.addFruit);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imgno, String price , boolean is_modify) {
                if ( is_modify == false ) {
                    adapter.addFruit(new Fruit(name, imgno, price));
                    adapter.notifyDataSetChanged();
                }
                else {
                    fruitArrayList.get(last_position).name = name;
                    fruitArrayList.get(last_position).price = price;
                    fruitArrayList.get(last_position).imgno = Fruit.fruit_imgno[imgno];
                    adapter.notifyDataSetChanged();
                    bt_add.setText("ADD");
                }






            }


        });
    }
}
