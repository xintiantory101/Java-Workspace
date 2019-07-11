package programs;

import java.util.Scanner;

public class Skunk {
	
	static Scanner input = new Scanner(System.in);
	static int score = 0;
	static boolean contFlag = true;
	static boolean doubleFlag = false;

	public static void main(String[] args) {
		introduction();
		roll1();
		while (contFlag == true && doubleFlag == false) {
			score();
			if (contFlag == true) {
				roll();
			}
		}
		results();

	}
	
	public static void introduction() {
		System.out.println("Welcome to Skunk!");
		System.out.println("Every time the 2 dice are rolled, the sum of the dice is added to your score.");
		System.out.println("You may then choose whether or not you want to continue playing.");
		System.out.println("If you choose to stop playing, you keep all the points you have earned up to that point.");
		System.out.println("However, if a double is rolled on any roll after the first roll, you lose all your points!");
	}
	
	public static void roll1() {
		int die1 = (int) (Math.random()*6+1);
		int die2 = (int) (Math.random()*6+1);
		int roll = die1 + die2;
		score += roll;
	}
	
	public static void score() {
		String response = null;
		System.out.println("Your score is " + score + ".");
		if (doubleFlag == false) {
			do {
				System.out.println("Do you wish to continue playing? Enter 'yes' or 'no'.");
				response = input.next();
			} while (!response.equals("yes") && !response.equals("no"));
			switch (response) {
			case "yes": contFlag = true; break;
			case "no": contFlag = false; break;
			default: contFlag = false; break;
			}
		}
	}
	
	public static void roll() {
		int die1 = (int) (Math.random()*6+1);
		int die2 = (int) (Math.random()*6+1);
		int roll = die1 + die2;
		if (die1 == die2) {
			doubleFlag = true;
			score = 0;
			System.out.println("The roll is a double! You lose all your points!");
		}
		else {
			score += roll;
			System.out.println("The roll is " + roll + ".");
		}
	}
	
	public static void results() {
		System.out.println("Your final score is " + score + ".");
	}

}
