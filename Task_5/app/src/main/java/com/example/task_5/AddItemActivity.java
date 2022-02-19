package com.example.task_5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        findViewById(R.id.addbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("mainText", ((EditText)findViewById(R.id.editText1)).getText().toString());
                i.putExtra("secText", ((EditText)findViewById(R.id.editText2)).getText().toString());
                i.putExtra("age", Integer.parseInt(((EditText)findViewById(R.id.editNumber1)).getText().toString()));
                i.putExtra("rating", Integer.parseInt(((EditText)findViewById(R.id.editNumber1)).getText().toString()));
                setResult(Activity.RESULT_OK, i);

                finish();
            }
        });


        findViewById(R.id.cancelbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}