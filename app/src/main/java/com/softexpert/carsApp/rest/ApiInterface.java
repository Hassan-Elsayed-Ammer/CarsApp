package com.softexpert.carsApp.rest;

import com.softexpert.carsApp.model.CarsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("cars")
    Call<CarsResponse> getCarsList(@Query("page") int page);
}
