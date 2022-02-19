package com.example.task_5.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("select * from items order by id asc")
    List<ItemData> getAllItems();

    @Query("select * from items order by rating desc")
    List<ItemData> getAllItemsSortedByRating();

    @Query("delete from items")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ItemData item);

    @Delete
    void delete(ItemData item);

}
