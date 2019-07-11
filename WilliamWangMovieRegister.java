package evaluations;

import java.util.Scanner;

public class WilliamWangMovieRegister {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Welcome! Please enter your age.");
		int age = input.nextInt();
		
		double ticketCost;
		if ((age <= 12) || (age >= 65)) {
			ticketCost = 8;
		}
		
		else {
			ticketCost = 12;
		}
		
		System.out.println("Would you want to upgrade to AVX or IMAX?");
		System.out.println("Type 1 for AVX, 2 for IMAX, or any other whole number for no upgrade, then press enter.");
		int upgrade1 = input.nextInt();
		
		double upgradeCost1;
		
		if (upgrade1 == 1) {
			upgradeCost1 = 0.25 * ticketCost;
		}
		
		else if (upgrade1 == 2) {
			upgradeCost1 = 0.35 * ticketCost;
		}
		
		else {
			upgradeCost1 = 0;
		}
		
		System.out.println("Do you want a DBOX upgrade for $5?");
		System.out.println("Type 1 for yes or any other whole number for no.");
		int upgrade2 = input.nextInt();
		
		double upgradeCost2;
		
		if (upgrade2 == 1) {
			upgradeCost2 = 5;
		}
		
		
		else {
			upgradeCost2 = 0;
		}
		
		System.out.println("Please select any single menu item from the following the snack list.");
		
		System.out.println("1: Regular French Fries, $3.00");
		System.out.println("2: Poutine, $4.59");
		System.out.println("3: Caesar Salad, $3.50");
		System.out.println("4: Air-Popped Popcorn, $3.00");
		System.out.println("5: 355 mL Pop, $1.29");
		System.out.println("6: 8 Chicken Nuggets, $3.79");
		System.out.println("7: 500 mL Water, $0.89");
		System.out.println("To select your food item, please enter the corresponding number below, or enter a number not on the list if you do not want food.");
		int food = input.nextInt();
		
		double foodCost;
		switch (food) {
		case 1: foodCost = 3.00; break;
		case 2: foodCost = 4.59; break;
		case 3: foodCost = 3.50; break;
		case 4: foodCost = 3.00; break;
		case 5: foodCost = 1.29; break;
		case 6: foodCost = 3.79; break;
		case 7: foodCost = 0.89; break;
		default: foodCost = 0; break;
		
		}
	
		double subtotal = ticketCost + foodCost + upgradeCost1 + upgradeCost2;
		double tax = 0.13 * subtotal;
		double roundedTax = (Math.round(tax * 100.0)) / 100.0;
		double total = subtotal + tax;
		double roundedTotal = (Math.round(total * 100.0)) / 100.0;
		int totalCents = (int) (roundedTotal * 100);
		System.out.println("Your subtotal is $" + subtotal + ".");
		System.out.println("The amount of tax that is added to the subtotal is $" + roundedTax + ".");
		System.out.println("Your total is $" + roundedTotal + ".");
		System.out.println("How much cash are you paying with, as a dollar value?");
		double pay1 = input.nextDouble();
		int payCents1 = (int)(pay1 * 100);
		
		if (pay1 > roundedTotal) {
			int change1 = payCents1 - totalCents;
			int bill100 = (int) (change1 / 10000);
			int leftOver1 = (int) (change1 % 10000);
			int bill50 = leftOver1 / 5000;
			int leftOver2 = leftOver1 % 5000;
			int bill20 = leftOver2 / 2000;
			int leftOver3 = leftOver2 % 2000;
			int bill10 = leftOver3 / 1000;
			int leftOver4 = leftOver3 % 1000;
			int bill5 = leftOver4 / 500;
			int leftOver5 = leftOver4 % 500;
			int toonies = leftOver5 / 200;
			int leftOver6 = leftOver5 % 200;
			int loonies = leftOver6 / 100;
			int leftOver7 = leftOver6 % 100;
			int quarters = leftOver7 / 25;
			int leftOver8 = leftOver7 % 25;
			int dimes = leftOver8 / 10;
			int leftOver9 = leftOver8 % 10;
			int nickels = leftOver9 / 5;
			int leftOver10 = leftOver9 % 5;
			int pennies = leftOver10;
			double change2 = (double) (change1 / 100.0);
			
			System.out.println("Your change is $" + change2 + ".");
			System.out.println("For change, you will receive " + bill100 + " $100 bill(s), " + bill50 + " $50 bill(s), " + bill20 + " $20 bill(s), " + bill10 + " $10 bill(s), " + bill5 + " $5 bill(s), " + toonies + " toonie(s), " + loonies + " loonie(s), " + quarters + " quarter(s), " + dimes + " dime(s), " + nickels + " nickel(s), and " + pennies + " penny(ies).");
			System.out.println("Enjoy your movie!");
		}
		
		else if (pay1 == roundedTotal) {
			System.out.println("Enjoy your movie!");
		}
		
		else {
			double owe = roundedTotal - pay1;
			int oweCents = (int) (owe * 100);
			System.out.println("You still owe $" + owe + ". Please pay the owed amount by cash.");
			double pay2 = input.nextDouble();
			
			int payCents2 = (int) (pay2 * 100);
			
			if (pay2 >= owe) {
				int change1 = (int) (payCents2 - oweCents);
				int bill100 = (int) (change1 / 10000);
				int leftOver1 = (int) (change1 % 10000);
				int bill50 = leftOver1 / 5000;
				int leftOver2 = leftOver1 % 5000;
				int bill20 = leftOver2 / 2000;
				int leftOver3 = leftOver2 % 2000;
				int bill10 = leftOver3 / 1000;
				int leftOver4 = leftOver3 % 1000;
				int bill5 = leftOver4 / 500;
				int leftOver5 = leftOver4 % 500;
				int toonies = leftOver5 / 200;
				int leftOver6 = leftOver5 % 200;
				int loonies = leftOver6 / 100;
				int leftOver7 = leftOver6 % 100;
				int quarters = leftOver7 / 25;
				int leftOver8 = leftOver7 % 25;
				int dimes = leftOver8 / 10;
				int leftOver9 = leftOver8 % 10;
				int nickels = leftOver9 / 5;
				int leftOver10 = leftOver9 % 5;
				int pennies = leftOver10;
				double change2 = (double) (change1 / 100.0);
				System.out.println("Your change is $" + change2 + ".");
				System.out.println("For change, you will receive " + bill100 + " $100 bill(s), " + bill50 + " $50 bill(s), " + bill20 + " $20 bill(s), " + bill10 + " $10 bill(s), " + bill5 + " $5 bill(s), " + toonies + " toonie(s), " + loonies + " loonie(s), " + quarters + " quarter(s), " + dimes + " dime(s), " + nickels + " nickel(s), and " + pennies + " penny(ies).");
				System.out.println("Enjoy your movie!");
				System.out.println("Thank you. Enjoy your movie!");
			}
			
			else {
				System.out.println("Don't worry. We can change and void your order as needed.");
			}
		
		
	}

	}
}
