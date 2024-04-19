package com.ncirl.common;

public class Robot {
    private String name;
    private String status;
    private int batteryLevel;

    public Robot(String name, String status, int batteryLevel) {
        this.name = name;
        this.status = status;
        this.batteryLevel = batteryLevel;
    }



    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
// FAZER GETTERS AND SETTERS PARA TODOS
