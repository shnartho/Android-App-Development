package com.example.task_5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.task_5.data.InteractionListener;
import com.example.task_5.data.ItemData;
import com.example.task_5.data.ItemDataFragment;
import com.example.task_5.data.ItemRepository;
import com.example.task_5.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements InteractionListener {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ItemRepository repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repo = new ItemRepository(this.getApplication());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        ItemDataFragment f = (ItemDataFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_content_main);
        f.setData(repo.getDataList());



        ActivityResultLauncher<Intent> rl = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {

                            Intent data = result.getData();

                            ItemData d = new ItemData();
                            d.mainText = data.getStringExtra("mainText");
                            d.secText = data.getStringExtra("secText");
                            d.age = data.getIntExtra("age", -1);
                            d.rating = data.getIntExtra("rating", -1);
                            repo.insertItem(d);
                            f.setData(repo.getDataList());

                        }
                    }
                }
        );

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddItemActivity.class);
                rl.launch(i);

            }
        });



    }


    @Override
    public void onDeleteItem(ItemData i) {
          repo.deleteItem(i);
    }

    @Override
    public List<ItemData> getItems() {
        return repo.getDataList();
    }
}