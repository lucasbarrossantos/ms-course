package com.devsuperior.hrworker.v1.adapter.http.confg;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataObject implements Response {

    @JsonProperty("data")
    private final Object data;

    protected DataObject(){
        this.data = new DataObject();
    }

    protected DataObject(Object data) {
        this.data = data;
    }

    public static DataObject build() {
        return new DataObject();
    }

    public static DataObject build(Object value) {
        return new DataObject(value);
    }

    public Object getData() {
        return this.data;
    }
}
