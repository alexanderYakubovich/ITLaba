package com.qaprosoft.yakubovichAlexander.completableFuture;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TextCompletableFuture {

    private final static Logger LOGGER = LogManager.getLogger(TextCompletableFuture.class);

    File resFile = null;

    public List<String> read(File file) throws Exception {
	String str;
	str = FileUtils.readFileToString(file, "UTF-8");
	String[] lines = StringUtils.split(str, "\n");
	ArrayList<String> stringLines = new ArrayList<>(Arrays.asList(lines));
	return stringLines;
    }

    public List<File> write(List<String> stringLines) throws InterruptedException, ExecutionException {
	List<File> textFiles = new ArrayList<>();
	ExecutorService executor = Executors.newFixedThreadPool(stringLines.size());

	CompletableFuture<List<File>> future1 = CompletableFuture.supplyAsync(new Supplier<List<File>>() {

	    @Override
	    public List<File> get() {
		LOGGER.info(Thread.currentThread().getName() + " work");
		resFile = new File(
			"src/com/qaprosoft/yakubovichAlexander/main/resources/completableFuture/Text0" + ".txt");
		try {
		    FileUtils.writeStringToFile(resFile, stringLines.get(0), "UTF-8");
		} catch (IOException e) {
		    LOGGER.error(e);
		}
		textFiles.add(resFile);

		return textFiles;
	    }
	}, executor);

	CompletableFuture<List<File>> future2 = CompletableFuture.supplyAsync(new Supplier<List<File>>() {

	    @Override
	    public List<File> get() {
		LOGGER.info(Thread.currentThread().getName() + " work");
		resFile = new File(
			"src/com/qaprosoft/yakubovichAlexander/main/resources/completableFuture/Text1" + ".txt");
		try {
		    FileUtils.writeStringToFile(resFile, stringLines.get(1), "UTF-8");
		} catch (IOException e) {
		    LOGGER.error(e);
		}
		textFiles.add(resFile);

		return textFiles;
	    }
	}, executor);

	CompletableFuture<List<File>> future3 = CompletableFuture.supplyAsync(new Supplier<List<File>>() {

	    @Override
	    public List<File> get() {
		LOGGER.info(Thread.currentThread().getName() + " work");
//				for (int i = 0; i < stringLines.size(); i++) {
		resFile = new File(
			"src/com/qaprosoft/yakubovichAlexander/main/resources/completableFuture/Text2" + ".txt");
		try {
		    FileUtils.writeStringToFile(resFile, stringLines.get(2), "UTF-8");
		} catch (IOException e) {
		    LOGGER.error(e);
		}
		textFiles.add(resFile);
//				}
		return textFiles;
	    }
	}, executor);

	List<File> result1 = future1.get();
	List<File> result2 = future2.get();
	List<File> result3 = future3.get();

	List<File> result = new ArrayList<>();
	result.addAll(result1);
	result.addAll(result2);
	result.addAll(result3);

	executor.shutdown();
	return result;
    }
}