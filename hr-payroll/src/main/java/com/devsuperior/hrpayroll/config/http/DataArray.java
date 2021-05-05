package com.devsuperior.hrpayroll.config.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.Collection;

public class DataArray implements Response {

    @JsonView({ViewDefault.class})
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
