package com.musings.ds.stack;

import java.lang.reflect.Array;

public class Stack<T extends Object> {

	private T[] data;

	private int maxSize;

	private int top;

	@SuppressWarnings("unchecked")
	public Stack(Class<T> clazz, int maxSize) {
		this.maxSize = maxSize;
		this.data = (T[]) Array.newInstance(clazz, maxSize);
		this.top = -1;
	}

	public void push(T data) {
		this.data[++top] = data;
	}

	public T pop() {
		return this.data[top--];
	}
	
	public T peek() {
		return this.data[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == (maxSize - 1);
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> integerStack = new Stack<>(Integer.class, 10);
		integerStack.push(10);
		integerStack.push(20);
		integerStack.push(30);
		integerStack.push(40);
		integerStack.push(50);
		
		System.out.println("Peek: " + integerStack.peek());
		System.out.println("Pop: " + integerStack.pop());
		System.out.println("Peek: " + integerStack.peek());
		System.out.println("Pop: " + integerStack.pop());
		System.out.println("Peek: " + integerStack.peek());
		System.out.println("Pop: " + integerStack.pop());
		System.out.println("Peek: " + integerStack.peek());
		System.out.println("Pop: " + integerStack.pop());
		System.out.println("Peek: " + integerStack.peek());
		System.out.println("Pop: " + integerStack.pop());
	}

}
