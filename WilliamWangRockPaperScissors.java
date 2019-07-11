//Author: William Wang
//Date: April 12, 2017

package evaluations;

import java.util.Scanner;

/**
 * This program will pit man vs machine in a game of ROCK PAPER SCISSORS LIZARD SPOCK!
 * @author TTW
 *
 */

public class WilliamWangRockPaperScissors {

	//The scanner, and the scores of the player and computer are set as global variables.
	static Scanner input = new Scanner(System.in);
	static int playerScore = 0;
	static int computerScore = 0;

	public static void main(String[] args) {
		greetAndInstruct();

		do {
			String playerChoice = getPlayerChoice();
			String computerChoice = getComputerChoice();

			determineWinner(playerChoice, computerChoice);

			scoreTracker();
		} while ((playerScore < 4) && (computerScore < 4));

		endScreen();

	}

	public static void greetAndInstruct() {
		//The instructions are given.
		System.out.println("Welcome to rock paper scissors lizard spock!");
		System.out.println("When prompted, type in 'rock', 'paper', 'scissors', 'lizard', or 'spock'.");
		System.out.println("The computer will select its choice as well.");
		System.out.println("Paper and spock beat rock, scissors and lizard beat paper, rock and spock beat scissors, scissors and rock beat lizard, and paper and lizard beat spock.");
		System.out.println("The first contestant to 4 wins wins the game!");
	}

	public static String getPlayerChoice() {
		//The player enters their throw.
		System.out.println("Enter your throw.");
		String playerChoice = input.next();

		//The player must enter a valid throw.
		while (!playerChoice.equalsIgnoreCase("rock") && !playerChoice.equalsIgnoreCase("paper") && !playerChoice.equalsIgnoreCase("scissors") && !playerChoice.equalsIgnoreCase("lizard") && !playerChoice.equalsIgnoreCase("spock")) {
			System.out.println("Please re-enter your throw.");
			playerChoice = input.next();
		}

		return playerChoice;
	}

	public static String getComputerChoice() {

		//The computer will randomly generate a number from 1 to 5 inclusive.
		int choice = (int) ((Math.random() * 5) + 1);

		//The computer's throw depends on the number it generates.
		switch (choice) {
		case 1: return "rock";
		case 2: return "paper";
		case 3: return "scissors";
		case 4: return "lizard";
		case 5: return "spock";
		//The default statement should never be reached.
		default: return null;
		}

	}

	public static void determineWinner(String playerChoice, String computerChoice) {

		//The player's choice and the computer's choice are displayed.
		System.out.println("Player Choice: " + playerChoice.toLowerCase());
		System.out.println("Computer Choice: " + computerChoice);

		if (playerChoice.equalsIgnoreCase("rock")) {

			if (computerChoice.equalsIgnoreCase("rock")) {
				System.out.println("Draw");
			}

			else if (computerChoice.equalsIgnoreCase("paper") || computerChoice.equalsIgnoreCase("spock")) {
				System.out.println("The computer wins the round.");
				computerScore ++;
			}

			else if (computerChoice.equalsIgnoreCase("scissors") || computerChoice.equalsIgnoreCase("lizard")){
				System.out.println("The user wins the round.");
				playerScore ++;
			}

			//The following 'else' statement should never be reached.
			else {
				System.out.println("Something went wrong.");
			}

		}

		else if (playerChoice.equalsIgnoreCase("paper")) {

			if (computerChoice.equalsIgnoreCase("paper")) {
				System.out.println("Draw");
			}

			else if (computerChoice.equalsIgnoreCase("lizard") || computerChoice.equalsIgnoreCase("scissors")) {
				System.out.println("The computer wins the round.");
				computerScore ++;
			}

			else if (computerChoice.equalsIgnoreCase("rock") || computerChoice.equalsIgnoreCase("spock")) {
				System.out.println("The player wins the round.");
				playerScore ++;
			}

			//The following 'else' should never be reached.
			else {
				System.out.println("Something went wrong.");
			}

		}

		else if (playerChoice.equalsIgnoreCase("scissors")) {

			if (computerChoice.equalsIgnoreCase("scissors")) {
				System.out.println("Draw");
			}

			else if (computerChoice.equalsIgnoreCase("rock") || computerChoice.equalsIgnoreCase("spock")) {
				System.out.println("The computer wins the round.");
				computerScore ++;
			}

			else if (computerChoice.equalsIgnoreCase("paper") || computerChoice.equalsIgnoreCase("lizard")) {
				System.out.println("The player wins the round.");
				playerScore ++;
			}


			//The following 'else' statement should never be reached.
			else {
				System.out.println("Something went wrong.");
			}

		}

		else if (playerChoice.equalsIgnoreCase("lizard")) {

			if (computerChoice.equalsIgnoreCase("lizard")) {
				System.out.println("Draw");
			}

			else if (computerChoice.equalsIgnoreCase("scissors") || computerChoice.equalsIgnoreCase("rock")) {
				System.out.println("The computer wins the round.");
				computerScore ++;
			}

			else if (computerChoice.equalsIgnoreCase("spock") || computerChoice.equalsIgnoreCase("paper")) {
				System.out.println("The player wins the round.");
				playerScore ++;
			}

			//The following 'else' statement should never be reached.
			else {
				System.out.println("Something went wrong.");
			}

		}

		else if (playerChoice.equalsIgnoreCase("spock")) {

			if (computerChoice.equalsIgnoreCase("spock")) {
				System.out.println("Draw");
			}

			else if (computerChoice.equalsIgnoreCase("paper") || computerChoice.equalsIgnoreCase("lizard")) {
				System.out.println("The computer wins the round.");
				computerScore ++;
			}

			else if (computerChoice.equalsIgnoreCase("rock") || computerChoice.equalsIgnoreCase("scissors")) {
				System.out.println("The player wins the round.");
				playerScore ++;
			}

			//The following 'else' statement should never be reached.
			else {
				System.out.println("Something went wrong.");
			}

		}


		//The following 'else' statement should never be reached.
		else {
			System.out.println("Something went wrong.");
		}

	}

	public static void scoreTracker() {
		System.out.println("Player Score: " + playerScore);
		System.out.println("Computer Score: " + computerScore);
	}

	public static void endScreen() {
		if (computerScore >= 4) {
			System.out.println("The computer wins!");
		}

		else if (playerScore >= 4) {
			System.out.println("The player wins!");
		}

		//The following statement should never be reached.
		else {
			System.out.println("Something went wrong.");
		}
	}

}
