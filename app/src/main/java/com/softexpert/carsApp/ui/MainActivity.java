package com.softexpert.carsApp.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.softexpert.carsApp.BaseActivity;
import com.softexpert.carsApp.R;
import com.softexpert.carsApp.databinding.ActivityMainBinding;
import com.softexpert.carsApp.model.Car;
import com.softexpert.carsApp.model.NetworkState;

import java.util.ArrayList;

import static com.softexpert.carsApp.utils.Constants.FAILED;
import static com.softexpert.carsApp.utils.Constants.RUNNING;
import static com.softexpert.carsApp.utils.Constants.SUCCESS;
import static com.softexpert.carsApp.utils.Functions.showMsg;

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;
    private CarsListAdapter carsListAdapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.setLifecycleOwner(this);

        setCarsListAdapter();

        viewModel.getNetworkStateMutableLiveData().observe(this, this::onChangedNetwork);
        viewModel.getCarsListMutableLiveData().observe(this, this::onCarsListGet);
    }

    private void onCarsListGet(ArrayList<Car> cars) {
        if (cars != null) {
            carsListAdapter.updateItems(cars);
        }
    }

    private void onChangedNetwork(NetworkState networkState) {
        if (networkState != null) {
            switch (networkState.getStatus()) {
                case RUNNING:

                    break;

                case SUCCESS:

                    break;

                case FAILED:
                    showMsg(this, networkState.getPayload());
                    break;
            }
        }
    }

    private void setCarsListAdapter() {
        binding.rcvCars.setItemAnimator(new DefaultItemAnimator());

        carsListAdapter = new CarsListAdapter(new ArrayList<>());
        binding.rcvCars.setAdapter(carsListAdapter);
    }
}