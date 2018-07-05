package com.musings.ds.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> extends BaseSort<T> {

	T[] dataArray;
	Class<T> clazz;

	public QuickSort(T[] dataArray) {
		this.dataArray = dataArray;
	}

	public T[] sort() {
		if (dataArray.length <= 1) {
			return dataArray;
		}

		quickSort(dataArray, 0, dataArray.length - 1);
		return this.dataArray;
	}

	public void quickSort(T[] t, int start, int end) {
		if (start < end) {
			int pivot = partition(t, start, end);
			quickSort(t, start, pivot - 1);
			quickSort(t, pivot + 1, end);
		}

		return;
	}

	private int partition(T[] t, int start, int end) {
		T pivot = t[end];
		int i = start;

		for (int j = start; j <= end - 1; j++) {
			if (!(t[j].compareTo(pivot) == 1)) {
				swap(t, i, j);
				i++;
			}
		}

		swap(t, i, end);
		return i;
	}

	public static void main(String[] args) {
		Integer[] integerArray = new Integer[10];
		for (int i = 0; i < integerArray.length; i++) {
			integerArray[i] = new Random().nextInt(100);
		}
		
		System.out.println("Integer array before printing sorting: " + Arrays.asList(integerArray));
		QuickSort<Integer> sort = new QuickSort<>(integerArray);
		System.out.println("Integer array before printing sorting: " + Arrays.asList(sort.sort()));
	}

}
