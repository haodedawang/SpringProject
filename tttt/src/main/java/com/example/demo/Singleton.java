package com.example.demo;

public enum Singleton {
    INSTANCE;
    private Integer code;
    private String msg;


    Singleton() {
    }

    public int max(int a, int b) {
        return a >= b ? a : b;
    }
}
