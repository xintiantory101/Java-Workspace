package evaluations;

import java.util.Scanner;

public class WilliamWangPrimeDetector {

	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		System.out.println("Enter any positive integer greater than 1.");
		int number1 = input.nextInt();

		while (number1 <= 1) {
			System.out.println("Please enter a positive integer greater than 1.");
			number1 = input.nextInt();
		}

		int counter = 0;

		for (int i = 2; i <= number1; i++) {
			if ((number1 % i) == 0) {
				counter ++;
			}

			else {
				counter += 0;
			}

		}

		if (counter > 1) {
			System.out.println("The number is a composite number.");
		}

		else {
			System.out.println("The number is a prime number.");
		}
		
		
		System.out.println("Please enter a second positive integer. The number must be greater than 1.");
		int number2 = input.nextInt();

		while (number2 <= 1) {
			System.out.println("Please enter a whole number greater than 1.");
			number2 = input.nextInt();
		}

		System.out.println("Here are all prime numbers up to " +  number2 + ".");
		
		int nextCounter = 0;
	
		for (int j = 2; j <= number2; j ++) {
			for (int k = 2; k <= j; k ++) {
				if ((j % k) == 0) {
					nextCounter ++;
				}
				else {
					nextCounter += 0; 
				}
				if (nextCounter <= 1) {
					System.out.println(j);
				}
			}
			
		}

		
	
		input.close();
		
	}
}


