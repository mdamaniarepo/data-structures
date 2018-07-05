package com.musings.ds.sorting;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> extends BaseSort<T> {

	T[] dataArray;

	public SelectionSort(T[] dataArray) {
		this.dataArray = dataArray;
	}

	public T[] sort() {
		if (dataArray.length <= 1) {
			return dataArray;
		}

		int minPosition = 0;

		for (int i = 0; i <= dataArray.length - 2; i++) {
			System.out.println("Pass :" + i);
			minPosition = i;
			for (int j = i+1; j <= dataArray.length - 1; j++) {
				//System.out.println("Comparing (" + j + " , " + (j + 1) + ")");
				if (dataArray[minPosition].compareTo(dataArray[j]) == 1) {
					minPosition = j;
				}
			}
			System.out.println("Min Position: " + minPosition);
			swap(dataArray, i, minPosition);
		}

		return this.dataArray;
	}

	public static void main(String[] args) {
		SelectionSort<Integer> sort = new SelectionSort<>(new Integer[] { 12, 5, 4, 13, 2, 75, 50, 0 });
		System.out.println(Arrays.asList(sort.sort()));
	}

}
