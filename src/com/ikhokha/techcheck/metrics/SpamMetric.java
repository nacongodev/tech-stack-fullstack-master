package com.ikhokha.techcheck.metrics;

public class SpamMetric extends Metric {
    public SpamMetric() {
        super("SPAM");
    }

    @Override
    public boolean check(String comment) {
        //You can use regular expressions or a library like Apache Tika to detect url
        return comment.matches(".*\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    }
}
