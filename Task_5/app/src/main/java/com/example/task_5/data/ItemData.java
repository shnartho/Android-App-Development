package com.example.task_5.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "items")

public class ItemData {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "mainText")
    public String mainText;

    @ColumnInfo(name = "SecondaryText")
    public String secText;

    @ColumnInfo(name = "rating")
    public int rating;

    @ColumnInfo(name = "age")
    public int age;
}
