package evaluations;

import java.util.Scanner;

public class WilliamWangMastermind {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("You have 10 guesses to guess the letters.");
		System.out.println("Each letter is either 'R', 'G', or 'B'. You must enter capital letters.");
		System.out.println("");
		int number1 = (int) (Math.random()*3+1);
		int number2 = (int) (Math.random()*3+1);
		int number3 = (int) (Math.random()*3+1);
		String colour1;
		String colour2;
		String colour3;
		String guess;
		String guess1;
		String guess2;
		String guess3;
		String answer;
		int answerCounter = 0;
		int guessCounter = 10;
		
		switch (number1) {
		case 1: colour1 = "R"; break;
		case 2: colour1 = "G"; break;
		case 3: colour1 = "B"; break;
		default: colour1 = null; break;
		}
		
		switch (number2) {
		case 1: colour2 = "R"; break;
		case 2: colour2 = "G"; break;
		case 3: colour2 = "B"; break;
		default: colour2 = null; break;
		}
		
		switch (number3) {
		case 1: colour3 = "R"; break;
		case 2: colour3 = "G"; break;
		case 3: colour3 = "B"; break;
		default: colour3 = null; break;
		}
		
		answer = colour1 + colour2 + colour3;
		
		
		do {
			System.out.println("You have " + guessCounter + " guesses left.");
			guessCounter --;
			System.out.println("Enter your guess of the three letters. Write your guess as three consecutive letters, with no spaces.");
			guess = input.next();
			guess1 = guess.substring(0, 1);
			guess2 = guess.substring(1, 2);
			guess3 = guess.substring(2, 3);
			
			if (guess1.equals(colour1)) {
				answerCounter ++;
			}
			
			if (guess2.equals(colour2)) {
				answerCounter ++;
			}
			
			if (guess3.equals(colour3)) {
				answerCounter ++;
			}
			
			System.out.println("You got " + answerCounter + " letter(s) in the correct location.");
			answerCounter = 0;
			
		} while ((guessCounter > 0) && (!guess.equals(answer)));
		
		if (guess.equals(answer)) {
			System.out.println("Hooray! You got the answer!");
		}
		
		else {
			System.out.println("Too bad! You used up all your attempts!");
			System.out.println("The correct answer was " + answer + ".");
		}
		
		input.close();
	}

}
