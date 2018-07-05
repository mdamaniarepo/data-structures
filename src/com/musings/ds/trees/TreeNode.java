package com.musings.ds.trees;

import com.musings.ds.lists.LinkedList;

public class TreeNode<T extends Comparable<T>> implements Node<T> {

	private T data;

	private TreeNode<T> leftNode;

	private TreeNode<T> rightNode;

	public TreeNode(T data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	@Override
	public void insert(T t) {
		if (getData().compareTo(t) == 0) {
			System.out.println("Data exists in a tree: " + t);
			return;
		}

		if (getData().compareTo(t) == 1) {
			if (null == getLeftNode()) {
				setLeftNode(new TreeNode<T>(t));
			} else {
				getLeftNode().insert(t);
			}
		} else {
			if (null == getRightNode()) {
				setRightNode(new TreeNode<T>(t));
			} else {
				getRightNode().insert(t);
			}
		}
	}

	@Override
	public boolean delete(T t) {
		boolean isLeftNode = false;

		if (t.compareTo(this.getData()) == -1) {
			if (null == getLeftNode()) {
				return false;
			}

			if (getLeftNode().getData().compareTo(t) == 0) {
				isLeftNode = true;
			}
		} else {
			if (null == getRightNode()) {
				return false;
			}

			if (getRightNode().getData().compareTo(t) == 0) {
				isLeftNode = false;
			}
		}

		if (isLeftNode) {
			this.setLeftNode(null);
		} else {
			this.setRightNode(null);
		}

		return false;
	}

	@Override
	public boolean isLeaf() {
		if (null == getLeftNode() && null == getRightNode()) {
			return true;
		}
		return false;
	}

	public T find(T t) {
		if (0 == getData().compareTo(t)) {
			return this.data;
		}

		if (t.compareTo(this.getData()) == -1 && null != this.getLeftNode()) {
			return getLeftNode().find(t);
		}

		if (t.compareTo(this.getData()) == 1 && null != this.getRightNode()) {
			return getRightNode().find(t);
		}

		return null;
	}

	@Override
	public T min() {
		if (null != getLeftNode()) {
			return getLeftNode().min();
		}

		return getData();
	}

	@Override
	public T max() {
		if (null != getRightNode()) {
			return getRightNode().max();
		}

		return getData();
	}

	public void inOrderTraversal(LinkedList<T> listData) {
		if (null != getLeftNode()) {
			getLeftNode().inOrderTraversal(listData);
		}

		listData.addToTail(getData());

		if (null != getRightNode()) {
			getRightNode().inOrderTraversal(listData);
		}
	}

	public void preOrderTraversal(LinkedList<T> listData) {
		listData.addToTail(getData());

		if (null != getLeftNode()) {
			getLeftNode().inOrderTraversal(listData);
		}

		if (null != getRightNode()) {
			getRightNode().inOrderTraversal(listData);
		}
	}

	public void postOrderTraversal(LinkedList<T> listData) {
		if (null != getLeftNode()) {
			getLeftNode().inOrderTraversal(listData);
		}

		if (null != getRightNode()) {
			getRightNode().inOrderTraversal(listData);
		}

		listData.addToTail(getData());
	}

	public T getData() {
		return data;
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public boolean cotainsBothNodes() {
		return (null != getRightNode() && null != getLeftNode());
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + ", toString()="
				+ super.toString() + "]";
	}

}
