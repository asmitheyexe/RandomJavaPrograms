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
 * 		Used to initialize an array of NxM elements, initialized a counter and then checks to see if either rows or columns are 0. Then it continues to fill the frames of the array outside to inside 
 * 		one iteration at a time. 
 * 
 * @Author Adam Smith
 * @Version 10/5/2018
*/

import java.util.Arrays;
import java.util.Scanner;

public class Building_Rectangles_notrecursive 
{
	private static int[][] box(int rows, int columns)
	{
		int[][] array = new int[rows][columns];
		int iteration = 0;
		int maxIteration;
		if (rows < columns) {
			 maxIteration = (rows+1)/2;
		}else {
			 maxIteration = (columns+1)/2;
		}
		for (iteration = 0; iteration < maxIteration; iteration++) {	
			for (int i = iteration; i < columns - iteration; i++) {
				array[iteration][i] = iteration+1;
				array[rows-(iteration+1)][i] = iteration+1;
			}
			for (int i = iteration; i < rows - iteration; i++) {
				array[i][iteration] = iteration+1;
				array[i][columns - (iteration+1)] = iteration+1;
			}
		}
		return array;
	}
	public static void main(String[] args) 
	{
		boolean done = false;
		int rows, columns;
		Scanner userInput = new Scanner(System.in);
		String welcomeMessage = "Welcome to my program for filling an rectangular array with iterations. You will be prompt to enter the nubmer of rows you want\n"
				+ "and the number of columns you would like.";
		System.out.println(welcomeMessage);

		while (!done) {
			System.out.println("Enter how many rows you would like:");
			rows = userInput.nextInt();
			System.out.println("Enter how many columns you would like:");
			columns = userInput.nextInt();
			int [][] array = new int[rows][columns];
			
			if (rows <= 0 || columns <= 0) {
				System.out.println("Need to have rows or columns be greater than 1.");
				System.out.println("If you would like to stop enter 0 or enter any integer to continue ");
				if (userInput.nextInt()==0) done=true;
			}else {
				array = box(rows,columns);
				
				for (int[] x: array) {
					System.out.println(Arrays.toString(x));
				}
				
				System.out.println("If you would like to stop enter 0 or enter any integer to continue ");
				if (userInput.nextInt()==0) done=true;
				
			}
			

		}
		System.out.println("End of Program");
		
	}



}
