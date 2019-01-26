package com.qaprosoft.yakubovichAlexander.sort;

import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Sort {
    private final static Logger LOGGER = LogManager.getLogger(Sort.class);

    public static void main(String[] args) {
	int[] m = new int[20];
	Random random = new Random();
	for (int i = 0; i < m.length; i++) {
	    m[i] = random.nextInt(100);
	}

	LOGGER.info("Nash pervona4al'nii MASSIV" + "\n" + Arrays.toString(m));
	recursiya(m, 0, m.length - 1);
	LOGGER.info("Nash novii MASSIV" + "\n" + Arrays.toString(m));
    }

    public static void recursiya(int[] massiv, int min, int max) {
	if (min < max) {
	    int mid = (min + max) / 2;
	    recursiya(massiv, min, mid);
	    recursiya(massiv, mid + 1, max);
	    merge(massiv, min, mid, max);
	}
    }

    public static void merge(int[] array, int min, int mid, int max) {
	int n = max - min + 1;
	int[] Temp = new int[n];
	int i = min, j = mid + 1;
	int k = 0;

	while (i <= mid || j <= max) {
	    if (i > mid) {
		Temp[k++] = array[j++];
	    } else if (j > max) {
		Temp[k++] = array[i++];
	    } else if (array[i] < array[j]) {
		Temp[k++] = array[i++];
	    } else
		Temp[k++] = array[j++];
	}
	for (j = 0; j < n; j++) {
	    array[min + j] = Temp[j];
	}
    }
}
