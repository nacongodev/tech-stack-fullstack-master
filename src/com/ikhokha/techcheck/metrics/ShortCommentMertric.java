package com.ikhokha.techcheck.metrics;

public class ShortCommentMertric extends Metric {
    public ShortCommentMertric() {
        super("SHORT_COMMENTS");
    }

    @Override
    public boolean check(String comment) {
        return comment.length() < 15;
    }
}
