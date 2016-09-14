package priv.lst.leetcode;

public class TreeNode<T> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {

		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode(T val) {

		this.val = val;

	}

	public T getKey() {
		return val;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public void setKey(T key) {
		this.val = key;
	}
}
