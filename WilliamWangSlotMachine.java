package evaluations;

import java.util.Scanner;

public class WilliamWangSlotMachine {

	/**
	 * This program will allow users to bet various amounts of money in a slot machine.
	 * If they succeed, they can win a fortune. However, if they fail, they lose everything.
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		System.out.println("Please enter your age.");
		int age = input.nextInt();

		if (age >= 19) {
			int bet;
			int number1;
			int number2;
			int number3;
			int winCounter = 0;
			int lossCounter = 0;
			int coins = 100;
			int totalBet = 0;
			int spinCounter = 0;
			String symbol1 = null;
			String symbol2 = null;
			String symbol3 = null;

			//The player is introduced to the rules.
			System.out.println("Welcome to the H5H6 Game Room, where you can win your fortune!");
			System.out.println("You start off with $100.");
			System.out.println("You must then place a bet of no more than $10 or the amount of money that you have at that point, whichever one is the lowest.");
			System.out.println("After placing your bet, the spinners will spin.");
			System.out.println("You may spin the slot as long as you have at least $1.");
			System.out.println("On each spin, 3 spinners will run. Each of the spinners will land on one of the following lattices: %*, &*, @*, or $*.");
			System.out.println("If the spinners all land on the same number, you win!");
			System.out.println("If the spinners all land on the lattice of %*, you win back 2 times your bet.");
			System.out.println("If the spinners all land on the lattice of &*, you win back 5 times your bet.");
			System.out.println("If the spinners all land on the lattice of @*, you win back 20 times your bet.");
			System.out.println("If the spinners all land on the lattice of $*, you win back 100 times your bet.");
			System.out.println("You must bet a whole number of dollars each time.");
			System.out.println("You must bet at least $1 on your first spin.");
			System.out.println("On subsequent spins, simply bet $0 to exit!");




			System.out.println("Enter your first bet.");
			bet = input.nextInt();

			//The player cannot quit on the first bet.
			while ((bet > 10) || (bet < 1)) {
				System.out.println("Please bet between $1 and $10.");
				bet = input.nextInt();
			}

			//The player loses the amount they bet. The bet counter and the spin counter are set up.
			coins -= bet;
			totalBet += bet;
			spinCounter ++;

			//Each number is a number between 1 and 4. There are 3 numbers, one for each screen.
			number1 = (int) (Math.random() * 4 + 1);
			number2 = (int) (Math.random() * 4 + 1);
			number3 = (int) (Math.random() * 4 + 1);

			//Symbols are designated to each number.
			if (number1 == 1) {
				symbol1 = "%*%*%*%*%" + "\n" + "*%*%*%*%*";
			}

			if (number2 == 1) {
				symbol2 = "%*%*%*%*%" + "\n" + "*%*%*%*%*";
			}

			if (number3 == 1) {
				symbol3 = "%*%*%*%*%" + "\n" + "*%*%*%*%*";
			}

			if (number1 == 2) {
				symbol1 = "&*&*&*&*&" + "\n" + "*&*&*&*&*";
			}

			if (number2 == 2) {
				symbol2 = "&*&*&*&*&" + "\n" + "*&*&*&*&*";
			}

			if (number3 == 2) {
				symbol3 = "&*&*&*&*&" + "\n" + "*&*&*&*&*";
			}

			if (number1 == 3) {
				symbol1 = "@*@*@*@*@" + "\n" + "*@*@*@*@*";
			}

			if (number2 == 3) {
				symbol2 = "@*@*@*@*@" + "\n" + "*@*@*@*@*";
			}

			if (number3 == 3) {
				symbol3 = "@*@*@*@*@" + "\n" + "*@*@*@*@*";
			}

			if (number1 == 4) {
				symbol1 = "$*$*$*$*$" + "\n" + "*$*$*$*$*";
			}

			if (number2 == 4) {
				symbol2 = "$*$*$*$*$" + "\n" + "*$*$*$*$*";
			}

			if (number3 == 4) {
				symbol3 = "$*$*$*$*$" + "\n" + "*$*$*$*$*";
			}

			//The symbols are displayed.
			System.out.print(symbol1 + "\n" + "\n" + symbol2 + "\n" + "\n" + symbol3 + "\n");

			//If the symbols that are displayed are equal, the player wins. Otherwise, the player loses.
			//If the number is 1, and therefore the symbol is the lattice of %*, the player wins back 2 times their bet.
			//If the number is 2, and therefore the symbol is the lattice of &*, the player wins back 5 times their bet.
			//If the number is 3, and therefore the symbol is the lattice of @*, the player wins back 20 times their bet.
			//If the number is 4, and therefore the symbol is the lattice of $*, the player wins back 100 times their bet.
			if ((number1 == number2) && (number2 == number3) && (number1 == 1)) {
				coins += (2 * bet);
				System.out.println("You win $" + bet + "!");
				System.out.println("Your current balance is $" + coins + "!");
				winCounter ++;

			}

			else if ((number1 == number2) && (number2 == number3) && (number1 == 2)) {
				coins += (5 * bet);
				System.out.println("You win $" + (4 * bet) + "!");
				System.out.println("Your current balance is $" + coins + "!");
				winCounter ++;

			}

			else if ((number1 == number2) && (number2 == number3) && (number1 == 3)) {
				coins += (20 * bet);
				System.out.println("You win $" + (19 * bet) + "!");
				System.out.println("Your current balance is $" + coins + "!");
				winCounter ++;

			}

			else if ((number1 == number2) && (number2 == number3) && (number1 == 4)) {
				coins += (100 * bet);
				System.out.println("You win $" + (99 * bet) + "!");
				System.out.println("Your current balance is $" + coins + "!");
				winCounter ++;

			}

			else {
				coins += 0;
				System.out.println("You lose $" + bet + "!");
				System.out.println("Your current balance is $" + coins + "!");
				lossCounter ++;

			}


			//On subsequent bets, the player can quit at any time.
			do {
				System.out.println("Enter your next bet. To exit, bet $0.");
				bet = input.nextInt();

				while ((bet > 10) || (bet < 0)) {
					System.out.println("Please bet between $1 and $10, or bet $0 to exit.");
					bet = input.nextInt();
				}

				while (bet > coins) {
					System.out.println("You may only bet up to the amount of money you have.");
					bet = input.nextInt();
				}

				//The player loses the amount they bet. The bet counter and the spin counter are set up.
				coins -= bet;
				totalBet += bet;
				spinCounter ++;

				//Each number is a number between 1 and 4. There are 3 numbers, one for each screen.
				number1 = (int) (Math.random() * 4 + 1);
				number2 = (int) (Math.random() * 4 + 1);
				number3 = (int) (Math.random() * 4 + 1);

				//Designate a symbol for each number.

				if (number1 == 1) {
					symbol1 = "%*%*%*%*%" + "\n" + "*%*%*%*%*";
				}

				if (number2 == 1) {
					symbol2 = "%*%*%*%*%" + "\n" + "*%*%*%*%*";
				}

				if (number3 == 1) {
					symbol3 = "%*%*%*%*%" + "\n" + "*%*%*%*%*";
				}

				if (number1 == 2) {
					symbol1 = "&*&*&*&*&" + "\n" + "*&*&*&*&*";
				}

				if (number2 == 2) {
					symbol2 = "&*&*&*&*&" + "\n" + "*&*&*&*&*";
				}

				if (number3 == 2) {
					symbol3 = "&*&*&*&*&" + "\n" + "*&*&*&*&*";
				}

				if (number1 == 3) {
					symbol1 = "@*@*@*@*@" + "\n" + "*@*@*@*@*";
				}

				if (number2 == 3) {
					symbol2 = "@*@*@*@*@" + "\n" + "*@*@*@*@*";
				}

				if (number3 == 3) {
					symbol3 = "@*@*@*@*@" + "\n" + "*@*@*@*@*";
				}

				if (number1 == 4) {
					symbol1 = "$*$*$*$*$" + "\n" + "*$*$*$*$*";
				}

				if (number2 == 4) {
					symbol2 = "$*$*$*$*$" + "\n" + "*$*$*$*$*";
				}

				if (number3 == 4) {
					symbol3 = "$*$*$*$*$" + "\n" + "*$*$*$*$*";
				}

				//The symbols are displayed.
				System.out.print(symbol1 + "\n" + "\n" + symbol2 + "\n" + "\n" + symbol3 + "\n");

				//If the symbols that are displayed are equal, the player wins. Otherwise, the player loses.
				//If the number is 1, and therefore the symbol is the lattice of %*, the player wins back 2 times their bet.
				//If the number is 2, and therefore the symbol is the lattice of &*, the player wins back 5 times their bet.
				//If the number is 3, and therefore the symbol is the lattice of @*, the player wins back 20 times their bet.
				//If the number is 4, and therefore the symbol is the lattice of $*, the player wins back 100 times their bet.
				if ((number1 == number2) && (number2 == number3) && (number1 == 1)) {
					coins += (2 * bet);
					System.out.println("You win $" + bet + "!");
					System.out.println("Your current balance is $" + coins + "!");
					winCounter ++;

				}

				else if ((number1 == number2) && (number2 == number3) && (number1 == 2)) {
					coins += (5 * bet);
					System.out.println("You win $" + (4 * bet) + "!");
					System.out.println("Your current balance is $" + coins + "!");
					winCounter ++;

				}

				else if ((number1 == number2) && (number2 == number3) && (number1 == 3)) {
					coins += (20 * bet);
					System.out.println("You win $" + (19 * bet) + "!");
					System.out.println("Your current balance is $" + coins + "!");
					winCounter ++;

				}

				else if ((number1 == number2) && (number2 == number3) && (number1 == 4)) {
					coins += (100 * bet);
					System.out.println("You win $" + (99 * bet) + "!");
					System.out.println("Your current balance is $" + coins + "!");
					winCounter ++;

				}

				else {
					coins += 0;
					System.out.println("You lose $" + bet + "!");
					System.out.println("Your current balance is $" + coins + "!");
					lossCounter ++;

				}

			} while ((bet > 0) && (coins > 0));

			System.out.println();

			//The user is left as unfortunate if they run out of money.
			if (coins <= 0) {
				System.out.println("Unfortunately for you, you lost everything!");
			}

			else if ((coins > 0) && (coins <= 100)) {
				System.out.println("Good job! Your final balance is $" + coins + ".");
			}

			//The user is congratulated if they finish with more money than they started out with.
			else {
				System.out.println("Congratulations! Your final balance is $" + coins + "!");
			}

			//The statistics are displayed.
			//Betting $0 counts as a bet in the counter. The counter must be adjusted so that the $0 bet does not count.
			if (bet == 0){
				if ((number1 == number2) && (number2 == number3)) {
					System.out.println("You won a total of " + (winCounter - 1) + " time(s) and lost a total of " + lossCounter + " time(s).");
				}
				else {
					System.out.println("You won a total of " + winCounter + " time(s) and lost a total of " + (lossCounter - 1) + " time(s).");
				}

				System.out.println("You spun the wheel a total of " + (spinCounter - 1) + " time(s)!");
			}
			else {
				System.out.println("You won a total of " + winCounter + " time(s) and lost a total of " + lossCounter + " time(s).");
				System.out.println("You spun the wheel a total of " + spinCounter + " times!");
			}



			System.out.println("You bet a total of $" + totalBet + "!");

			if (coins >= 100) {
				System.out.println("From the start, you won $" + (coins - 100) + "!");
			}

			else {
				System.out.println("From the start, you lost $" + (100 - coins) + "!");
			}
		}

		else {
			System.out.println("You must be at least 19 years of age to play.");
		}
		input.close();
	}

}
