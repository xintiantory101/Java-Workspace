package programs;

import java.util.Scanner;
import java.util.Arrays;

public class Stats {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int number = numberOfTerms();
		double[] terms = terms(number);
		stats(terms);

	}
	
	public static int numberOfTerms() {
		int number = 0;
		do {
			System.out.println("Enter the number of terms.");
			number = input.nextInt();
			if (number < 1) {
				System.out.println("There must be at least 1 term.");
			}
		} while (number < 1);
		return number;
	}
	
	public static double[] terms(int number) {
		double[] terms = new double[number];
		for (int i = 0; i < terms.length; i ++) {
			System.out.println("Enter term " + (i+1) + ".");
			terms[i] = input.nextDouble();
		}
		Arrays.sort(terms);
		return terms;
	}
	
	public static void stats(double[] terms) {
		System.out.println("Here are your terms in increasing order.");
		for (int i = 0; i < terms.length; i ++) {
			System.out.print(terms[i] + ", ");
		}
		System.out.println();
		double sum = 0;
		for (int i = 0; i < terms.length; i ++) {
			sum += terms[i];
		}
		double mean = sum/terms.length;
		double median = 0;
		if (terms.length % 2 != 0) {
			median = terms[(terms.length+1)/2-1];
		}
		else {
			median = terms[(((terms.length+1)/2-1)+(terms.length+1)/2)/2];
		}
		double sqDev = 0;
		for (int i = 0; i < terms.length; i ++) {
			sqDev += Math.pow(terms[i]-mean, 2);
		}
		double stDev = Math.sqrt(sqDev/terms.length);
		System.out.println("The mean is " + mean + ".");
		System.out.println("The median is " + median + ".");
		System.out.println("The standard deviation is " + stDev + ".");
		if (mean == median) {
			System.out.println("The data is symmetrical, or normally distributed.");
		}
		else if (mean < median) {
			System.out.println("The data is negatively skewed.");
		}
		else {
			System.out.println("The data is positively skewed.");
		}
	}

}
