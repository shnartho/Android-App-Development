package com.example.restuarentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class BurgerView extends AppCompatActivity {

    int[] flagsb = {R.drawable.burger_chicken, R.drawable.burger_bread,R.drawable.burger_cheese,
            R.drawable.pizza_sos,R.drawable.burger_letus};

    String[] ingredientB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_view);

        ingredientB = getResources().getStringArray(R.array.ingredientsB);
        GridView gridviewb = (GridView) findViewById(R.id.grid_viewB);

        Burger_CustomAdapter adapterb = new Burger_CustomAdapter(this, ingredientB,flagsb);
        gridviewb.setAdapter(adapterb);
    }
}