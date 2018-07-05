package com.musings.ds.sorting;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> extends BaseSort<T> {

	T[] dataArray;

	public BubbleSort(T[] dataArray) {
		this.dataArray = dataArray;
	}

	public T[] sort() {
		if (dataArray.length <= 1) {
			return dataArray;
		}

		for (int i = 0; i <= dataArray.length - 2; i++) {
			for (int j = 0; j <= (dataArray.length - i) - 2; j++) {
				System.out.println("[" + i + "," +j + "]");
				if (dataArray[j].compareTo(dataArray[j + 1]) == 1) {
					swap(dataArray, j, j + 1);
				}
			}
		}
		
		return this.dataArray;
	}

	public static void main(String[] args) {
		BubbleSort<Integer> sort = new BubbleSort<>(new Integer[] { 5, 4, 3, 2, 1 });
		System.out.println(Arrays.asList(sort.sort()));
	}
}
