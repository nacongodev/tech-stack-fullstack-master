package com.ikhokha.techcheck;

import com.ikhokha.techcheck.CommentAnalyzer;
import com.ikhokha.techcheck.metrics.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		// Create a list of metrics
		List<Metric> metrics = Arrays.asList(
				new ShortCommentMertric(),
				new MoverMetric(),
				new ShakerMetric(),
				new QuestionMetric(),
				new SpamMetric()
		);

		// Get a list of all files in the directory
		File directory = new File("docs");
		File[] files = directory.listFiles();

		// Use CompletableFuture to process the files concurrently
		assert files != null;
		List<CompletableFuture<Void>> futures = Arrays.stream(files)
				.map(file -> CompletableFuture.runAsync(new CommentAnalyzer(file.getAbsolutePath(), metrics)))
				.collect(Collectors.toList());

		// Wait for all the futures to complete
		try {
			CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get(1, TimeUnit.MINUTES);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		// Print the report
		for (Metric metric : metrics) {
			System.out.println(metric.getName() + ": " + metric.getCount());
		}
	}
}
