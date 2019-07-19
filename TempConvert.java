package programs;

import java.util.Scanner;

public class TempConvert {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		double temp = rawTemp();
		String unit = unitRaw();
		String choice = unitConverted(unit);
		double newTemp = 0;
		if (unit.equalsIgnoreCase("celsius") && choice.equalsIgnoreCase("fahrenheit")) {
			newTemp = celsiusToFahrenheit(temp);
		}
		else if (unit.equalsIgnoreCase("celsius") && choice.equalsIgnoreCase("kelvin")) {
			newTemp = celsiusToKelvin(temp);
		}
		else if (unit.equalsIgnoreCase("fahrenheit") && choice.equalsIgnoreCase("celsius")) {
			newTemp = fahrenheitToCelsius(temp);
		}
		else if (unit.equalsIgnoreCase("fahrenheit") && choice.equalsIgnoreCase("kelvin")) {
			newTemp = fahrenheitToKelvin(temp);
		}
		else if (unit.equalsIgnoreCase("kelvin") && choice.equalsIgnoreCase("celsius")) {
			newTemp = kelvinToCelsius(temp);
		}
		else if (unit.equalsIgnoreCase("kelvin") && choice.equalsIgnoreCase("fahrenheit")) {
			newTemp = kelvinToFahrenheit(temp);
		}
		output(temp, unit, choice, newTemp);

	}
	
	public static double rawTemp() {
		System.out.println("Enter the temperature that you wish to convert.");
		double temp = input.nextDouble();
		return temp;
	}
	
	public static String unitRaw() {
		String unit = null;
		do {
			System.out.println("Enter the unit of the temperature (celsius, fahrenheit, or kelvin) that this temperature is in.");
			unit = input.next();
			if (!unit.equalsIgnoreCase("celsius") && !unit.equalsIgnoreCase("fahrenheit") && !unit.equalsIgnoreCase("kelvin")) {
				System.out.println("Invalid Entry");
			}
		} while (!unit.equalsIgnoreCase("celsius") && !unit.equalsIgnoreCase("fahrenheit") && !unit.equalsIgnoreCase("kelvin"));
		return unit;
	}
	
	public static String unitConverted(String unit) {
		String choice = null;
		do {
			System.out.println("Enter a different unit of the temperature (celsius, fahrenheit, or kelvin) that you want to convert the temperature to.");
			choice = input.next();
			if ((!choice.equalsIgnoreCase("celsius") && !choice.equalsIgnoreCase("fahrenheit") && !choice.equalsIgnoreCase("kelvin")) || choice.equalsIgnoreCase(unit)) {
				System.out.println("Invalid Entry");
			}
		} while ((!choice.equalsIgnoreCase("celsius") && !choice.equalsIgnoreCase("fahrenheit") && !choice.equalsIgnoreCase("kelvin")) || choice.equalsIgnoreCase(unit));
		return choice;
	}
	
	public static double celsiusToFahrenheit(double temp) {
		double newTemp = temp*1.8+32;
		return newTemp;
	}
	
	public static double celsiusToKelvin(double temp) {
		double newTemp = temp+273.15;
		return newTemp;
	}
	
	public static double fahrenheitToCelsius(double temp) {
		double newTemp = (temp-32)*5/9;
		return newTemp;
	}
	
	public static double fahrenheitToKelvin(double temp) {
		double newTemp = (temp-32)*5/9+273.15;
		return newTemp;
	}
	
	public static double kelvinToCelsius(double temp) {
		double newTemp = temp-273.15;
		return newTemp;
	}
	
	public static double kelvinToFahrenheit(double temp) {
		double newTemp = (temp-273.15)*1.8+32;
		return newTemp;
	}
	
	public static void output(double temp, String unit, String choice, double newTemp) {
		if (unit.equalsIgnoreCase("celsius") && choice.equalsIgnoreCase("fahrenheit")) {
			System.out.println(temp + " C is equal to " + newTemp + " F.");
		}
		else if (unit.equalsIgnoreCase("celsius") && choice.equalsIgnoreCase("kelvin")) {
			System.out.println(temp + " C is equal to " + newTemp + " K.");
		}
		else if (unit.equalsIgnoreCase("fahrenheit") && choice.equalsIgnoreCase("celsius")) {
			System.out.println(temp + " F is equal to " + newTemp + " C.");
		}
		else if (unit.equalsIgnoreCase("fahrenheit") && choice.equalsIgnoreCase("kelvin")) {
			System.out.println(temp + " F is equal to " + newTemp + " K.");
		}
		else if (unit.equalsIgnoreCase("kelvin") && choice.equalsIgnoreCase("celsius")) {
			System.out.println(temp + " K is equal to " + newTemp + " C.");
		}
		else if (unit.equalsIgnoreCase("kelvin") && choice.equalsIgnoreCase("fahrenheit")) {
			System.out.println(temp + " K is equal to " + newTemp + " F.");
		}
	}
	
}
