package com.qaprosoft.yakubovichAlexander.completableFuture;

import java.io.File;
import java.util.List;

public class FutureRunner {
	public static void main(String[] args) throws Exception {

		TextCompletableFuture textCompletableFuture = new TextCompletableFuture();
		File file = new File("src/com/qaprosoft/yakubovichAlexander/main/resources/completableFuture/TextReader.txt");
		List<String> stringLines = textCompletableFuture.read(file);
		textCompletableFuture.write(stringLines);
	}
}