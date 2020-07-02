package com.softexpert.carsApp.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.softexpert.carsApp.BaseActivity;
import com.softexpert.carsApp.R;
import com.softexpert.carsApp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLifecycleOwner(this);


    }
}