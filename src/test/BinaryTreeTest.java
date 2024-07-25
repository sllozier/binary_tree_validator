package test;

/**
 * Name: Sarah L. Lozier
 * Project: Project 3
 * Date: July 24th, 2024
 * Description: This class contains unit tests to validate the functionality of
 * the BinaryTree class, ensuring that tree construction, syntax validation,
 * balance checking, and BST properties are correctly implemented.
 */

import main.BinaryTree;
import main.TreeSyntaxException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BinaryTreeTest {

	/**
	 * The main method executes all test methods and reports their results.
	 *
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Execute tests and report results
		boolean result1 = testTreeConstruction();
		boolean result2 = testInvalidTree();
		boolean result3 = testExtraCharactersAtEnd();
		boolean result4 = testIsBST();
		boolean result5 = testIsBalanced();
		boolean result6 = testHeight();
		boolean result7 = testBalancedTreeConstruction();

		// Output the results of each test
		System.out.println("BinaryTreeTest results:");
		System.out.println("testTreeConstruction: " + (result1 ? "Passed" : "Failed"));
		System.out.println("testInvalidTree: " + (result2 ? "Passed" : "Failed"));
		System.out.println("testExtraCharactersAtEnd: " + (result3 ? "Passed" : "Failed"));
		System.out.println("testIsBST: " + (result4 ? "Passed" : "Failed"));
		System.out.println("testIsBalanced: " + (result5 ? "Passed" : "Failed"));
		System.out.println("testHeight: " + (result6 ? "Passed" : "Failed"));
		System.out.println("testBalancedTreeConstruction: " + (result7 ? "Passed" : "Failed"));
	}

	/**
	 * Tests the construction of a binary tree from a valid preorder string
	 * representation.
	 * 
	 * @return true if the tree is constructed and printed correctly, false
	 *         otherwise
	 */
	public static boolean testTreeConstruction() {
		System.out.println("🧪 TEST 1 🧪");
		try {
			BinaryTree tree = new BinaryTree("(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))");

			String actualOutput = captureTreeOutput(tree);

			String expectedOutput = String.join("\n",
					"53",
					"        28",
					"            11",
					"            41",
					"        83",
					"            67");
			System.out.println("Expected output: " + expectedOutput);
			System.out.println("Actual output: " + actualOutput);

			return actualOutput.equals(expectedOutput);
		} catch (TreeSyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tests the construction of a binary tree from an invalid preorder string
	 * representation to check if an exception is thrown for invalid syntax.
	 * 
	 * @return true if the exception is thrown, false otherwise
	 */
	public static boolean testInvalidTree() {
		System.out.println("🧪 TEST 2 🧪");
		try {
			BinaryTree tree = new BinaryTree("(53 (28 (11 * *) (41 * *)) (83 (67 * *) *)");
			return false; // Should throw exception and not reach this line
		} catch (TreeSyntaxException e) {
			String expectedOutput = "Missing right parenthesis";
			String actualOutput = e.getMessage();
			System.out.println("Expected output: " + expectedOutput);
			System.out.println("Actual output: " + actualOutput);
			return expectedOutput.equals(actualOutput); // Exception expected
		}
	}

	/**
	 * Tests if extra characters at the end of the preorder string representation
	 * are detected and throw the appropriate exception.
	 * 
	 * @return true if the exception is thrown, false otherwise
	 */
	public static boolean testExtraCharactersAtEnd() {
		System.out.println("🧪 TEST 3 🧪");
		try {
			BinaryTree tree = new BinaryTree("(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))1");
			return false; // Should throw exception and not reach this line
		} catch (TreeSyntaxException e) {
			String expectedOutput = "Extra characters at the end";
			String actualOutput = e.getMessage();
			System.out.println("Expected output: " + expectedOutput);
			System.out.println("Actual output: " + actualOutput);
			return expectedOutput.equals(actualOutput); // Exception expected
		}
	}

	/**
	 * Tests if the constructed binary tree is a binary search tree.
	 * 
	 * @return true if the tree is a BST, false otherwise
	 */
	public static boolean testIsBST() {
		System.out.println("🧪 TEST 4 🧪");
		try {
			BinaryTree tree = new BinaryTree("(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))");
			boolean expectedOutput = true;
			boolean actualOutput = tree.isBST();
			System.out.println("Expected output: " + expectedOutput);
			System.out.println("Actual output: " + actualOutput);
			return expectedOutput == actualOutput;
		} catch (TreeSyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tests if the constructed binary tree is balanced.
	 * 
	 * @return true if the tree is balanced, false otherwise
	 */
	public static boolean testIsBalanced() {
		System.out.println("🧪 TEST 5 🧪");
		try {
			BinaryTree tree = new BinaryTree("(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))");
			boolean expectedOutput = true;
			boolean actualOutput = tree.isBalanced();
			System.out.println("Expected output: " + expectedOutput);
			System.out.println("Actual output: " + actualOutput);
			return expectedOutput == actualOutput;
		} catch (TreeSyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tests if the height of the constructed binary tree is correctly calculated.
	 * 
	 * @return true if the height is correct, false otherwise
	 */
	public static boolean testHeight() {
		System.out.println("🧪 TEST 6 🧪");
		try {
			BinaryTree tree = new BinaryTree("(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))");
			int expectedOutput = 2;
			int actualOutput = tree.getHeight();
			System.out.println("Expected output: " + expectedOutput);
			System.out.println("Actual output: " + actualOutput);
			return expectedOutput == actualOutput;
		} catch (TreeSyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tests the construction of a balanced binary search tree from an array list of
	 * integers.
	 * 
	 * @return true if the tree is constructed and balanced correctly, false
	 *         otherwise
	 */
	public static boolean testBalancedTreeConstruction() {
		System.out.println("🧪 TEST 7 🧪");
		try {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(53);
			values.add(28);
			values.add(11);
			values.add(41);
			values.add(83);
			values.add(67);
			BinaryTree tree = new BinaryTree(values);
			tree.printIndentedTree();
			boolean expectedOutput = true;
			boolean actualOutput = tree.isBalanced();
			System.out.println("Expected output: " + expectedOutput);
			System.out.println("Actual output: " + actualOutput);
			return expectedOutput == actualOutput;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Captures the output of printing the tree in indented form.
	 * 
	 * @param tree The BinaryTree instance to capture the output from.
	 * @return The captured output as a string.
	 */
	private static String captureTreeOutput(BinaryTree tree) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));

		tree.printIndentedTree();

		System.setOut(originalOut);
		return outputStream.toString().trim();
	}

}
