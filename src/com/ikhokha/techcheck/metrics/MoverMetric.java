package com.ikhokha.techcheck.metrics;

public class MoverMetric extends Metric {
    public MoverMetric() {
        super("MOVER");
    }

    @Override
    public boolean check(String comment) {
        return comment.contains("Mover");
    }
}