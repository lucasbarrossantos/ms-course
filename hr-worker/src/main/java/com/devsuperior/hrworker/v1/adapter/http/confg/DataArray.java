package com.devsuperior.hrworker.v1.adapter.http.confg;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;

public class DataArray implements Response {

    @JsonProperty("data")
    private final Collection<?> data;

    protected DataArray(){
        this.data = new ArrayList<>();
    }

    protected DataArray(Collection<?> data) {
        this.data = data;
    }

    public static DataArray build() {
        return new DataArray();
    }

    public static DataArray build(Collection<?> value) {
        return new DataArray(value);
    }

    public Collection<?> getData() {
        return this.data;
    }
}
