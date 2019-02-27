package Trees;
/*
 * HomeWork Set 3 Problem 3, Leaf Count
 * .
 * This program uses a method that is in the LinkedBinaryTree.java in my package. I will include the methods here so you can see and review them.
 * 
 * METHODS IN LinkedBinaryTree.java
 * For Instructor:
   public int countLeaves() {
		int leafTotal =leafCounter(root);
		return leafTotal;
	}
	
	private int leafCounter(BinaryTreeNode<T> current) {
		if (current == null) return 0; //non-existent node
		else if(current.getLeft() == null && current.getRight() == null) return 1; //has no children therefore its a leaf
		else return leafCounter(current.getLeft()) + leafCounter(current.getRight()); //has a child so call it with the child
	}
 * 
 * Sudo code for tree swap:
 * 	Call a private method with the root as the starting node. 
 * 	If the root is null return 0, it is not a node.
 * 	if root is not null, but its children are both NULL then return a 1 since that is the last node in the branch. it is a leaf.
 * 	else if the current node has children that aren't null return the method calling children that are not null and add them together.
 * 	
 * Main Method for Testing.
 * 	The user is asked to enter integers to fill a Binary Search Tree. The user should enter the numbers as follows: 1 2 3 4 5 -1
 * 	The program enters the integers into the tree and stops when it gets to -1.
 * 	EXAMPLE RUN.
 * 	NUMBERS ENTERED: 8 4 10 2 5 9 -1
 *  RETURNED VALUE: Total leaves= 3
 * 
 * 
 * @Author Adam Smith
 * @Version 11/9/18
 */
import java.util.*;

public class CountLeaves {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Scanner ans1 = new Scanner(System.in);
		String awnser = "y";
		int temp =0;
		System.out.println("Welcome to my program that counts leaves in a BST! Input requires positive Integers and end the sequence with a -1.");
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
			System.out.println("Total leaves= "+BST.countLeaves());
			
			System.out.println("Another run? y or n");
			awnser = ans1.nextLine();
		}
		ans1.close();
		input.close();
		System.out.println("End of program");
	}
}
