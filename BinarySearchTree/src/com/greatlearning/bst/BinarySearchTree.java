package com.greatlearning.bst;

import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree {
	private static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.data) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	// Function to find a pair of nodes whose values sum up to the targetSum
	private static void findPairWithSum(TreeNode root, int targetSum) {

		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		TreeNode curr1 = root;
		TreeNode curr2 = root;
		boolean done1 = false;
		boolean done2 = false;
		int val1 = 0, val2 = 0;

		while (true) {
			// In-order traversal from the smallest value to the targetSum

			while (!done1) {
				if (curr1 != null) {
					stack1.push(curr1);
					curr1 = curr1.left;
				} else {
					if (stack1.isEmpty()) {
						done1 = true;
					} else {
						curr1 = stack1.pop();
						val1 = curr1.data;
						curr1 = curr1.right;
						done1 = true;
					}
				}
			}

			while (!done2) {
				if (curr2 != null) {
					stack2.push(curr2);
					curr2 = curr2.right;
				} else {
					if (stack2.isEmpty()) {
						done2 = true;
					} else {
						curr2 = stack2.pop();
						val2 = curr2.data;
						curr2 = curr2.left;
						done2 = true;
					}
				}
			}

			if (val1 != val2 && val1 + val2 == targetSum) {
				System.out.println("Pair is (" + val1 + ", " + val2 + ")");
				return;
			}

			if (val1 + val2 < targetSum) {
				done1 = false;
			} else if (val1 + val2 > targetSum) {
				done2 = false;
			}

			if (val1 >= val2) {
				break;
			}
		}

		System.out.println("Nodes are not found.");
	}

	public static void main(String[] args) {
		// Creating the Binary Search Tree
		int[] arr = { 40, 20, 60, 10, 30, 50, 70 };
		TreeNode root = null;
		for (int val : arr) {
			root = insert(root, val);
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the target sum: ");
		int targetSum = scanner.nextInt();

		findPairWithSum(root, targetSum);

		scanner.close();
	}
}