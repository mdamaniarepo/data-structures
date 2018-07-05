package com.musings.ds.trees;

public interface Tree<T> {
	
	void insert(T t);
	
	T find(T t);
	
	boolean delete(T t);
	
	T min();
	
	T max();

}
