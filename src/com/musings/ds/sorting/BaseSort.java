package com.musings.ds.sorting;

public abstract class BaseSort<T extends Comparable<T>> {

	T temp = null;

	protected void swap(T[] t, int currentPosition, int swapPosition) {
		temp = t[swapPosition];
		t[swapPosition] = t[currentPosition];
		t[currentPosition] = temp;
	}
	
	public abstract T[] sort();

}
