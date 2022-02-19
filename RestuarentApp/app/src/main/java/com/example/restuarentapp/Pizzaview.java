package com.example.restuarentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Pizzaview extends AppCompatActivity {

    int[] flags = {R.drawable.pizza_pork, R.drawable.pizza_bread,R.drawable.pizza_cheese,
            R.drawable.pizza_sos,R.drawable.pizza_olive};

    String[] ingredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzaview);

        ingredient = getResources().getStringArray(R.array.ingredients);
        GridView gridview = (GridView) findViewById(R.id.grid_view);

        Pizza_CustomAdapter adapter = new Pizza_CustomAdapter(this, ingredient,flags);
        gridview.setAdapter(adapter);
    }
}