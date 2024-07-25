package test;

/**
 * Name: Sarah L. Lozier
 * Project: Binary Tree Validation
 * Date: July 24th, 2024
 * Description: This class contains unit tests to validate the functionality of
 * the TreeSyntaxException class, ensuring that exceptions are correctly thrown
 * and messages are appropriately set.
 */

import main.TreeSyntaxException;

public class TreeSyntaxExceptionTest {

	/**
	 * The main method executes all test methods and reports their results.
	 *
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Execute tests and report results
		boolean result1 = testExceptionMessage();
		boolean result2 = testExceptionHandling();

		// Output the results of each test
		System.out.println("TreeSyntaxExceptionTest results:");
		System.out.println("testExceptionMessage: " + (result1 ? "Passed" : "Failed"));
		System.out.println("testExceptionHandling: " + (result2 ? "Passed" : "Failed"));
	}

	/**
	 * Tests if the TreeSyntaxException correctly sets the exception message.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testExceptionMessage() {
		System.out.println("🧪 TEST 1 🧪");
		try {
			throw new TreeSyntaxException("Test message");
		} catch (TreeSyntaxException e) {
			boolean expectedOutput = true;
			boolean actualOutput = "Test message".equals(e.getMessage());
			System.out.println("Expected output: " + expectedOutput + ", Actual output: " + actualOutput);
			return actualOutput == expectedOutput;
		}
	}

	/**
	 * Tests if the TreeSyntaxException is properly handled when thrown.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testExceptionHandling() {
		System.out.println("🧪 TEST 2 🧪");
		try {
			throw new TreeSyntaxException("Another test message");
		} catch (TreeSyntaxException e) {
			boolean expectedOutput = true;
			boolean actualOutput = "Another test message".equals(e.getMessage());
			System.out.println("Expected output: " + expectedOutput + ", Actual output: " + actualOutput);
			return actualOutput == expectedOutput;
		}
	}
}
