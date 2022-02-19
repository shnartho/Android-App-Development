package com.example.task3_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GallaryActivity extends AppCompatActivity {
    public FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GallaryActivity.this, ActionPage.class);
                startActivity(intent);
            }
        });

        ImageView cat1 = findViewById(R.id.cat1id);
        registerForContextMenu(cat1);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.image);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.image:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.person:
                        startActivity(new Intent(getApplicationContext()
                                ,ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;

            }


        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Your Option");

        getMenuInflater().inflate(R.menu.long_press_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        ImageView ca = findViewById(R.id.cat1id);
        switch(item.getItemId()) {
            case R.id.option1:
                Toast.makeText(this, "Text color has been changed", Toast.LENGTH_SHORT).show();
                tv.setTextColor(Color.RED);
                return true;
            case R.id.option2:
                Toast.makeText(this, "Text and Background has been changed", Toast.LENGTH_SHORT).show();
                tv.setTextColor(Color.CYAN);
                ca.setBackgroundColor(Color.WHITE);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //---------------------------------------------------------------


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.checkable_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        ImageView ca = findViewById(R.id.cat1id);
        switch(item.getItemId()) {
            case R.id.checkOption1:
                if (item.isChecked()) {
                    Toast.makeText(this, "Text color has been changed", Toast.LENGTH_SHORT).show();
                    tv.setTextColor(Color.BLUE);
                    item.setChecked(false);
                } else {
                    tv.setTextColor(Color.WHITE);
                    item.setChecked(true);
                }
                break;
            case R.id.checkOption2:
                if (item.isChecked()) {
                    Toast.makeText(this, "Text and Background has been changed", Toast.LENGTH_SHORT).show();
                    ca.setBackgroundColor(Color.CYAN);
                    item.setChecked(false);
                } else {
                    ca.setBackgroundColor(Color.BLUE);
                    item.setChecked(true);
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;

    }
}