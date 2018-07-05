package com.musings.ds.lists;

public interface LinkedList<T> {
	
	public void addToHead(T data);
	
	public void addToTail(T data);
	
	public int size();
	
	public T deleteFromHead();
	
	public T deleteFromTail();
	
	public boolean delete(T t);
	
	public void add(T data);

}
