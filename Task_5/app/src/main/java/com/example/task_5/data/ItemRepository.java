package com.example.task_5.data;

import android.app.Application;


import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static ItemDao dao;
    private static DB db;

    public ItemRepository(Application context) {
        db = DB.getDatabase(context);
        dao = db.Dao();
    }

    public List<ItemData> getDataList() {

        return dao.getAllItems();
    }

    public void insertItem(ItemData item) {
        dao.insert(item);
    }

    public void deleteItem(ItemData item) {
        dao.delete(item);
    }
}
