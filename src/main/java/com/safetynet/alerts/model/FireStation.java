package com.safetynet.alerts.model;

import javax.validation.constraints.Size;

public class FireStation {

    private String address;
    @Size(min = 1)
    private int station;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }


}


