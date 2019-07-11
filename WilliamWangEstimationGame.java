//Author: William Wang
//Date: May 15, 2017

package evaluations;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

/**
 * This program will store in a file the top 10 high scores of a test, as
 * measured from the lowest percentage error.
 * 
 * @author TTW
 *
 */

public class WilliamWangEstimationGame {

	// Set up global variables for the user scanner, file, printwriter, user
	// answer, true answer, total score, and total error
	static Scanner input = new Scanner(System.in);
	static File lowestError;
	static PrintWriter pw;
	static double[] userAnswer, trueAnswer, percentageError, totalScore;
	static double totalError;
	static int counter;
	static boolean foundFlag;

	public static void main(String[] args) throws FileNotFoundException {

		int choice = getUserChoice();

		switch (choice) {
		case 1:
			testUser();
			break;
		case 2:
			viewScores();
			break;
		case 3:
			resetFile();
			break;
		default:
			System.out.println("Something went wrong.");
			break;
		}

	}

	/**
	 * This method will initialize the scoreboard and get the user's choice as
	 * to what they want to do
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static int getUserChoice() throws FileNotFoundException {
		// Initialize the file
		lowestError = new File("lowScores.txt");
		// Get the user's choice
		System.out.println("Welcome to the Estimation Game 6000!");
		System.out.println("Please select an option from the following list.");
		System.out.println("Type in the number that corresponds to your choice.");
		System.out.println("1: Take the test");
		System.out.println("2: View the top 10 scores (top 10 lowest percentage errors)");
		System.out.println("3: Reset the scoreboard");
		int choice = input.nextInt();

		// Error check the user's choice
		while ((choice < 1) || (choice > 3)) {
			System.out.println("Please enter 1, 2, or 3.");
			choice = input.nextInt();
		}

		return choice;

	}

	/**
	 * This method allows the user to view the top 10 scores in the test
	 * 
	 * @throws FileNotFoundException
	 */
	public static void viewScores() throws FileNotFoundException {

		// The scanner will read all numbers in the file
		Scanner fileIn = new Scanner(lowestError);

		while (fileIn.hasNext()) {
			System.out.println(fileIn.nextDouble());
		}

		fileIn.close();
	}

	/**
	 * This method will reset the file to 10 values of 1 billion
	 * 
	 * @throws FileNotFoundException
	 */
	public static void resetFile() throws FileNotFoundException {

		// Reset the scoreboard to 10 values of 1 billion
		pw = new PrintWriter(lowestError);

		for (int i = 0; i < 10; i++) {
			pw.println(1000000000);
		}

		pw.flush();
		pw.close();

		System.out.println("The scoreboard has been reset to 10 values of 1 billion.");

	}

	/**
	 * This method will test the user
	 * @throws FileNotFoundException
	 */
	public static void testUser() throws FileNotFoundException {


		//Initialize the file and arrays
		userAnswer = new double[10];
		trueAnswer = new double[10];
		
		//Introduce the game and test the user
		System.out.println("Welcome to the Estimation Game 6000!");
		System.out.println("You will be asked 10 questions.");
		System.out.println("Your answer has to be a real number.");
		System.out.println("The percentage difference between your answer and the correct answer will be determined.");
		System.out.println("At the end, your percentage errors will be added up.");
		System.out.println("The lower the percentage error, the better your score!");

		System.out.print("\n");

		//Initialize the true answers
		trueAnswer[0] = 1867.0;
		trueAnswer[1] = 27.0;
		trueAnswer[2] = 63.8;
		trueAnswer[3] = 8.0;
		trueAnswer[4] = 12.0;
		trueAnswer[5] = 206.0;
		trueAnswer[6] = 273.15;
		trueAnswer[7] = 10.5;
		trueAnswer[8] = 373.15;
		trueAnswer[9] = 1.0;
		
		System.out.println("Question 1: In what year did Canada become an independent country?");
		userAnswer[0] = input.nextDouble();

		System.out.println("Question 2: How many bones are in a human hand?");
		userAnswer[1] = input.nextDouble();

		System.out.println("Question 3: In 2014, what percentage of 19-year-olds in Canada attended university?");
		userAnswer[2] = input.nextDouble();

		System.out.println("Question 4: How many neutrons are in carbon-14?");
		userAnswer[3] = input.nextDouble();

		System.out.println("Question 5: How many edges does a cube have?");
		userAnswer[4] = input.nextDouble();

		System.out.println("Question 6: How many bones does an adult human body have in total?");
		userAnswer[5] = input.nextDouble();

		System.out.println("Question 7: At what temperature does water melt/freeze at sea level, in degrees Kelvin?");
		userAnswer[6] = input.nextDouble();

		System.out.println("Question 8: If one side of a triangle measures 4.0 units, and another side of a triangle measures 6.5 units, what number of units must the third side be less than?");
		userAnswer[7] = input.nextDouble();

		System.out.println("Question 9: At what temperature does water boil/condense at sea level, in degrees Kelvin?");
		userAnswer[8] = input.nextDouble();

		System.out.println("Question 10: What is the number of neutrons in deuterium?");
		userAnswer[9] = input.nextDouble();


		
		//Calculate percentage error
		Scanner fileIn = new Scanner(lowestError);
		Scanner secondFileIn = new Scanner(lowestError);
		counter = 0;
		totalError = 0;
		totalScore = new double[11];
		percentageError = new double[10];

		for (int j = 0; j < percentageError.length; j ++) {
			percentageError[j] = Math.abs(((trueAnswer[j] - userAnswer[j]) / trueAnswer[j]) * 100.0);
			totalError += percentageError[j];
			System.out.println("Your percentage error on question " + (j + 1) + " is " + percentageError[j] + "%.");
		}

		//Display the score on the scoreboard if the percentage error is one of the 10 lowest
		while (fileIn.hasNext()) {
			totalScore[counter] = fileIn.nextDouble();
			counter ++;
		}

		System.out.println("Your final total percentage error is " + totalError + "%. ");
		System.out.print("\n");
		System.out.println("The correct answers are as follows: ");
		
		//List the true answers
		for (int k = 0; k < trueAnswer.length; k ++) {
			System.out.println("The answer to question number " + (k + 1) + " is " + trueAnswer[k] + ".");
		}
		
		//Place the total error on the most recent attempt in the last spot in the array
		totalScore[10] = totalError;
		
		//Sort the array by increasing numeric order
		Arrays.sort(totalScore);
		
		//Initialize the printwriter
		pw = new PrintWriter(lowestError);
		
		//The printwriter writes the top 10 scores into the file
		for (int l = 0; l < 10; l ++) {
			pw.println(totalScore[l]);
		}

		pw.flush();
		pw.close();
		

		
		//Tell the user of the location of their score on the scoreboard
		//Also tell the user if their score is not on the scoreboard
		foundFlag = false;

		for (int m = 0; m < 10; m ++) {
			if (totalScore[m] == totalError) {
				System.out.println("Your score is at position number " + (m + 1) + " on the scoreboard.");
				foundFlag = true;

			}

		}

		if (foundFlag == false) {
			System.out.println("Your score is not on the scoreboard.");
		}
		
		System.out.println("Here is the scoreboard:");
		while (secondFileIn.hasNext()) {
			System.out.println(secondFileIn.nextDouble());
		}
		

		fileIn.close();
		secondFileIn.close();

	}

}
