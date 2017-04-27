package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 최웅순 on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    ArrayList<Fruit> data;
    Context context;

    public GridAdapter(ArrayList<Fruit> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = new GridItem(context);
        ( (GridItem) convertView).setData(data.get(position));

        return null;
    }
    public void addFruit(Fruit fruit){
        data.add(fruit);
        notifyDataSetChanged();
    }
}
