package main;

/**
 * Name: Sarah L. Lozier
 * Project: Project 3
 * Date: July 24th, 2024
 * Description: This class defines a checked exception that is thrown when a
 * tree with invalid syntax is input.
 */
public class TreeSyntaxException extends Exception {

	/**
	 * Constructor that creates a new TreeSyntaxException with the specified detail
	 * message.
	 * 
	 * @param message the detail message.
	 */
	public TreeSyntaxException(String message) {
		super(message);
	}
}
