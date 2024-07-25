package test;

/**
 * Name: Sarah L. Lozier
 * Project: Project 3
 * Date: July 24th, 2024
 * Description: This class contains unit tests for the Project3 class,
 * which validates binary trees based on predefined criteria.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.Project3;

public class Project3Test {

	/**
	 * The main method executes all test methods and reports their results.
	 *
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Execute tests and report results
		boolean result1 = testBalancedBST();
		boolean result2 = testNotBST();
		boolean result3 = testUnbalancedBST();
		boolean result4 = testIncompleteTree();
		boolean result5 = testExtraCharactersAtEnd();

		// Output the results of each test
		System.out.println("Project3Test results:");
		System.out.println("testBalancedBST: " + (result1 ? "Passed" : "Failed"));
		System.out.println("testNotBST: " + (result2 ? "Passed" : "Failed"));
		System.out.println("testUnbalancedBST: " + (result3 ? "Passed" : "Failed"));
		System.out.println("testIncompleteTree: " + (result4 ? "Passed" : "Failed"));
		System.out.println("testExtraCharactersAtEnd: " + (result5 ? "Passed" : "Failed"));
	}

	/**
	 * Tests the case of a balanced binary search tree.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testBalancedBST() {
		System.out.println("🧪 TEST 1 🧪");
		String input = "(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))\nN\n";
		String expectedOutput = "It is a balanced binary search tree";
		String actualOutput = runTest(input);
		System.out.println("Expected output: " + expectedOutput + ", Actual output: " + actualOutput);
		return actualOutput.contains(expectedOutput);
	}

	/**
	 * Tests the case of a tree that is not a binary search tree.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testNotBST() {
		System.out.println("🧪 TEST 2 🧪");
		String input = "(13 (53 * *) (11 (59 * *) *))\nN\n";
		String expectedOutput = "It is not a binary search tree";
		String actualOutput = runTest(input);
		System.out.println("Expected output: " + expectedOutput + ", Actual output: " + actualOutput);
		return actualOutput.contains(expectedOutput);
	}

	/**
	 * Tests the case of an unbalanced binary search tree.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testUnbalancedBST() {
		System.out.println("🧪 TEST 3 🧪");
		String input = "(63 (51 (20 (13 * *) *) *) *)\nN\n";
		String expectedOutput = "It is a binary search tree but it is not balanced";
		String actualOutput = runTest(input);
		System.out.println("Expected output: " + expectedOutput + ", Actual output: " + actualOutput);
		return actualOutput.contains(expectedOutput);
	}

	/**
	 * Tests the case of an incomplete tree.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testIncompleteTree() {
		System.out.println("🧪 TEST 4 🧪");
		String input = "(53 (28 (11 * *) (41 * *)) (83 (67 * *)\nN\n";
		String expectedOutput = "Incomplete tree";
		String actualOutput = runTest(input);
		System.out.println("Expected output: " + expectedOutput + ", Actual output: " + actualOutput);
		return actualOutput.contains(expectedOutput);
	}

	/**
	 * Tests the case of extra characters at the end of the input.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testExtraCharactersAtEnd() {
		System.out.println("🧪 TEST 5 🧪");
		String input = "(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))1\nN\n";
		String expectedOutput = "Extra characters at the end";
		String actualOutput = runTest(input);
		System.out.println("Expected output: " + expectedOutput + ", Actual output: " + actualOutput);
		return actualOutput.contains(expectedOutput);
	}

	/**
	 * Runs the Project3 class with the provided input and captures the output.
	 *
	 * @param input The input to provide to the Project3 class.
	 * @return The captured output from running the Project3 class.
	 */
	private static String runTest(String input) {
		// Save the original System.in and System.out
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setIn(in);
		System.setOut(new PrintStream(out));

		try {
			Project3.main(new String[0]);
		} finally {
			// Restore the original System.in and System.out
			System.setIn(System.in);
			System.setOut(originalOut);
		}

		return out.toString().trim();
	}
}
