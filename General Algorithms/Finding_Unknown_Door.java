/*
 * This algorithm finds how many steps it would take someone to find an unknown door only moving left and right.
 * The algorithm movies the person right 1 than left 2, right 4, left 8... until the person finds the unknown door
 * 
 * The method keeps track of where the person is using personLocation
 * cpuLocation is where the computer is guessing where the door is, but it just moves the person left and right by the powers of 2
 * stepInc is the -2 that cpuLocation is being multiplied by
 * found controls if the door is found or not
 * isNegative is just a boolean if the door is a negative location or not
 * difference is used to when the person "jumps over the door" and need to subtract from the total step count* 
 * 
 * The program works by moving the person right 1 time and checking if the person has found the door. It adds the cpuLocation to itself to change its location and continues checking-
 * it finds the door.
 * 
 * @Author Adam Smith
 * @Version 10/2/18
 */

import java.util.Scanner;

public class Finding_Unknown_Door {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userResponse = "";
		int doorLocation =0;
		boolean done =false;
		System.out.println("Welcome to my door finding program! Type in where you would like the door to be and the program will tell you how many steps it took to find it.");
		System.out.println("Enter a location for the door: ");
		while(!done) {
			doorLocation = input.nextInt();
			findTheDoor(doorLocation);
			
			System.out.println("Would you like to run again? y/n :");
			userResponse = input.next();
			if (userResponse.equals("n")) done = true;
			else {
				System.out.println("Enter a new location for the Door: ");
			}
		}
		input.close();
		System.out.println("End of program.");
	}
	
	private static void findTheDoor(int doorLocation){
		int cpuLocation=1;
		int stepCount=0;
		boolean found = false;
		int stepInc = -2;
		int difference = 0;
		int personLocation=0;	
		boolean isNegative = false;
		
		if (doorLocation < 0) isNegative = true;
		
		while (!found) {
			if (isNegative && personLocation <= doorLocation ) {
				found = true;
			}
			else if (!isNegative && personLocation >= doorLocation ) {
				found = true;
			}
			else {
				personLocation += cpuLocation;
				stepCount += Math.abs(cpuLocation);
				cpuLocation *= stepInc;
				if (cpuLocation > 0) System.out.println("Moved right "+ cpuLocation+ " steps.");
				else System.out.println("Moved left "+ Math.abs(cpuLocation) + " steps.");
			}
		}
		difference = personLocation - doorLocation;
		stepCount -= Math.abs(difference);
		if (personLocation > doorLocation) System.out.println("Moved right "+ difference+ " steps.");
		else if (personLocation < doorLocation)System.out.println("Moved left "+ Math.abs(difference) + " steps.");
		System.out.println("Found the Door! It took " + stepCount+ " steps to find it.");
		
	}

}
