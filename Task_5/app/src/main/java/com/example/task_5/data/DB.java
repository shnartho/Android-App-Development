package com.example.task_5.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ItemData.class}, version = 1)
public abstract class DB extends RoomDatabase {
    public abstract ItemDao Dao();
    private static DB Instance;

    static synchronized DB getDatabase(final Context ctx){
        if(Instance == null) {
            Instance =
                    Room.databaseBuilder(
                      ctx.getApplicationContext(),
                      DB.class,
                     "item_db"

            )
                    .allowMainThreadQueries()
                    .build();
        }
        return Instance;
    }
}
