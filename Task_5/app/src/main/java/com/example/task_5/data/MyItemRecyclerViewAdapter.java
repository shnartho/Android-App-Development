package com.example.task_5.data;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.task_5.data.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.task_5.databinding.FragmentItemDataBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<ItemData> mValues;

    public MyItemRecyclerViewAdapter(List<ItemData> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemDataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mMainText.setText(mValues.get(position).mainText);
        holder.mSecondaryText.setText(mValues.get(position).secText);
        holder.mAvatar.setImageResource(android.R.drawable.btn_plus);

        if(holder.mItem.rating > 3){
            holder.mRating.setImageResource(android.R.drawable.btn_plus);
        } else {
            holder.mRating.setImageResource(android.R.drawable.btn_minus);
        }
    }

    void setData(List<ItemData> items) {

        mValues = items;
        notifyDataSetChanged();
    }




    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mMainText;
        public final TextView mSecondaryText;
        public final ImageView mAvatar;
        public final ImageView mRating;
        public ItemData mItem;

        public ViewHolder(FragmentItemDataBinding binding) {
            super(binding.getRoot());
            mMainText = binding.mainText;
            mSecondaryText = binding.secondText;
            mAvatar = binding.avatarImage;
            mRating = binding.rating;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMainText.getText() + "'";
        }
    }
}