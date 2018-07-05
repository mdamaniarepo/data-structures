package com.musings.ds.sorting;

import java.util.Arrays;

/***
 * The key in using this algorithm is when you have th information about data
 * Example: Your data range can be from 1 to 100 only or maybe from A to Z only
 * 
 * 
 * @author maydaman
 *
 * @param <T>
 */
public class CountingSort extends BaseSort<Integer> {

	Integer[] dataArray;

	Integer maxValue;

	public CountingSort(Integer[] dataArray, Integer maxValue) {
		this.dataArray = dataArray;
		this.maxValue = maxValue;
	}
	
	
	@Override
	public Integer[] sort() {
		System.out.println("Original Array : " + Arrays.asList(this.dataArray));
		if (null == this.dataArray || this.dataArray.length == 1) {
			return this.dataArray;
		}

		Integer[] outputArray = new Integer[dataArray.length];
		for (int i = 0; i < outputArray.length; i++) {
			outputArray[i] = 0;
		}

		// set up the count array to zero
		Integer[] countArray = new Integer[this.maxValue + 1];
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = 0;
		}

		// taking the count of numbers from data array based on index
		for (int i = 0; i < dataArray.length; i++) {
			countArray[dataArray[i]] += 1;
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

		for (int i = 0; i < dataArray.length; i++) {
			outputArray[countArray[dataArray[i]]] = dataArray[i];
			countArray[dataArray[i]]++;
		}

		System.out.println("Sorted Array: " + Arrays.asList(outputArray));
		return this.dataArray; 
	}

	public static void main(String[] args) {
		CountingSort countingSort = new CountingSort(new Integer[] { 9, 7, 2, 3, 9, 7, 4, 4 }, 9);
		countingSort.sort();
	}

}
