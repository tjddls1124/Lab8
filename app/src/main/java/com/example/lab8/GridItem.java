package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 최웅순 on 2017-04-27.
 */

public class GridItem extends LinearLayout {
    TextView tv;
    ImageView iv;
    Button b_add;
    EditText et;
    public GridItem(Context context){
        super(context);
        init(context);
    }
    public void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.griditem,null);
        tv= (TextView)view.findViewById(R.id.tv);
        iv = (ImageView)view.findViewById(R.id.iv);
        b_add = (Button)view.findViewById(R.id.b_add);
        et = (EditText)view.findViewById(R.id.f_name);
    }
    public void setData(Fruit fruit) {
        iv.setImageResource(fruit.imgno);
        tv.setText(fruit.name);
    }




}
