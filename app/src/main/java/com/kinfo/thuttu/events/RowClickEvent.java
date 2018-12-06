package com.kinfo.thuttu.events;

public class RowClickEvent {

    private String allRowData;

    public String getAllLatestData() {
        return allRowData;
    }


    public RowClickEvent(String data)
    {
        this.allRowData=data;
    }


}
