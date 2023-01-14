package com.ikhokha.techcheck;
import com.ikhokha.techcheck.metrics.Metric;

import java.io.*;
import java.util.List;

public class CommentAnalyzer implements Runnable {
	private final String fileName;
	private final List<Metric> metrics;

	public CommentAnalyzer(String fileName, List<Metric> metrics) {
		this.fileName = fileName;
		this.metrics = metrics;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				for (Metric metric : metrics) {
					if (metric.check(line)) {
						metric.increment();
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error processing file: " + fileName);
			e.printStackTrace();
		}
	}
}

