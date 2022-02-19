package com.example.restuarentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class Pizza_CustomAdapter extends BaseAdapter {

    Context context;
    int[] flags;
    String[] ingredients;

    Pizza_CustomAdapter(Context context,String[] ingredients,int[] flags){

        this.context = context;
        this.ingredients = ingredients;
        this.flags = flags;
    }


    @Override
    public int getCount() {
        return ingredients.length;
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

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_pizza,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewId);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewid);

        imageView.setImageResource(flags[position]);
        textView.setText(ingredients[position]);

        return convertView;
    }
}
