package com.musings.ds.sorting;

import java.util.Arrays;
import java.util.Random;

public class RadixSort extends BaseSort<Integer> {

	Integer[] dataArray;

	Integer maxSize;

	Integer maxValue;

	public RadixSort(Integer[] unsortedDataArray, Integer maxValue) {
		this.dataArray = unsortedDataArray;
		this.maxSize = 10;
		this.maxValue = maxValue;
	}

	@Override
	public Integer[] sort() {
		System.out.println("Sorted Array: " + Arrays.asList(this.dataArray));

		int numberOfDigits = (int) Math.floor(Math.log10(this.maxValue) + 1);
		for (int i = 0; i < (numberOfDigits - 1); i++) {
			this.dataArray = countingSort(this.dataArray, (int) (Math.pow(10, i)));
		}

		System.out.println("Sorted Array: " + Arrays.asList(this.dataArray));
		return dataArray;
	}

	public Integer[] countingSort(Integer[] unsortedDataArray, int divisionValue) {

		if (null == unsortedDataArray || unsortedDataArray.length == 1) {
			return unsortedDataArray;
		}

		Integer[] outputArray = new Integer[unsortedDataArray.length];
		for (int i = 0; i < outputArray.length; i++) {
			outputArray[i] = 0;
		}

		// set up the count array to zero
		Integer[] countArray = new Integer[10];
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = 0;
		}

		// taking the count of numbers from data array based on index
		for (int i = 0; i < unsortedDataArray.length; i++) {
			countArray[(unsortedDataArray[i] / divisionValue) % 10] += 1;
		}

		// accumlating the results of consecutive numbers
		for (int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1];
		}

		// shifting numbers by 1 position
		for (int i = countArray.length - 1; i >= 1; i--) {
			countArray[i] = countArray[i - 1];
		}
		countArray[0] = 0;

		for (int i = 0; i < unsortedDataArray.length; i++) {
			outputArray[countArray[(unsortedDataArray[i] / divisionValue) % 10]] = unsortedDataArray[i];
			countArray[(unsortedDataArray[i] / divisionValue) % 10]++;
		}

		return outputArray;
	}

	public static void main(String[] args) {
		int maxValue = 1000;
		Integer[] integerArray = new Integer[20];
		for (int i = 0; i < integerArray.length; i++) {
			integerArray[i] = new Random().nextInt(maxValue);
		}

		RadixSort radixSort = new RadixSort(integerArray, maxValue);
		integerArray = radixSort.sort();
	}

}
