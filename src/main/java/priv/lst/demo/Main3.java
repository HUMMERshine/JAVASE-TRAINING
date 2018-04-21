package priv.lst.demo;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}

public class Main3 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		int[] preOrder = new int[count];
		int[] inOrder = new int[count];

		for (int i = 0; i < count; i++) {
			preOrder[i] = cin.nextInt();
		}

		for (int i = 0; i < count; i++) {
			inOrder[i] = cin.nextInt();
		}

		TreeNode root = build(preOrder, 0, count - 1, inOrder, 0, count - 1);
		print(root);
	}

	public static TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if (inStart > inEnd || preStart > preEnd)
			return null;

		int rootVal = pre[preStart];
		int rootIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == rootVal) {
				rootIndex = i;
				break;
			}
		}

		int len = rootIndex - inStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = build(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
		root.right = build(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);

		return root;
	}

	public static void print(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.removeFirst();
				System.out.print(temp.val);
				System.out.print(" ");
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
	}
}
/*
 * Scanner cin = new Scanner(System.in);
 * 
 * int n = cin.nextInt(); int k = cin.nextInt(); int [] array = new int[n];
 * 
 * int j = 0; while(j < n){ array[j++] = cin.nextInt(); }
 * 
 * j = 0; int [] temp = new int[n]; while(j < k){ int i = 0; for(; i < n-1;
 * i++){ temp[i] = (array[i] + array[i+1])%100; } temp[i] = (array[i] +
 * array[0])%100; int [] s = array; array = temp; temp = s; j++; }
 * 
 * j = 0; while(j < n - 1){ System.out.print(array[j++] + " "); }
 * System.out.println(array[j++]); }
 */
