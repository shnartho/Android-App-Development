package com.example.restuarentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class Burger_CustomAdapter extends BaseAdapter {
    Context contextb;
    int[] flagsb;
    String[] ingredientsb;

    Burger_CustomAdapter(Context contextb, String[] ingredientsb, int[] flagsb) {

        this.contextb = contextb;
        this.ingredientsb = ingredientsb;
        this.flagsb = flagsb;
    }


    @Override
    public int getCount() {
        return ingredientsb.length;
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

        if (convertView == null) {
            LayoutInflater inflaterb = (LayoutInflater) contextb.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflaterb.inflate(R.layout.sample_pizza, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewIdb);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewidb);

        imageView.setImageResource(flagsb[position]);
        textView.setText(ingredientsb[position]);

        return convertView;
    }
}


