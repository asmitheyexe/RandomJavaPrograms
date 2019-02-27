package Trees;
/*
 *  HOMEWORK SET 4 PROBLEM 5, SWAP TREES
 *  
 * This program uses a method that is in the LinkedBinaryTree.java in my package. I will include the methods here so you can see and review them.
 * 
 * METHODS IN LinkedBinaryTree.java
 * 	For Instructor:
	public void swapTree() {
		swapTrees(root);
		System.out.println("Done Swapping");
	}
	private void swapTrees(BinaryTreeNode<T> current) {
		if (current == null);
		else{ 
			BinaryTreeNode<T> temp;
			swapTrees(current.getLeft());
			temp = current.getLeft();
			swapTrees(current.getRight());
			current.setLeft(current.getRight());
			current.setRight(temp);
		}
 * 
 *  Sudo Code:
 *  	Pass the root into the private method to protect data.
 *  	In private method check if the current node (first run will be root) is null, don't do anything if it is.
 *  	Else call the swaptree method with what ever the right child is. store the left child in a temporary BSTNode (or right it doesn't matter which), call the swap
 *      method with the right branch once you traverse down to the bottom you want to swap the tree pointers and slowly make your way back up the tree back to the root 
 *      since the recursion is on a stack.
 * 	
 * Main Method for Testing.
 * 	The user is asked to enter integers to fill a Binary Search Tree. The user should enter the integers as follows (example): 1 2 3 4 5 -1
 * 	The program enters the integers into the tree and stops when it gets to -1.
 * 	EXAMPLE RUN.
 * 	NUMBERS ENTERED: 8 4 10 2 5 9 -1
 *  EXPECTED RETURN:
 *  	Before Swaps:
 *		Inorder:
 *		2 4 5 8 9 10 
 *		Swapping..
 *		Done Swapping
 *		After Swap:
 *		Inorder:
 *		10 9 8 5 4 2 
 *		Another run? y/n
 * 
 * 
 * @Author Adam Smith
 * @Version 11/9/18
 */
import java.util.*;

public class TreeSwapSides {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Scanner ans1 = new Scanner(System.in);
		String awnser = "y";
		int temp =0;
		System.out.println("Welcome to my program that swaps branches in a BST! Input requires positive Integers and end the sequence with a -1.");
		System.out.println("Example input: 1 2 3 -1");
		while(awnser.equals("y")) {
			System.out.print("Please enter some integers and -1 at the end to indicate you are finished: ");
			LinkedBinarySearchTree<Integer> BST = new LinkedBinarySearchTree<>();
			temp = 0;
			while(temp != -1) {
				temp = input.nextInt();
				if (temp != -1) {
					BST.addElement(temp);
				}
			}
			
			System.out.println("Before Swaps:");
			System.out.println("Inorder:");
			BST.displayInOrder();
			System.out.println("Swapping..");
			BST.swapTree();
			System.out.println("After Swap:");
			System.out.println("Inorder:");
			BST.displayInOrder();
			System.out.println("Another run? y/n");
			awnser = ans1.nextLine();
		}
		ans1.close();
		input.close();
		System.out.println("End of program");
	}
}
