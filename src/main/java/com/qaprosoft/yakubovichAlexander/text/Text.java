package com.qaprosoft.yakubovichAlexander.text;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

public class Text {

    public String toLowerCase(String st) {
	String lowerCase = StringUtils.lowerCase(st);
	return lowerCase;
    }

    public String toReplace(String str) {
	String result = StringUtils.replace(str, "-", " ");
	return result;
    }

    public void read() throws Exception {
	String str;
	String pathI;
	File resFile = null;
	String pathO = null;

	pathI = "src/com/qaprosoft/yakubovichAlexander/main/resources/text/Text.txt";

	File file = new File(pathI);
	str = FileUtils.readFileToString(file, "UTF-8");

	String lowerCase = toLowerCase(str);

	String clearOne = RegExUtils.replaceAll(lowerCase, "[\"\\!\\?\\-\\+\\.\\^:,()]", " ");

	String clear = toReplace(clearOne);

	String[] massiv = StringUtils.split(clear);

	String[] result = new String[massiv.length];

	for (int i = 0; i < massiv.length; i++) {

	    int count = StringUtils.countMatches(clear, massiv[i]);

	    result[i] = massiv[i] + " - " + "\t" + count + "\n";
	}

	Set<String> setResult = new LinkedHashSet<String>();
	for (int i = 0; i < result.length; i++) {
	    setResult.add(result[i]);
	}

	String res = setResult.toString();

	pathO = "src/com/qaprosoft/yakubovichAlexander/main/resources/text/Result.txt";
	resFile = new File(pathO);
	FileUtils.writeLines(resFile, setResult);

	FileUtils.writeStringToFile(resFile, res, "UTF-8");
    }
}