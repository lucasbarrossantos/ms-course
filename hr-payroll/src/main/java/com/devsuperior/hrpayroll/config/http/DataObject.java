package com.devsuperior.hrpayroll.config.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class DataObject implements Response {

    @JsonView({ViewDefault.class})
    @JsonProperty("data")
    private final Object data;

    protected DataObject(){
        this.data = new DataEmpty() {};
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
