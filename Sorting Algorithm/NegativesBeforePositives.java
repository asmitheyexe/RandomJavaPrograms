/*
 * Negative before positive
 * 
 * Used code from scholar to quickly sort negative and positives with 0's intertwined. Code found under Week 02 "Problem01" on 18/FA Intro Algorithm w/Lab (CMSC-250-A) Scholar page.
 * 
 * Added Method to seperate 0's. Comments explain with in the code.
 * 	Quick Summary: The method goes through the array after it is quick sorted and separates the 0s and pushes them to the center of where the negative and positives meet.
 * 
 * @author Adam Smith
 * @version (11/5/18)
 * 
 */

import java.util.*;

public class NegativesBeforePositives {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userResponse = "";
		int count =0;
		boolean done =false;
		System.out.println("Welcome to Adam Smith's sorting program! This program is designed to sort Negatives before positive number (which aren't sorted by value). Either select option 1 or 2 to run my program.");
		while(!done) {
			System.out.println("Option 1: Randomly filled array with values from -10 to 10.\nOption 2: Manually fill array.\nEnter your option: ");
			userResponse = input.nextInt()+"";

			if(userResponse.equals("1")) {
				System.out.println("Please enter how large you would like your array to be: ");
				int limit = input.nextInt();
				int[] array = new int[limit];
				for (int index = 0; index < array.length; index++)
					array[index] = (int) (Math.random() * 20 - 10);
				sortNegativePositive(array);
			}else if(userResponse.equals("2")) {
				System.out.println("How large would you like your array? ");
				int[] array = new int[input.nextInt()];
				while(!done) {
					System.out.println("Current total is: "+ (count+1) +"\nPlease enter a integer: " );
					array[count] = input.nextInt();
					count++;
					if(count == array.length) done = true;
				}
				sortNegativePositive(array);
			}
			done = false;
			System.out.println("Would you like to run again? y/n :");
			userResponse = input.next();
			if (userResponse.equals("n")) {
				done = true;
				input.close();
				System.out.println("End of program.");
			}
			
		}
	}

		private static int[] fixZeros(int[] array, int endLeft, int startRight) {
			int zeroPlaceLeft=endLeft; //Where the negatives end in the array
			int zeroPlaceRight = startRight; // where the positives start in the array
			for (int index = 0; index < array.length; index++) { //loop through the whole array 1 more time to find 0's
				if(array[index] == 0 && index <= endLeft) { // this check when there is a 0 in the negative side, if there is
					int temp = array[zeroPlaceLeft];	   // swap the value at the end of the negatives with the current index 
					array[zeroPlaceLeft] = array[index]; 
					array[index] = temp;
					if(array[index] != 0 && array[zeroPlaceLeft] == 0)zeroPlaceLeft--;
				}
				if(array[index] == 0 && index > startRight) { // same idea as above but on the positive end of the array
					int temp = array[zeroPlaceRight];
					array[zeroPlaceRight] = array[index];
					array[index] = temp;
					if(array[index] != 0 && array[zeroPlaceRight] == 0)zeroPlaceRight++;
				}
			}
			return array;
		}

		private static void sortNegativePositive(int[] array) {
			System.out.println("Before sorting:\n" +Arrays.toString(array));
			int leftIndex = 0;
			int rightIndex = array.length - 1;
			while (leftIndex < rightIndex)
			{
				while (leftIndex < array.length && array[leftIndex] <= 0 )
					leftIndex++;
				while (rightIndex >= 0 && array[rightIndex] >= 0 )
					rightIndex--;

				if (leftIndex < rightIndex)
				{
					int temp = array[rightIndex];
					array[rightIndex] = array[leftIndex];
					array[leftIndex] = temp;
				}
			}
			
			array = fixZeros(array,rightIndex,leftIndex);
			System.out.println("After sort \n" +Arrays.toString(array));
		}

	}
