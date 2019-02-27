/*
 * Virus Attack HWset2Problem5
 * 
 * Program depends on 2 Static variables : virus, steps
 * Both variables are reset before the final return for the method
 * 
 * The method checks to see if the bacteria (int variable) is less than or equal to 0 else it will subtract the total viruses from the bacteria, and double the viruses.
 * Then the method is called again with 2*bacteria which would be less than what the original total of bacteria was due to the subtraction 
 * 
 * 
 * 
 * @author Adam Smith
 * @version (10/2/18)
 */

import java.util.Scanner;

public class Virus_Attack {
	static int virus = 1;
	static int steps = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userResponse = "";
		int numOfBacteria =0;
		boolean done =false;
		System.out.println("Welcome to my virus Attack program! Type in how many bacteria you would like there to be and the program will tell you how many steps it took for the virus to kill them all.");
		System.out.println("Enter how many bacteria there are: ");
		while(!done) {
			numOfBacteria = input.nextInt();
			System.out.println("The total steps it took " + numOfBacteria + " bacteria to die was " + virusAttack(numOfBacteria));
			
			System.out.println("Would you like to run again? y/n :");
			userResponse = input.next();
			if (userResponse.equals("n")) done = true;
			else {
				System.out.println("Enter a new total for the bacteria: ");
			}
		}
		input.close();
		System.out.println("End of program.");
	}
	
	private static int virusAttack(int bacteria) {
		int stepsToReturn =0;
		if (bacteria <= 0) {
			virus = 1;
			stepsToReturn = steps;
			steps=0;
			return stepsToReturn;
		}
		else 
			bacteria -= virus;
			virus *= 2;
			steps++;
			return virusAttack(bacteria*2);
		}
}
