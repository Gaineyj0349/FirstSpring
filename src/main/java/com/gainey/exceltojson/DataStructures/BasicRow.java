package com.gainey.exceltojson.DataStructures;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class BasicRow {


    @SerializedName("Row Data")
    Map<String, Object> entity;

    public BasicRow() {
        entity = new HashMap<>();
    }

    public Map<String, Object> getEntity() {
        return entity;
    }

}
