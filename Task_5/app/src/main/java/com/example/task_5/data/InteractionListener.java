package com.example.task_5.data;

import java.util.List;

public interface InteractionListener {
    void onDeleteItem(ItemData i);
    List<ItemData> getItems();
}
