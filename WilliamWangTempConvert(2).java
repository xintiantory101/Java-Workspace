package evaluations;

import java.util.Scanner;

public class WilliamWangTempConvert {
	
	static Scanner input = new Scanner(System.in);
	static double temperature;
	static double celsius;
	static double fahrenheit;

	public static void main(String[] args) {
		
		String choice = getTemp();
		
		if (choice.equalsIgnoreCase("celsius")) {
			toCelsius();
			
		}
		
		else {
			toFahrenheit();
			
		}
		
	}
	
	public static String getTemp() {
		System.out.println("Please enter your temperature.");
		temperature = input.nextDouble();
		
		System.out.println("Do you want to convert the temperature to Celsius or Fahrenheit?");
		System.out.println("Enter 'celsius' or 'fahrenheit'.");
		String choice = input.next();
		
		while (!choice.equalsIgnoreCase("celsius") && !choice.equalsIgnoreCase("fahrenheit")) {
			System.out.println("Please enter 'celsius' or 'fahrenheit'.");
			choice = input.next();
		}
		
		return choice;
		
	}
	
	public static void toCelsius() {
		celsius = (temperature - 32.0) * 5.0 / 9.0;
		System.out.println("Your temperature of " + temperature + " degree(s) Fahrenheit is equal to " + celsius + " degree(s) Celsius.");
	}
	
	public static void toFahrenheit() {
		fahrenheit = temperature * 9.0 / 5.0 + 32.0;
		System.out.println("Your temperature of " + temperature + " degree(s) Celsius is equal to " + fahrenheit + " degree(s) Fahrenheit.");
	}

}
