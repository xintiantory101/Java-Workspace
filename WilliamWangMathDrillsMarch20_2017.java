package evaluations;

//Import the scanner.
import java.util.Scanner;

public class WilliamWangMathDrillsMarch20_2017 {


	/**
	 * This program will allow a user to choose to do a number of their choice of either multiplication or addition questions.
	 * They will keep trying a single question until it is answered correctly.
	 * This program was sent by William Wang on March 20, 2017.
	 * @param args
	 */

	public static void main(String[] args) {
		//Initiate the scanner.
		Scanner input= new Scanner (System.in);

		//Get the user's choice of doing either addition or multiplication questions.
		System.out.println("Hello! Do you want to try addition or multiplication?");
		System.out.println("Enter 1 for addition, or enter 2 for multiplication.");
		int choice = input.nextInt();

		//Initiate variables for the counter, the maximum and minimum values in the questions, the number of questions, and the user's answer.
		int counter;
		int maximum;
		int minimum;
		int numOfQuestions;
		int answer;

		//Until the user selects either addition or multiplication drills, the program will loop the option.
		while ((choice != 1) && (choice != 2)) {
			System.out.println("Your selection is invalid. Please enter 1 for addition or 2 for multiplication.");
			choice = input.nextInt();
		}

		counter = 1;
		if (choice == 1) {
			System.out.println("We are going to do some addition drills!");

			//Get the user's input for the minimum and maximum values in the questions.
			System.out.println("Enter the lowest number you want to see in your questions.");
			minimum = input.nextInt();

			System.out.println("Enter the highest number you want to see in your questions.");
			maximum = input.nextInt();

			//Make sure the maximum value is greater than the minimum value.
			while (minimum >= maximum) {
				System.out.println("Your maximum number must be greater than your minimum number.");
				System.out.println("Please enter your minimum number again.");
				minimum = input.nextInt();
				System.out.println("Please enter your maximum number again.");
				maximum = input.nextInt();
			} 

			//Ask the user the number of questions the user would like to complete.
			System.out.println("How many questions do you want to do?");
			numOfQuestions = input.nextInt();

			System.out.println("Only when a correct answer is entered, will we proceed to the next question.");

			//The program will make sure the user enters the answer correctly before giving a new question.
			do {

				int number1 = (int) (Math.random()*((maximum - minimum + 1)) + minimum);
				int number2 = (int) (Math.random()*((maximum - minimum + 1)) + minimum);

				System.out.println("What is " + number1 + " + " + number2 + "?");
				answer = input.nextInt();


				while (answer != (number1 + number2)) {
					System.out.println("What is " + number1 + " + " + number2 + "?");
					answer = input.nextInt();
				}
				counter++;
			} while (counter <= numOfQuestions);


		}

		else if (choice == 2) {
			System.out.println("We are going to do some multiplication drills!");

			//Get the user's input for the minimum and maximum values in the questions.
			System.out.println("Enter the lowest number you want to see in your questions.");
			minimum = input.nextInt();

			System.out.println("Enter the highest number you want to see in your questions.");
			maximum = input.nextInt();

			//Make sure the maximum value is greater than the minimum value.
			while (minimum >= maximum) {
				System.out.println("Your maximum number must be greater than your minimum number.");
				System.out.println("Please enter your minimum number again.");
				minimum = input.nextInt();
				System.out.println("Please enter your maximum number again.");
				maximum = input.nextInt();
			}

			//Ask the user the number of questions the user would like to complete.
			System.out.println("How many questions do you want to do?");
			numOfQuestions = input.nextInt();

			System.out.println("Only when a correct answer is entered, will we proceed to the next question.");

			//The program will make sure the user enters the answer correctly before giving a new question.
			do {

				int number1 = (int) (Math.random()*((maximum - minimum + 1)) + minimum);
				int number2 = (int) (Math.random()*((maximum - minimum + 1)) + minimum);

				System.out.println("What is " + number1 + " * " + number2 + "?");
				answer = input.nextInt();


				while (answer != (number1 * number2)) {
					System.out.println("What is " + number1 + " * " + number2 + "?");
					answer = input.nextInt();
				}

				counter++;
			} while (counter <= numOfQuestions);

		}

		//The program will finally congratulate the user.
		System.out.println("Good job!");

	}

}
