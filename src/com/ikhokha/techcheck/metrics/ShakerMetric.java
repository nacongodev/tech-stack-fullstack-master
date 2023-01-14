package com.ikhokha.techcheck.metrics;

public class ShakerMetric extends Metric {
    public ShakerMetric() {
        super("SHAKER");
    }

    @Override
    public boolean check(String comment) {
        return comment.contains("Shaker");
    }
}
