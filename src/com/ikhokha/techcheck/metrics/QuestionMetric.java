package com.ikhokha.techcheck.metrics;

public class QuestionMetric extends Metric {
    public QuestionMetric() {
        super("QUESTIONS");
    }

    @Override
    public boolean check(String comment) {
        return comment.contains("?");
    }
}

