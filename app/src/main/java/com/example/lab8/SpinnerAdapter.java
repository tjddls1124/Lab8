package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by 최웅순 on 2017-04-27.
 */

public class SpinnerAdapter extends BaseAdapter{
    String fruit[];
    Context context;

    public SpinnerAdapter(String[] data, Context context){
        this.fruit = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruit.length;
    }

    @Override
    public Object getItem(int position) {
        return fruit[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item,null);
        final TextView tv = (TextView)convertView.findViewById(R.id.textview);
        final CheckBox cb = (CheckBox)convertView.findViewById(R.id.CheckBox);

        tv.setText(fruit[position]);

        cb.setVisibility(View.GONE);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = "선택되었습니다.";
                if(!isChecked) msg = "선택되지 않았습니다.";
            }
        });

        return convertView;
    }
}
