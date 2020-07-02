package com.softexpert.carsApp.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.softexpert.carsApp.R;
import com.softexpert.carsApp.databinding.ItemCarBinding;
import com.softexpert.carsApp.model.Car;

import java.util.ArrayList;

public class CarsListAdapter extends RecyclerView.Adapter<CarsListAdapter.CarsListViewHolder> {

    private ArrayList<Car> carsItems;

    CarsListAdapter(ArrayList<Car> carsItems) {
        this.carsItems = carsItems;
    }

    @NonNull
    @Override
    public CarsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCarBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_car, parent, false);
        return new CarsListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsListViewHolder holder, int position) {
        final Car itemCar = carsItems.get(position);
        holder.binding.setCar(itemCar);
    }

    @Override
    public int getItemCount() {
        if (carsItems == null || carsItems.size() == 0)
            return 0;
        else
            return carsItems.size();
    }

    static class CarsListViewHolder extends RecyclerView.ViewHolder {
        ItemCarBinding binding;

        public CarsListViewHolder(@NonNull ItemCarBinding itemView) {
            super(itemView.getRoot());

            binding = itemView;
        }
    }
}
