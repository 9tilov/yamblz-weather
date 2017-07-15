package com.example.toor.yamblzweather.data.model;

public class OWResponse<T> {
    private final T body;

    public OWResponse(T body) {
        this.body = body;
    }

    public T body() {
        return body;
    }
}