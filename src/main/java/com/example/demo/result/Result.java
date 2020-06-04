package com.example.demo.result;

import java.io.Serializable;

public class Result implements Serializable {
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                '}';
    }
}
