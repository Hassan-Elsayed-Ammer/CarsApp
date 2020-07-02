package com.softexpert.carsApp.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.softexpert.carsApp.R;
import com.softexpert.carsApp.model.Car;
import com.softexpert.carsApp.model.CarsResponse;
import com.softexpert.carsApp.model.NetworkState;
import com.softexpert.carsApp.rest.ApiClient;
import com.softexpert.carsApp.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softexpert.carsApp.utils.Constants.FAILED;
import static com.softexpert.carsApp.utils.Constants.RUNNING;
import static com.softexpert.carsApp.utils.Constants.SUCCESS;
import static com.softexpert.carsApp.utils.Functions.isNetworkAvailable;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Car>> carsListMutableLiveData;
    private MutableLiveData<NetworkState> networkStateMutableLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);

        carsListMutableLiveData = new MutableLiveData<>();
        networkStateMutableLiveData = new MutableLiveData<>();

        getCarsList(1);
    }

    public MutableLiveData<ArrayList<Car>> getCarsListMutableLiveData() {
        return carsListMutableLiveData;
    }

    public MutableLiveData<NetworkState> getNetworkStateMutableLiveData() {
        return networkStateMutableLiveData;
    }

    void getCarsList(int page) {
        if (isNetworkAvailable(getApplication())) {
            networkStateMutableLiveData.postValue(new NetworkState(RUNNING));

            ApiInterface apiInterface = ApiClient.getClient(60, 30, 30).create(ApiInterface.class);

            Call<CarsResponse> call = apiInterface.getCarsList(page);
            call.enqueue(new Callback<CarsResponse>() {
                @Override
                public void onResponse(Call<CarsResponse> call, Response<CarsResponse> response) {
                    if (response.isSuccessful()) {
                        carsListMutableLiveData.postValue(response.body().getData());

                        networkStateMutableLiveData.postValue(new NetworkState(SUCCESS));
                    } else {
                        networkStateMutableLiveData.postValue(new NetworkState(FAILED, getApplication().getString(R.string.error_getting_data)));
                    }
                }

                @Override
                public void onFailure(Call<CarsResponse> call, Throwable t) {
                    t.printStackTrace();
                    networkStateMutableLiveData.postValue(new NetworkState(FAILED, getApplication().getString(R.string.error_getting_data)));
                }
            });

        } else {
            networkStateMutableLiveData.postValue(new NetworkState(FAILED, getApplication().getString(R.string.no_net)));
        }


    }
}
