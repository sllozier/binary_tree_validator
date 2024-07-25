package main;

/**
 * Name: Sarah L. Lozier
 * Project: Project 3
 * Date: July 24th, 2024
 * Description: This class defines an immutable binary tree with methods to
 * construct it from a
 * preorder representation or an array list, and methods to perform various
 * operations
 * like checking if the tree is a BST, if it is balanced, outputting the tree in
 * indented form,
 * getting the height of the tree, and getting the values in the tree.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {

	private final Node root;

	// Node class representing each node in the binary tree
	private static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * Constructor that accepts a string containing the preorder representation of a
	 * binary tree and constructs a binary tree.
	 */
	public BinaryTree(String preorder) throws TreeSyntaxException {
		if (preorder == null || preorder.isEmpty()) {
			throw new TreeSyntaxException("Invalid preorder string");
		}
		int[] index = { 0 };
		this.root = constructTreeFromPreorder(preorder, index);
		validateTreeSyntax(preorder, index);
	}

	/**
	 * Constructor that accepts an array list of integers and constructs a balanced
	 * binary search tree containing those values.
	 */
	public BinaryTree(ArrayList<Integer> values) {
		if (values == null || values.isEmpty()) {
			throw new IllegalArgumentException("Values list is null or empty");
		}
		Collections.sort(values);
		this.root = constructBalancedBST(values, 0, values.size() - 1);
	}

	// Method to output the binary tree in indented form
	public void printIndentedTree() {
		printIndentedTree(root, 0);
	}

	private void printIndentedTree(Node node, int level) {
		if (node == null) {
			return;
		}
		System.out.println(" ".repeat((level + 1) * 4) + node.value);
		printIndentedTree(node.left, level + 1);
		printIndentedTree(node.right, level + 1);
	}

	// Method to check if the tree is a binary search tree
	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.value <= min || node.value >= max) {
			return false;
		}
		return isBST(node.left, min, node.value) && isBST(node.right, node.value, max);
	}

	// Method to check if the tree is balanced
	public boolean isBalanced() {
		return checkBalance(root) != -1;
	}

	private int checkBalance(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = checkBalance(node.left);
		int rightHeight = checkBalance(node.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Method to get the height of the tree
	public int getHeight() {
		return getHeight(root) - 1;
	}

	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	// Method to get an array list of the values in the tree
	public ArrayList<Integer> getValues() {
		ArrayList<Integer> values = new ArrayList<>();
		getValues(root, values);
		return values;
	}

	private void getValues(Node node, List<Integer> values) {
		if (node == null) {
			return;
		}
		getValues(node.left, values);
		values.add(node.value);
		getValues(node.right, values);
	}

	// Helper method to construct a binary tree from preorder representation
	private Node constructTreeFromPreorder(String preorder, int[] index) throws TreeSyntaxException {
		if (index[0] >= preorder.length()) {
			throw new TreeSyntaxException("Incomplete tree");
		}

		// Skip any spaces
		while (index[0] < preorder.length() && Character.isWhitespace(preorder.charAt(index[0]))) {
			index[0]++;
		}

		// Read the next character
		char ch = preorder.charAt(index[0]);

		// If it's an asterisk, it represents a null node
		if (ch == '*') {
			index[0]++;
			return null;
		}

		// If it's an opening parenthesis, read the node value
		if (ch == '(') {
			index[0]++;

			// Read the value
			StringBuilder valueStr = new StringBuilder();
			while (index[0] < preorder.length() && Character.isDigit(preorder.charAt(index[0]))) {
				valueStr.append(preorder.charAt(index[0]++));
			}

			int value;
			try {
				value = Integer.parseInt(valueStr.toString());
			} catch (NumberFormatException e) {
				throw new TreeSyntaxException("Data is not an integer: " + valueStr.toString());
			}

			Node node = new Node(value);

			// Read the left child
			node.left = constructTreeFromPreorder(preorder, index);

			// Read the right child
			node.right = constructTreeFromPreorder(preorder, index);

			// Skip the closing parenthesis
			if (index[0] < preorder.length() && preorder.charAt(index[0]) == ')') {
				index[0]++;
			} else {
				throw new TreeSyntaxException("Missing right parenthesis");
			}

			return node;
		} else {
			throw new TreeSyntaxException("Missing left parenthesis");
		}
	}

	// After constructing the tree, check for extra characters at the end
	private void validateTreeSyntax(String preorder, int[] index) throws TreeSyntaxException {
		while (index[0] < preorder.length() && Character.isWhitespace(preorder.charAt(index[0]))) {
			index[0]++;
		}
		if (index[0] < preorder.length()) {
			throw new TreeSyntaxException("Extra characters at the end");
		}
	}

	// Helper method to construct a balanced binary search tree from sorted values
	private Node constructBalancedBST(ArrayList<Integer> values, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(values.get(mid));
		node.left = constructBalancedBST(values, start, mid - 1);
		node.right = constructBalancedBST(values, mid + 1, end);
		return node;
	}
}
