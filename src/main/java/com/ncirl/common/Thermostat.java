package com.ncirl.common;

import java.util.Random;

public class Thermostat {
    private int temp;
    private Random random = new Random();

    public Thermostat(int temp) {
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getHeaterStatusMessage() {
        if (temp < 18) {
            return "Sending request to turn on the heater";
        } else if (temp > 25) {
            return "Sending request to turn off the heater";
        } else {
            return "";
        }
    }
}