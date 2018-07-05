package com.musings.ds.sorting;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> extends BaseSort<T> {

	T[] dataArray;

	public InsertionSort(T[] dataArray) {
		this.dataArray = dataArray;
	}

	public T[] sort() {
		if (dataArray.length <= 1) {
			return dataArray;
		}

		for (int i = 0; i <= dataArray.length - 1; i++) {
			int current = i;
			int j = current - 1;

			while (j >= 0 && (dataArray[j].compareTo(dataArray[current]) == 1)) {
				swap(dataArray, j, current);
				current = j;
				j = current - 1;
			}

		}

		return this.dataArray;
	}

	public static void main(String[] args) {
		InsertionSort<Integer> sort = new InsertionSort<>(new Integer[] { 12, 5, 4, 13, 2, 75, 50, 0 });
		System.out.println(Arrays.asList(sort.sort()));
	}

}
