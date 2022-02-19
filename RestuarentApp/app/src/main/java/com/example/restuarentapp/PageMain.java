package com.example.restuarentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PageMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_main);
        String ingrediants = "https://www.vectorstock.com/royalty-free-vector/pizza-ingredients-vector-2036905";

        Button button1 = (Button) findViewById(R.id.menu);
        ImageView pizza = findViewById(R.id.pizza);
        ImageView burger = findViewById(R.id.burger);
        ImageView imageView2 = (ImageView) findViewById(R.id.pizza);
        ImageView imageView3 = (ImageView) findViewById(R.id.burger);

        button1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ingrediants));
                startActivity(i);

                return true;
            }
        });


        pizza.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(PageMain.this, "ACTION_SEND", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        burger.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(PageMain.this, "ACTION_SEND", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(PageMain.this, Pizzaview.class);

                startActivity(in);

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inb = new Intent(PageMain.this, BurgerView.class);

                startActivity(inb);

            }
        });



    }

}