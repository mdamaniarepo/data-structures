package com.musings.ds.lists;

import com.musings.ds.common.Node;

public class SinglyLinkedList<T> implements LinkedList<T> {

	private Node<T> head;

	private Node<T> tail;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	private boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public void addToHead(T data) {
		Node<T> newNode = new Node<>(data, this.head);
		if (isEmpty()) {
			this.tail = this.head = newNode;
		}

		this.head = newNode;
	}

	@Override
	public void addToTail(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			this.head = this.tail = newNode;
			return;
		}

		this.tail.setNext(newNode);
		tail = newNode;
	}

	@Override
	public int size() {
		int lenght = 0;

		Node<T> current = head;
		while (null != current) {
			++lenght;
			current = current.getNext();
		}
		return lenght;
	}

	@Override
	public T deleteFromHead() {
		T data = null;
		if (isEmpty()) {
			return data;
		}
		data = head.getData();
		head = head.getNext();
		return data;
	}

	@Override
	public T deleteFromTail() {
		T data = null;
		if (isEmpty()) {
			return data;
		}

		data = tail.getData();
		if (head == tail) {
			head = tail = null;
			return data;
		}

		Node<T> current = head; // 1, 2, 3, 4
		Node<T> newTail = null;
		while (null != current.getNext()) {
			newTail = current;
			current = current.getNext();
		}

		this.tail = newTail;
		tail.setNext(null);
		return data;
	}

	@Override
	public boolean delete(T t) {
		System.out.println("Deleting node with value: " + t);
		boolean success = false;
		if (!isEmpty() && head.getData() == t) {
			success = true;
			this.head = head.getNext();
			return success;
		}

		Node<T> current = head;
		Node<T> prevNode = null;
		Node<T> nextNode = current.getNext();
		while (null != current) {
			T data = current.getData();
			if (data == t) {
				prevNode.setNext(nextNode);
				success = true;
			}

			prevNode = current;
			current = current.getNext();
			if (null != current) {
				nextNode = current.getNext();
			} else {
				nextNode = null;
			}

		}

		return success;
	}
	
	@Override
	public void add(T data) {
		
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + ", tail=" + tail + "]";
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.addToHead(1);
		linkedList.addToTail(2);
		linkedList.addToTail(3);
		linkedList.addToHead(0);

		System.out.println(linkedList);
		System.out.println("Length: " + linkedList.size());

		System.out.println("Deleted: " + linkedList.deleteFromTail());
		System.out.println(linkedList);

		System.out.println("Deleted: " + linkedList.deleteFromHead());
		System.out.println("Length: " + linkedList.size());
		System.out.println(linkedList);

		System.out.println("Deleted: " + linkedList.delete(1));
		System.out.println("Length: " + linkedList.size());
		System.out.println(linkedList);

		System.out.println("Deleted: " + linkedList.delete(5));
		System.out.println("Length: " + linkedList.size());
		System.out.println(linkedList);

		System.out.println("Deleted: " + linkedList.delete(2));
		System.out.println("Length: " + linkedList.size());
		System.out.println(linkedList);
		/*
		 * System.out.println("Deleted: " + linkedList.deleteFromHead());
		 * System.out.println("Deleted: " + linkedList.deleteFromHead());
		 * System.out.println("Deleted: " + linkedList.deleteFromHead());
		 */

	}

}
