package com.softexpert.carsApp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CarsResponse {
    @Expose
    @SerializedName("data")
    private ArrayList<Car> data;
    @Expose
    @SerializedName("status")
    private int status;

    public ArrayList<Car> getData() {
        return data;
    }

    public void setData(ArrayList<Car> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
