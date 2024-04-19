package com.ncirl.common;

public class Storage {

    private int id;

    private String status;



    public Storage (int id, String status){
        this.id = id;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public String getStatus (){
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status){
        this.status = status;
    }




}
