package com.ikhokha.techcheck.metrics;

import java.util.List;

public class Metric {
    private String name;
    private int count;

    public Metric(String name) {
        this.name = name;
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public boolean check(String comment) {
        //This method should be overridden by subclasses
        return false;
    }
}