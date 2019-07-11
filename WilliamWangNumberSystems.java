package evaluations;

import java.util.Scanner;

/**
 * This program will allow the user to convert between number systems.
 * @author TTW
 *
 */
public class WilliamWangNumberSystems {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		String startSystem = getStartSystem();
		String endSystem = getEndSystem(startSystem);
		directory(startSystem, endSystem);



	}
	
	/**
	 * This method will get the number system of the number that the user will enter
	 * @return
	 */
	public static String getStartSystem() {
		System.out.println("Do you want to enter a value in the decimal, hexadecimal, octal, or binary number system?");
		System.out.println("Enter 'decimal', 'hexadecimal', 'octal', or 'binary'.");
		String choice = input.next();

		//Ensure the user enters a valid choice
		while ((choice.equalsIgnoreCase("decimal") == false) && (choice.equalsIgnoreCase("hexadecimal") == false) && (choice.equalsIgnoreCase("octal") == false) && (choice.equalsIgnoreCase("binary") == false)) {
			System.out.println("Please enter 'decimal', 'hexadecimal', 'octal', or 'binary'.");
			choice = input.next();
		}

		return choice;
	}

	/**
	 * This method will get the number system of the number that will be calculated by the program
	 * @param startSystem
	 * @return
	 */
	public static String getEndSystem(String startSystem) {
		System.out.println("Do you want the program to output the corresponding value in the decimal, hexadecimal, octal, or binary number system?");
		System.out.println("You may not choose the previous number system you entered.");
		System.out.println("Enter 'decimal', 'hexadecimal', 'octal', or 'binary'.");
		String choice = input.next();

		//Ensure the user enters a valid choice
		while (((choice.equalsIgnoreCase("decimal") == false) && (choice.equalsIgnoreCase("hexadecimal") == false) && (choice.equalsIgnoreCase("octal") == false) && (choice.equalsIgnoreCase("binary") == false)) || (choice.equalsIgnoreCase(startSystem))) {
			System.out.println("Please enter 'decimal', 'hexadecimal', 'octal', or 'binary'.");
			System.out.println("The output number system cannot be the same as the input number system.");
			choice = input.next();
		}


		return choice;

	}

	/**
	 * This method will direct the program to the correct method of conversion, based on the user's entry
	 * @param startSystem
	 * @param endSystem
	 */
	public static void directory(String startSystem, String endSystem) {

		if (startSystem.equalsIgnoreCase("decimal")) {

			if (endSystem.equalsIgnoreCase("hexadecimal")) {
				decimalToHexadecimal();
			}

			else if (endSystem.equalsIgnoreCase("octal")) {
				decimalToOctal();
			}

			else if (endSystem.equalsIgnoreCase("binary")) {
				decimalToBinary();
			}

			else {
				System.out.println("Something isn't right.");
			}

		}

		else if (startSystem.equalsIgnoreCase("hexadecimal")) {

			if (endSystem.equalsIgnoreCase("decimal")) {
				hexadecimalToDecimal();
			}

			else if (endSystem.equalsIgnoreCase("octal")) {
				hexadecimalToOctal();
			}

			else if (endSystem.equalsIgnoreCase("binary")) {
				hexadecimalToBinary();
			}

			else {
				System.out.println("Something isn't right.");
			}

		}

		else if (startSystem.equalsIgnoreCase("octal")) {

			if (endSystem.equalsIgnoreCase("hexadecimal")) {
				octalToHexadecimal();
			}

			else if (endSystem.equalsIgnoreCase("decimal")) {
				octalToDecimal();
			}

			else if (endSystem.equalsIgnoreCase("binary")) {
				octalToBinary();
			}

			else {
				System.out.println("Something isn't right.");
			}

		}

		else if (startSystem.equalsIgnoreCase("binary")) {

			if (endSystem.equalsIgnoreCase("hexadecimal")) {
				binaryToHexadecimal();
			}

			else if (endSystem.equalsIgnoreCase("octal")) {
				binaryToOctal();
			}

			else if (endSystem.equalsIgnoreCase("decimal")) {
				binaryToDecimal();
			}

			else {
				System.out.println("Something isn't right.");
			}

		}

		else {
			System.out.println("Something isn't right.");
		}

	}

	/**
	 * This method will convert a user-entered decimal value into its corresponding hexadecimal value
	 */
	public static void decimalToHexadecimal() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars;
		int intNumber;
		int[] modulus;
		int counter = 0;
		int divideCheck;
		char[] symbol;

		//The user will be prompted to re-enter their number if it is not a decimal integer, as many times as needed
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 57)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}

			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not of the decimal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}

		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The hexadecimal value is 0.");
		}

		else {
			//The String decimal entered by the user is converted to an integer
			intNumber = Integer.parseInt(number);
			divideCheck = intNumber;

			//Find the number to set the size of the modulus and symbol arrays (the number of times the decimal value can be divided by 16 before it reaches 0
			while (divideCheck > 0) {
				divideCheck /= 16;
				counter ++;


			}

			//The array containing the remainders of the repeated division of the user-entered value by 16 and the array containing the symbols for the digits and letters in the hexadecimal value are initialized
			modulus = new int[counter];
			symbol = new char[counter];

			//Continue dividing the number by 16 and taking the remainders of the value until the number gets to 0
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = intNumber % 16;
				intNumber /= 16;

			}

			//Set symbols according to the hexadecimal system
			for (int i = 0; i < symbol.length; i ++) {

				switch (modulus[i]) {
				case 0: symbol[i] = 48; break;
				case 1: symbol[i] = 49; break;
				case 2: symbol[i] = 50; break;
				case 3: symbol[i] = 51; break;
				case 4: symbol[i] = 52; break;
				case 5: symbol[i] = 53; break;
				case 6: symbol[i] = 54; break;
				case 7: symbol[i] = 55; break;
				case 8: symbol[i] = 56; break;
				case 9: symbol[i] = 57; break;
				case 10: symbol[i] = 65; break;
				case 11: symbol[i] = 66; break;
				case 12: symbol[i] = 67; break;
				case 13: symbol[i] = 68; break;
				case 14: symbol[i] = 69; break;
				case 15: symbol[i] = 70; break;
				default: System.out.println("Something isn't right."); break;
				}
			}

			//Output the hexadecimal value
			System.out.print("The hexadecimal value is ");
			for (int i = 0; i < symbol.length; i ++) {
				System.out.print(symbol[i]);
			}
			
			System.out.print(".");

		}
	}

	/**
	 * This method will convert a user-entered decimal value into its corresponding octal value
	 */
	public static void decimalToOctal() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars;
		int intNumber;
		int[] modulus;
		int counter = 0;
		int divideCheck;

		//The user will be prompted to re-enter their number if it is not a decimal integer, as many times as needed
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 57)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}

			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not of the decimal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The octal value is 0.");
		}

		else {
			//The String decimal entered by the user is converted to an integer
			intNumber = Integer.parseInt(number);
			divideCheck = intNumber;

			//Find the number to set the size of the modulus and symbol arrays (the number of times the decimal value can be divided by 8 before it reaches 0
			while (divideCheck > 0) {
				divideCheck /= 8;
				counter ++;


			}

			//The array containing the remainders of the repeated division of the user-entered value by 8 is initialized
			modulus = new int[counter];

			//Continue dividing the number by 8 and taking the remainders of the value until the number gets to 0
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = intNumber % 8;
				intNumber /= 8;

			}

			//Output the digits in the modulus array
			System.out.print("The octal value is ");
			for (int i = 0; i < counter; i ++) {
				System.out.print(modulus[i]);
			}

			System.out.print(".");
		}
	}

	/**
	 * This method will convert a user-entered decimal value into its corresponding binary value
	 */
	public static void decimalToBinary() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars;
		int intNumber;
		int[] modulus;
		int counter = 0;
		int divideCheck;

		//The user will be prompted to re-enter their number if it is not a decimal integer, as many times as needed
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 57)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}

			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not of the decimal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The binary value is 0.");
		}

		else {
			//The String decimal entered by the user is converted to an integer
			intNumber = Integer.parseInt(number);
			divideCheck = intNumber;

			//Find the number to set the size of the modulus and symbol arrays (the number of times the decimal value can be divided by 2 before it reaches 0
			while (divideCheck > 0) {
				divideCheck /= 2;
				counter ++;


			}

			//The array containing the remainders of the repeated division of the user-entered value by 2 is initialized
			modulus = new int[counter];

			//Continue dividing the number by 2 and taking the remainders of the value until the number gets to 0
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = intNumber % 2;
				intNumber /= 2;

			}

			//Output the digits in the modulus array
			System.out.print("The binary value is ");
			for (int i = 0; i < counter; i ++) {
				System.out.print(modulus[i]);
			}
			
			System.out.print(".");
		}


	}

	/**
	 * This method will convert a user-entered hexadecimal value to its corresponding decimal value
	 */
	public static void hexadecimalToDecimal() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] answer;
		int finalAnswer = 0;

		//The user will be prompted to re-enter their number if it is not a hexadecimal value
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 102)) {
					errorCounter ++;
				}

				else if ((numberInChars[i] > 57) && (numberInChars[i] < 65)) {
					errorCounter ++;
				}

				else if ((numberInChars[i] > 70) && (numberInChars[i] < 97)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}

			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the hexadecimal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The decimal value is 0.");
		}

		else {
			//Initialize the arrays for the final answer and the integer values of the numbers in the character array
			intValue = new int[numberInChars.length];
			answer = new int[numberInChars.length];

			//Convert the characters from the character array to integer values
			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				case 50: intValue[i] = 2; break;
				case 51: intValue[i] = 3; break;
				case 52: intValue[i] = 4; break;
				case 53: intValue[i] = 5; break;
				case 54: intValue[i] = 6; break;
				case 55: intValue[i] = 7; break;
				case 56: intValue[i] = 8; break;
				case 57: intValue[i] = 9; break;
				case 65: intValue[i] = 10; break;
				case 66: intValue[i] = 11; break;
				case 67: intValue[i] = 12; break;
				case 68: intValue[i] = 13; break;
				case 69: intValue[i] = 14; break;
				case 70: intValue[i] = 15; break;
				case 97: intValue[i] = 10; break;
				case 98: intValue[i] = 11; break;
				case 99: intValue[i] = 12; break;
				case 100: intValue[i] = 13; break;
				case 101: intValue[i] = 14; break;
				case 102: intValue[i] = 15; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to get the final answer and incorporate into the 'answer' array
				answer[i] = (intValue[i] * ((int) (Math.pow(16, (answer.length - 1 - i)))));


			}

			//Add the values from the 'answer' array to get the final answer
			for (int i = 0; i < answer.length; i ++) {
				finalAnswer += answer[i];
			}

			//Output the final answer
			System.out.println("The decimal value is " + finalAnswer + ".");
		}

	}

	/**
	 * This method will convert a user-entered hexadecimal value to its corresponding octal value
	 */
	public static void hexadecimalToOctal() {
		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] decimal;
		int decimalValue = 0;
		int divideCheck;
		int counter = 0;
		int[] modulus;

		//The user will be prompted to re-enter their number if it is not a hexadecimal value
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 102)) {
					errorCounter ++;
				}

				else if ((numberInChars[i] > 57) && (numberInChars[i] < 65)) {
					errorCounter ++;
				}

				else if ((numberInChars[i] > 70) && (numberInChars[i] < 97)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}

			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the hexadecimal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The octal value is 0.");
		}

		else {
			//Initialize the arrays for the decimal value and the integer values of the numbers in the character array
			intValue = new int[numberInChars.length];
			decimal = new int[numberInChars.length];

			//Convert the characters from the character array to integer values
			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				case 50: intValue[i] = 2; break;
				case 51: intValue[i] = 3; break;
				case 52: intValue[i] = 4; break;
				case 53: intValue[i] = 5; break;
				case 54: intValue[i] = 6; break;
				case 55: intValue[i] = 7; break;
				case 56: intValue[i] = 8; break;
				case 57: intValue[i] = 9; break;
				case 65: intValue[i] = 10; break;
				case 66: intValue[i] = 11; break;
				case 67: intValue[i] = 12; break;
				case 68: intValue[i] = 13; break;
				case 69: intValue[i] = 14; break;
				case 70: intValue[i] = 15; break;
				case 97: intValue[i] = 10; break;
				case 98: intValue[i] = 11; break;
				case 99: intValue[i] = 12; break;
				case 100: intValue[i] = 13; break;
				case 101: intValue[i] = 14; break;
				case 102: intValue[i] = 15; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				decimal[i] = (intValue[i] * ((int) (Math.pow(16, (decimal.length - 1 - i)))));


			}

			//Add up the numbers from the 'decimal' array to obtain the decimal value
			for (int i = 0; i < decimal.length; i ++) {
				decimalValue += decimal[i];
			}

			//Initialize the variable to check the number of times the decimal value can be divided by 8 before it reaches 0
			divideCheck = decimalValue;

			//Count the number of times the decimal value can be divided by 8 before it gets to 0
			while (divideCheck > 0) {
				divideCheck /= 8;
				counter ++;


			}

			//There should be exactly as many remainders as the number of times the decimal value can be divided by 8 before it gets to 0
			modulus = new int[counter];

			//Take the remainder of the decimal value when divided by 8 and populate the modulus into the 'modulus' array
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = decimalValue % 8;
				decimalValue /= 8;

			}

			//Output the octal value as individual digits on the same line
			System.out.print("The octal value is ");
			for (int i = 0; i < counter; i ++) {
				System.out.print(modulus[i]);
			}
			
			System.out.print(".");
		}



	}

	/**
	 * This method will convert a user-entered hexadecimal value to its corresponding binary value
	 */
	public static void hexadecimalToBinary() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] decimal;
		int decimalValue = 0;
		int divideCheck;
		int counter = 0;
		int[] modulus;

		//The user will be prompted to re-enter their number if it is not a hexadecimal value
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 102)) {
					errorCounter ++;
				}

				else if ((numberInChars[i] > 57) && (numberInChars[i] < 65)) {
					errorCounter ++;
				}

				else if ((numberInChars[i] > 70) && (numberInChars[i] < 97)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}
			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the hexadecimal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The binary value is 0.");
		}

		else {
			//Initialize the arrays for the decimal value and the integer values of the numbers in the character array
			intValue = new int[numberInChars.length];
			decimal = new int[numberInChars.length];

			//Convert the characters from the character array to integer values
			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				case 50: intValue[i] = 2; break;
				case 51: intValue[i] = 3; break;
				case 52: intValue[i] = 4; break;
				case 53: intValue[i] = 5; break;
				case 54: intValue[i] = 6; break;
				case 55: intValue[i] = 7; break;
				case 56: intValue[i] = 8; break;
				case 57: intValue[i] = 9; break;
				case 65: intValue[i] = 10; break;
				case 66: intValue[i] = 11; break;
				case 67: intValue[i] = 12; break;
				case 68: intValue[i] = 13; break;
				case 69: intValue[i] = 14; break;
				case 70: intValue[i] = 15; break;
				case 97: intValue[i] = 10; break;
				case 98: intValue[i] = 11; break;
				case 99: intValue[i] = 12; break;
				case 100: intValue[i] = 13; break;
				case 101: intValue[i] = 14; break;
				case 102: intValue[i] = 15; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				decimal[i] = (intValue[i] * ((int) (Math.pow(16, (decimal.length - 1 - i)))));


			}

			//Add up the numbers from the 'decimal' array to obtain the decimal value
			for (int i = 0; i < decimal.length; i ++) {
				decimalValue += decimal[i];
			}

			//Initialize the variable to check the number of times the decimal value can be divided by 2 before it reaches 0
			divideCheck = decimalValue;

			//Count the number of times the decimal value can be divided by 2 before it gets to 0
			while (divideCheck > 0) {
				divideCheck /= 2;
				counter ++;


			}

			//There should be exactly as many remainders as the number of times the decimal value can be divided by 2 before it gets to 0
			modulus = new int[counter];

			//Take the remainder of the decimal value when divided by 2 and populate the modulus into the 'modulus' array
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = decimalValue % 2;
				decimalValue /= 2;

			}

			//Output the binary value as individual digits on the same line
			System.out.print("The binary value is ");
			for (int i = 0; i < counter; i ++) {
				System.out.print(modulus[i]);
			}
			
			System.out.print(".");
		}


	}

	/**
	 * This method will convert a user-entered octal value to its corresponding hexadecimal value
	 */
	public static void octalToHexadecimal() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] decimal;
		int decimalValue = 0;
		int divideCheck;
		int counter = 0;
		int[] modulus;
		char[] symbol;

		//The user will be prompted to re-enter their number if it is not an octal value
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 55)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}
			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the octal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The hexadecimal value is 0.");
		}

		else {
			//Initialize the arrays for the conversion from the character array to the corresponding integer values of the user-entered number and array that contains the numbers that need to be added to obtain the decimal value 
			intValue = new int[numberInChars.length];
			decimal = new int[numberInChars.length];
			
			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				case 50: intValue[i] = 2; break;
				case 51: intValue[i] = 3; break;
				case 52: intValue[i] = 4; break;
				case 53: intValue[i] = 5; break;
				case 54: intValue[i] = 6; break;
				case 55: intValue[i] = 7; break;
				case 56: intValue[i] = 8; break;
				case 57: intValue[i] = 9; break;
				case 65: intValue[i] = 10; break;
				case 66: intValue[i] = 11; break;
				case 67: intValue[i] = 12; break;
				case 68: intValue[i] = 13; break;
				case 69: intValue[i] = 14; break;
				case 70: intValue[i] = 15; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				decimal[i] = (intValue[i] * ((int) (Math.pow(16, (decimal.length - 1 - i)))));


			}
			
			//Add up the numbers from the 'decimal' array to obtain the decimal value
			for (int i = 0; i < decimal.length; i ++) {
				decimalValue += decimal[i];
			}

			//Initialize the variable to count the number of times the decimal value can be divided by 16 before reaching 0
			divideCheck = decimalValue;

			//Count the number of times the decimal value can be divided by 16 before it reaches 0
			while (divideCheck > 0) {
				divideCheck /= 16;
				counter ++;


			}

			//The arrays for the remainder of the continuous division of the decimal value by 16 and the symbols in the hexadecimal value are initialized
			modulus = new int[counter];
			symbol = new char[counter];

			//Populate the 'modulus' array with the remainders of the repeated division of the decimal value by 16
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = decimalValue % 16;
				decimalValue /= 16;

			}

			//Replace the remainders with symbols by populating the 'symbol' array with appropriate ASCII symbols
			//Note that remainders 10 through 15 take letters A through F
			for (int i = 0; i < counter; i ++) {

				switch (modulus[i]) {
				case 0: symbol[i] = 48; break;
				case 1: symbol[i] = 49; break;
				case 2: symbol[i] = 50; break;
				case 3: symbol[i] = 51; break;
				case 4: symbol[i] = 52; break;
				case 5: symbol[i] = 53; break;
				case 6: symbol[i] = 54; break;
				case 7: symbol[i] = 55; break;
				case 8: symbol[i] = 56; break;
				case 9: symbol[i] = 57; break;
				case 10: symbol[i] = 65; break;
				case 11: symbol[i] = 66; break;
				case 12: symbol[i] = 67; break;
				case 13: symbol[i] = 68; break;
				case 14: symbol[i] = 69; break;
				case 15: symbol[i] = 70; break;
				default: System.out.println("Something went wrong."); break;
				}

			}

			//Output the hexadecimal value
			System.out.print("The hexadecimal value is ");
			for (int i = 0; i < symbol.length; i ++) {
				System.out.print(symbol[i]);
			}
			
			System.out.print(".");
		}



	}

	/**
	 * This method will convert a user-entered octal value to its corresponding decimal value
	 */
	public static void octalToDecimal() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] answer;
		int finalAnswer = 0;

		//The user will be prompted to re-enter their number if it is not an octal value
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 55)) {
					errorCounter ++;
				}


				else {
					errorCounter += 0;
				}
			}
			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the octal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The decimal value is 0.");
		}

		else {
			//Initialize the arrays for the conversion from the character array to the corresponding integer values of the user-entered number and array that contains the numbers that need to be added to obtain the decimal value 
			intValue = new int[numberInChars.length];
			answer = new int[numberInChars.length];

			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				case 50: intValue[i] = 2; break;
				case 51: intValue[i] = 3; break;
				case 52: intValue[i] = 4; break;
				case 53: intValue[i] = 5; break;
				case 54: intValue[i] = 6; break;
				case 55: intValue[i] = 7; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				answer[i] = (intValue[i] * ((int) (Math.pow(8, (answer.length - 1 - i)))));


			}
			
			//Add up the numbers from the 'decimal' array to obtain the decimal value
			for (int i = 0; i < answer.length; i ++) {
				finalAnswer += answer[i];
			}

			//Output the decimal value
			System.out.println("The decimal value is " + finalAnswer + ".");
		}

	}

	/**
	 * This method will convert a user-entered octal value to its corresponding binary value
	 */
	public static void octalToBinary() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] decimal;
		int decimalValue = 0;
		int divideCheck;
		int counter = 0;
		int[] modulus;

		//The user will be prompted to re-enter their number if it is not an octal value
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] < 48) || (numberInChars[i] > 55)) {
					errorCounter ++;
				}


				else {
					errorCounter += 0;
				}
			}
			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the octal system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;
		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The binary value is 0.");
		}

		else {
			//Initialize the arrays for the conversion from the character array to the corresponding integer values of the user-entered number and array that contains the numbers that need to be added to obtain the decimal value 
			intValue = new int[numberInChars.length];
			decimal = new int[numberInChars.length];

			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				case 50: intValue[i] = 2; break;
				case 51: intValue[i] = 3; break;
				case 52: intValue[i] = 4; break;
				case 53: intValue[i] = 5; break;
				case 54: intValue[i] = 6; break;
				case 55: intValue[i] = 7; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				decimal[i] = (intValue[i] * ((int) (Math.pow(8, (decimal.length - 1 - i)))));


			}
			
			//Add up the numbers from the 'decimal' array to obtain the decimal value
			for (int i = 0; i < decimal.length; i ++) {
				decimalValue += decimal[i];
			}

			//Initialize the variable to count the number of times the decimal value can be divided by 2 before reaching 0
			divideCheck = decimalValue;

			//Count the number of times the decimal value can be divided by 2 before it reaches 0
			while (divideCheck > 0) {
				divideCheck /= 2;
				counter ++;
			}

			//The array containing the remainders of the repeated division of the user-entered value by 2 is initialized
			modulus = new int[counter];

			//Populate the 'modulus' array with the remainders of the repeated division of the decimal value
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = decimalValue % 2;
				decimalValue /= 2;
			}

			//Output the binary value
			System.out.print("The binary value is ");
			for (int i = 0; i < modulus.length; i ++) {
				System.out.print(modulus[i]);
			}
			
			System.out.print(".");
		}



	}

	/**
	 * This method will convert a user-entered binary value to its corresponding hexadecimal value
	 */
	public static void binaryToHexadecimal() {
		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] decimal;
		int decimalValue = 0;
		int divideCheck;
		char[] symbol;
		int[] modulus;
		int counter = 0;

		//The user will be prompted to re-enter their number if it is not of the binary number system
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] != 48) && (numberInChars[i] != 49)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}
			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the binary system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;

		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The hexadecimal value is 0.");
		}

		else {
			//Initialize the arrays for the conversion from the character array to the corresponding integer values of the user-entered number and array that contains the numbers that need to be added to obtain the decimal value 
			intValue = new int[numberInChars.length];
			decimal = new int[numberInChars.length];

			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				decimal[i] = (intValue[i] * ((int) (Math.pow(2, (decimal.length - 1 - i)))));


			}

			//Add up the numbers from the 'decimal' array to obtain the decimal value
			for (int i = 0; i < decimal.length; i ++) {
				decimalValue += decimal[i];
			}

			//Initialize the variable to count the number of times the decimal value can be divided by 16 before reaching 0
			divideCheck = decimalValue;

			//Count the number of times the decimal value can be divided by 16 before it reaches 0
			while (divideCheck > 0) {
				divideCheck /= 16;
				counter ++;
			}

			//The arrays for the remainder of the continuous division of the decimal value by 16 and the symbols in the hexadecimal value are initialized
			modulus = new int[counter];
			symbol = new char[counter];

			//Populate the 'modulus' array with the remainders of the repeated division of the decimal value by 16
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = decimalValue % 16;
				decimalValue /= 16;
			}

			//Replace the remainders with symbols by populating the 'symbol' array with appropriate ASCII symbols
			//Note that remainders 10 through 15 take letters A through F
			for (int i = 0; i < symbol.length; i ++) {

				switch (modulus[i]) {
				case 0: symbol[i] = 48; break;
				case 1: symbol[i] = 49; break;
				case 2: symbol[i] = 50; break;
				case 3: symbol[i] = 51; break;
				case 4: symbol[i] = 52; break;
				case 5: symbol[i] = 53; break;
				case 6: symbol[i] = 54; break;
				case 7: symbol[i] = 55; break;
				case 8: symbol[i] = 56; break;
				case 9: symbol[i] = 57; break;
				case 10: symbol[i] = 65; break;
				case 11: symbol[i] = 66; break;
				case 12: symbol[i] = 67; break;
				case 13: symbol[i] = 68; break;
				case 14: symbol[i] = 69; break;
				case 15: symbol[i] = 70; break;
				default: System.out.println("Something went wrong."); break;
				}

			}

			//Output the hexadecimal value
			System.out.print("The hexadecimal value is ");
			for (int i = 0; i < symbol.length; i ++) {
				System.out.print(symbol[i]);
			}
			
			System.out.print(".");
		}


	}

	/**
	 * This method will convert a user-entered binary value to its corresponding octal value
	 */
	public static void binaryToOctal() {

		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] decimal;
		int decimalValue = 0;
		int counter = 0;
		int[] modulus;
		int divideCheck;

		//The user will be prompted to re-enter their number if it is not of the binary system
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] != 48) && (numberInChars[i] != 49)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}
			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the binary system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;

		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The octal value is 0.");
		}

		else {
			//Initialize the arrays for the conversion from the character array to the corresponding integer values of the user-entered number and array that contains the numbers that need to be added to obtain the decimal value 
			intValue = new int[numberInChars.length];
			decimal = new int[numberInChars.length];

			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				decimal[i] = (intValue[i] * ((int) (Math.pow(2, (decimal.length - 1 - i)))));


			}

			//Add up the numbers that need to be added to obtain the decimal value
			for (int i = 0; i < decimal.length; i ++) {
				decimalValue += decimal[i];
			}

			//Initialize the variable to count the number of times the decimal value can be divided by 8 before reaching 0
			divideCheck = decimalValue;

			//Count the number of times the decimal value can be divided by 8 before it reaches 0
			while (divideCheck > 0) {
				divideCheck /= 8;
				counter ++;
			}

			//There should be exactly as many remainders as the number of times the decimal value can be divided before it gets to 0
			modulus = new int[counter];

			//Populate the 'modulus' array with the remainders of the repeated division of the decimal value
			for (int i = (counter - 1); i >= 0; i --) {
				modulus[i] = decimalValue % 8;
				decimalValue /= 8;
			}

			//Output the octal value
			System.out.print("The octal value is ");
			for (int i = 0; i < counter; i ++) {
				System.out.print(modulus[i]);
			}
			
			System.out.print(".");
		}


	}

	/**
	 * This method will convert a user-entered binary value to its corresponding decimal value
	 */
	public static void binaryToDecimal() {
		boolean errorFlag = true;
		int errorCounter = 0;
		String number = null;
		char[] numberInChars = null;
		int[] intValue;
		int[] answer;
		int finalAnswer = 0;

		//The user will be prompted to re-enter their number if it is not of the binary system
		while (errorFlag == true) {
			System.out.println("Enter a number.");
			number = input.next();
			numberInChars = number.toCharArray();
			
			//Count up the number of errors in the user's entry
			for (int i = 0; i < numberInChars.length; i ++) {
				if ((numberInChars[i] != 48) && (numberInChars[i] != 49)) {
					errorCounter ++;
				}

				else {
					errorCounter += 0;
				}
			}
			//If there are any errors, the user must re-enter their number
			if (errorCounter > 0) {
				System.out.println("Your number is not part of the binary system.");
				errorFlag = true;
			}

			else {
				errorFlag = false;
			}

			errorCounter = 0;

		}
		//A value of 0 entered in any number system is equal to 0 in any other number system
		if (number.equals("0")) {
			System.out.println("The decimal value is 0.");
		}

		else {
			//Initialize the arrays for the conversion from the character array to the corresponding integer values of the user-entered number and array that contains the numbers that need to be added to obtain the decimal value 
			intValue = new int[numberInChars.length];
			answer = new int[numberInChars.length];

			for (int i = 0; i < numberInChars.length; i ++) {

				switch (numberInChars[i]) {
				case 48: intValue[i] = 0; break;
				case 49: intValue[i] = 1; break;
				default: System.out.println("Something went wrong."); break;
				}

				//Calculate the numbers that need to be added to obtain the decimal value
				answer[i] = (intValue[i] * ((int) (Math.pow(2, (answer.length - 1 - i)))));


			}

			//Add up the numbers from the 'decimal' array to obtain the decimal value
			for (int i = 0; i < answer.length; i ++) {
				finalAnswer += answer[i];
			}
			
			//Output the decimal value
			System.out.println("The decimal value is " + finalAnswer + ".");
		}


	}

}
