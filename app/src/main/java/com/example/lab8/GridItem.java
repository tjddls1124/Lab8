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
    TextView tv,tv2;
    ImageView iv;

    public GridItem(Context context){
        super(context);
        init(context);
    }
    public void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.griditem,this);
        tv= (TextView)view.findViewById(R.id.tv);
        tv2 = (TextView)view.findViewById(R.id.tv2);
        iv = (ImageView)view.findViewById(R.id.iv);
    }
    public void setData(Fruit fruit) {
        iv.setImageResource(fruit.imgno);
        tv.setText(fruit.name);
        if(fruit.isPriceVisible == true) tv2.setVisibility(VISIBLE);
        else tv2.setVisibility(GONE);
        tv2.setText(fruit.price);
    }




}
