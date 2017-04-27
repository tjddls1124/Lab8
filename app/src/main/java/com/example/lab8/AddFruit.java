package com.example.lab8;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by 최웅순 on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener{
    EditText et;
    ImageView img;
    Button b_add,b_next;
    static int i=0;
    public AddFruit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruitadd,this);
        et = (EditText)findViewById(R.id.f_name);
        img = (ImageView)findViewById(R.id.image1);
        b_next = (Button) findViewById(R.id.b_next);
        b_add = (Button) findViewById(R.id.b_add);
        b_add.setOnClickListener(this);
        b_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v== b_add) {
            onAddListener.onAdd(et.getText().toString(), Fruit.fruit_imgno[i]);
        if(v==b_next) {
            i++;
            img.setImageResource(Fruit.fruit_imgno[i]);
        }

        }
    }

    interface OnAddListener {
        void onAdd(String name , int imgno);
    }
    public OnAddListener onAddListener;
    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }


}
