package com.example.task_5.data;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task_5.R;
import com.example.task_5.data.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ItemDataFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private InteractionListener listener;
    private MyItemRecyclerViewAdapter rview;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDataFragment() {
    }

    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);
        if((ctx instanceof InteractionListener)) {
            listener = (InteractionListener) ctx;
        } else {
            throw new IllegalArgumentException("Not an Interaction Listener");
        }
    }

    public void setData(List<ItemData> data) {
        rview.setData(data);

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemDataFragment newInstance(int columnCount) {
        ItemDataFragment fragment = new ItemDataFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_data_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }


            rview = new MyItemRecyclerViewAdapter(new ArrayList<>());
            recyclerView.setAdapter(rview);
        }
        return view;
    }
}