package com.musings.ds.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends BaseSort<T> {

	T[] dataArray;
	Class<T> clazz;

	public MergeSort(T[] dataArray, Class<T> clazz) {
		this.dataArray = dataArray;
		this.clazz = clazz;
	}

	public T[] sort() {
		if (dataArray.length <= 1) {
			return dataArray;
		}

		performSorting(dataArray, 0, dataArray.length - 1);
		return this.dataArray;
	}

	public void performSorting(T[] t, int start, int end) {
		if (start < end) {
			int mid = Math.floorDiv((start + end), 2);
			performSorting(t, start, mid);
			performSorting(t, mid + 1, end);
			merge(t, start, mid, end);
		}

		return;
	}

	@SuppressWarnings("unchecked")
	private void merge(T[] t, int start, int mid, int end) {
		int leftArraySize = (mid - start) + 1;
		int rightArraySize = end - mid;

		T[] leftArray = (T[]) Array.newInstance(this.clazz, leftArraySize);
		for (int i = 0; i < leftArraySize; i++) {
			leftArray[i] = t[start + i];
		}

		T[] rightArray = (T[]) Array.newInstance(this.clazz, leftArraySize);
		for (int j = 0; j < rightArraySize; j++) {
			rightArray[j] = t[mid + 1 + j];
		}

		int i = 0, j = 0;
		for (int k = start; k <= end; k++) {
			if (i >= leftArraySize) { // to avoid ArrayOutOfBoundException
				t[k] = rightArray[j++];
				continue;
			}
			
			if (j >= rightArraySize) { // to avoid ArrayOutOfBoundException
				t[k] = leftArray[i++];
				continue;
			}
			
			if (leftArray[i].compareTo(rightArray[j]) == -1) {
				t[k] = leftArray[i++];
			} else {
				t[k] = rightArray[j++];
			}
		}
	}

	public static void main(String[] args) {
		MergeSort<Integer> sort = new MergeSort<>(new Integer[] { 12, 5, 4, 13, 2, 75, 50, 0, 12, 5, 4, 13, 2, 75, 50, 0 }, Integer.class);
		System.out.println(Arrays.asList(sort.sort()));
	}

}
