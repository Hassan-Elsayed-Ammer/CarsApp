package com.softexpert.carsApp.model;

public class NetworkState {
    private String status, payload;

    public NetworkState(String status, String payload) {
        this.status = status;
        this.payload = payload;
    }

    public NetworkState(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getPayload() {
        return payload;
    }
}
