package evaluations;

import java.util.Scanner;

public class WilliamWangStudentAverage {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter your first name.");
		String firstName = input.next();
		
		System.out.println("Please enter your middle name.");
		String middleName = input.next();
		
		System.out.println("Please enter your last name.");
		String lastName = input.next();
		
		System.out.println("Please enter your first subject name.");
		String subject1 = input.next();
		
		System.out.println("Please enter your second subject name.");
		String subject2 = input.next();
		
		System.out.println("Please enter your third subject name.");
		String subject3 = input.next();
		
		System.out.println("Please enter your fourth subject name.");
		String subject4 = input.next();
		
		System.out.println("Please enter your final " + subject1 + " mark, as a percentage.");
		double mark1 = input.nextDouble();
		
		System.out.println("Please enter your final " + subject2 + " mark, as a percentage.");
		double mark2 = input.nextDouble();
		
		System.out.println("Please enter your final " + subject3 + " mark, as a percentage.");
		double mark3 = input.nextDouble();
		
		System.out.println("Please enter your final " + subject4 + " mark, as a percentage.");
		double mark4 = input.nextDouble();
		
		final double NUMBER_OF_SUBJECTS = 4;
		
		double average = (mark1+mark2+mark3+mark4)/NUMBER_OF_SUBJECTS;
		
		System.out.println(firstName + " " + middleName + " " + lastName + ", your grades are as follows:");
		System.out.println("Your " + subject1 + " mark is " + mark1 + "%.");
		System.out.println("Your " + subject2 + " mark is " + mark2 + "%.");
		System.out.println("Your " + subject3 + " mark is " + mark3 + "%.");
		System.out.println("Your " + subject4 + " mark is " + mark4 + "%.");
		System.out.println("Your overall average mark is " + average + "%.");
		

	}

}
