package com.musings.ds.trees;

import com.musings.ds.lists.LinkedList;
import com.musings.ds.lists.SinglyLinkedList;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

	TreeNode<T> root;

	@Override
	public void insert(T t) {
		if (null == t) {
			return;
		}

		if (null == root) {
			this.root = new TreeNode<T>(t);
			return;
		}

		this.root.insert(t);
	}

	@Override
	public T find(T t) {
		if (null == root) {
			return null;
		}
		return root.find(t);
	}

	@Override
	public T min() {
		if (null == root) {
			return null;
		}

		if (null != root.getLeftNode()) {
			return root.getLeftNode().min();
		}

		return root.getData();
	}

	@Override
	public T max() {
		if (null == root) {
			return null;
		}

		if (null != root.getRightNode()) {
			return root.getRightNode().max();
		}

		return root.getData();
	}

	@Override
	public boolean delete(T t) {
		if (null == root) {
			return false;
		}

		boolean isLeftChild = false;
		TreeNode<T> current = this.root;
		TreeNode<T> parent = this.root;

		while (null != current && current.getData().compareTo(t) != 0) {
			parent = current;
			if (current.getData().compareTo(t) == -1) {
				isLeftChild = true;
				current = current.getLeftNode();
			} else {
				current = current.getRightNode();
			}
		}

		if (null == current) {
			return false;
		}

		if (current.isLeaf()) {
			if (current == root) {
				root = null;
			} else {
				if (isLeftChild) {
					parent.setLeftNode(null);
				} else {
					parent.setRightNode(null);
				}
			}
			return true;
		}

		if (!current.cotainsBothNodes()) {
			if (null == current.getRightNode()) {
				if (current == root) {
					root = null;
				} else if (isLeftChild) {
					parent.setLeftNode(current.getLeftNode());
				} else {
					parent.setRightNode(current.getLeftNode());
				}
			} else {
				if (current == root) {
					root = null;
				} else if (isLeftChild) {
					parent.setLeftNode(current.getRightNode());
				} else {
					parent.setRightNode(current.getRightNode());
				}
			}
		}

		if (current.cotainsBothNodes()) {
			TreeNode<T> successor = findSuccessor(current);
			if (isLeftChild) {
				parent.setLeftNode(successor);
			} else {
				parent.setRightNode(successor);
			}
			successor.setLeftNode(current.getLeftNode());
			successor.setRightNode(current.getRightNode());
		}

		return true;
	}

	private TreeNode<T> findSuccessor(TreeNode<T> current) {
		TreeNode<T> successor = current.getRightNode();
		TreeNode<T> parentOfSuccessor = current;

		while (null != successor && null != successor.getLeftNode()) {
			parentOfSuccessor = successor;
			successor = successor.getLeftNode();
		}

		parentOfSuccessor.setLeftNode(successor.getRightNode());
		return successor;
	}

	public LinkedList<T> inOrderTraversal(LinkedList<T> listData) {
		if (null == this.root) {
			return listData;
		}

		if (null != root.getLeftNode()) {
			root.getLeftNode().inOrderTraversal(listData);
		}

		listData.addToTail(root.getData());

		if (null != root.getRightNode()) {
			root.getRightNode().inOrderTraversal(listData);
		}

		return listData;
	}

	public LinkedList<T> preOrderTraversal(LinkedList<T> listData) {
		if (null == this.root) {
			return listData;
		}

		listData.addToTail(root.getData());

		if (null != root.getLeftNode()) {
			root.getLeftNode().preOrderTraversal(listData);
		}

		if (null != root.getRightNode()) {
			root.getRightNode().preOrderTraversal(listData);
		}

		return listData;
	}

	public LinkedList<T> postOrderTraversal(LinkedList<T> listData) {
		if (null == this.root) {
			return listData;
		}

		if (null != root.getLeftNode()) {
			root.getLeftNode().postOrderTraversal(listData);
		}

		if (null != root.getRightNode()) {
			root.getRightNode().postOrderTraversal(listData);
		}

		listData.addToTail(root.getData());

		return listData;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		binaryTree.insert(50);
		binaryTree.insert(40);
		binaryTree.insert(60);
		binaryTree.insert(35);
		binaryTree.insert(45);
		binaryTree.insert(65);
		binaryTree.insert(55);

		// binaryTree.delete(60);
		System.out.println(binaryTree);
		System.out.println(binaryTree.min());
		System.out.println(binaryTree.max());
		LinkedList<Integer> linkedList = binaryTree.inOrderTraversal(new SinglyLinkedList<Integer>());
		System.out.println("Tree Data (In Order) : " + linkedList);
		
		LinkedList<Integer> linkedList1 = binaryTree.preOrderTraversal(new SinglyLinkedList<Integer>());
		System.out.println("Tree Data (Pre Order) : " + linkedList1);
		
		LinkedList<Integer> linkedList2 = binaryTree.postOrderTraversal(new SinglyLinkedList<Integer>());
		System.out.println("Tree Data (Post Order) : " + linkedList2);
	}

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}

}
