/*
 * This program is designed to fill a NxM array of elements corresponding with :
 * 	A[0][0] to a[0][m-1] = 1
 *	A[n-1][0] to a[n-1][m-1] = 1
 *	A[0][0] to a[n-1][0] = 1
 *	A[0][m-1] to a[n-1][m-1] = 1
 * and so on. There are a couple methods used in this algorithm after the main asks for user input on how many rows and columns they want.
 * 
 * Methods:
 * 	Box
 * 		Used to initialize an array of NxM elements, initialized a counter and then checks to see if either rows or columns are 0, else call the recusive method.
 * 	recursiveCall
 * 		Uses the counter variable to keep track of how many calls are made, depends on which is smaller, when counter is (rows+1)/2 or (columns+1)/2 it will exit out of the recursion.
 *		During the recursive call it will call another method of buildFrames to put elements in the array then call itself with counter+1
 *	buildFrames
 *		This method uses 2 for-loops (not nested) to build the outside parts of the array each iteration. first it builds the floor and ceiling then to two side walls.
 * 
 * @Author Adam Smith
 * @Version 10/5/2018
*/

import java.util.Arrays;
import java.util.Scanner;

public class Building_Rectangles_Recursive {
	public static void main(String[] args) 
	{
		boolean done = false;
		int rows, columns;
		Scanner userInput = new Scanner(System.in);
		String welcomeMessage = "Welcome to my program for filling an rectangular array. You will be prompt to enter the nubmer of rows you want\n"
				+ "and the number of columns you would like.";
		System.out.println(welcomeMessage);

		while (!done) {
			System.out.println("Enter how many rows you would like:");
			rows = userInput.nextInt();
			System.out.println("Enter how many columns you would like:");
			columns = userInput.nextInt();
			int [][] array = new int[rows][columns];
			array = box(rows,columns);
			
			for (int[] x: array) {
				System.out.println(Arrays.toString(x));
			}
			
			System.out.println("If you would like to stop enter 0 or enter any integer to continue ");
			if (userInput.nextInt()==0) done=true;

		}
		System.out.println("End of Program");
		
		
	}
	
	public static int[][] box(int rows, int columns){
		int[][] array = new int[rows][columns];
		int counter = 0;
		if (rows == 0 || columns == 0) {
			System.out.println("No rows or no columns entered");
			return array;
		}else
			return recursiveCall(array,rows,columns,counter);
	}
	
	private static int[][] recursiveCall(int[][] array, int rows, int collumns, int counter){
		
		if (counter >= (rows+1)/2  || counter >= (collumns+1)/2) {
			return array;
		}else {
			buildFrames(array, rows, collumns, counter);
			return recursiveCall(array, rows, collumns, counter+1);
		}	
	}
	private static int[][] buildFrames(int[][] array, int rows, int collumns, int counter){
		for (int i = counter; i < collumns - counter; i++) {
			array[counter][i] = counter+1;
			array[rows-(counter+1)][i] = counter+1;
		}
		for (int i = counter; i < rows - counter; i++) {
			array[i][counter] = counter+1;
			array[i][collumns - (counter+1)] = counter+1;
		}
		return array;
	}
}
