package main;

/**
 * Name: Sarah L. Lozier
 * Project: Project 3
 * Date: July 24th, 2024
 * Description: This class contains the main method to accept user input, display the tree, and  
 * categorize it.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Project3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String moreTrees = "Y";

		while (moreTrees.equalsIgnoreCase("Y")) {
			try {
				System.out.print("Enter a binary tree: ");
				String input = scanner.nextLine();
				BinaryTree tree = new BinaryTree(input);
				tree.printIndentedTree();

				if (tree.isBST()) {
					if (tree.isBalanced()) {
						System.out.println("It is a balanced binary search tree");
					} else {
						System.out.println("It is a binary search tree but it is not balanced");
						ArrayList<Integer> values = tree.getValues();
						BinaryTree balancedTree = new BinaryTree(values);
						balancedTree.printIndentedTree();
						System.out.println("Original tree has height " + tree.getHeight());
						System.out.println("Balanced tree has height " + balancedTree.getHeight());
					}
				} else {
					System.out.println("It is not a binary search tree");
					ArrayList<Integer> values = tree.getValues();
					BinaryTree bstTree = new BinaryTree(values);
					bstTree.printIndentedTree();
					System.out.println("Original tree has height " + tree.getHeight());
					System.out.println("BST tree has height " + bstTree.getHeight());
				}
			} catch (TreeSyntaxException e) {
				System.out.println("Invalid tree syntax: " + e.getMessage());
			}

			System.out.print("More trees? Y or N: ");
			moreTrees = scanner.nextLine();
		}

		scanner.close();
	}
}
