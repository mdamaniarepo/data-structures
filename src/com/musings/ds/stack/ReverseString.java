package com.musings.ds.stack;

public class ReverseString {

	private String input;

	private String output;

	public ReverseString(String input) {
		this.input = input;
		this.output = "";
	}

	public String get() {
		return this.output;
	}

	public void doReverse() {
		Stack<Character> characterStack = new Stack<>(Character.class, this.input.length());

		char[] charArray = input.toCharArray();
		for (char someChar : charArray) {
			characterStack.push(someChar);
		}
		
		
		while(!characterStack.isEmpty()) {
			this.output += characterStack.pop();
		}
	}

	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString("Hello World!");
		reverseString.doReverse();
		System.out.println(reverseString.get());
	}
	

}
