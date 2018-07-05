package com.musings.ds.lists;

public interface List<T> {

	public void insert(T t);
	
	public boolean delete(T t);
	
	public int size();
	
	public void print();
	
}
