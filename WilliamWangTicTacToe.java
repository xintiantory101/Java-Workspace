//Author: William Wang
//Date: June 16, 2017
package evaluations;

import java.util.Scanner;

/**
 * This program will pit man vs machine in a game of tic tac toe!
 * @author TTW_2
 *
 */
public class WilliamWangTicTacToe {
	
	static Scanner input = new Scanner(System.in);
	static char computerMarker, userMarker;
	static char[][] board, boardNumbers;

	public static void main(String[] args) {
		String choice = getUserChoice();
		setMarkersAndBoard(choice);
		computerTurn1();
		int userLocation1 = userTurn1();
		computerTurn2(userLocation1);
		int userLocation2 = userTurn2();
		boolean winFlag1 = computerTurn3(userLocation1, userLocation2);
		int userLocation3, userLocation4;
		boolean winFlag2, winFlag3;
		//If a player gets three in a row, the game is over
		if (winFlag1 == true) {
			results();
		}
		else if (winFlag1 == false) {
			userLocation3 = userTurn3();
			winFlag2 = computerTurn4(userLocation1, userLocation2, userLocation3);
			if (winFlag2 == true) {
				results();
			}
			else if (winFlag2 == false) {
				userLocation4 = userTurn4();
				winFlag3 = computerTurn5(userLocation1, userLocation2, userLocation3, userLocation4);
				results(winFlag3);
			}
		}
	}
	
	/**
	 * This method allows the user to choose their marker on the board
	 * @return
	 */
	public static String getUserChoice() {
		System.out.println("Do you want your marker to be 'x' or 'o'?");
		System.out.println("Enter 'x' or 'o'.");
		String choice = input.next();
		//Error check to ensure that the user chooses a valid marker
		while ((!choice.equalsIgnoreCase("x")) && (!choice.equalsIgnoreCase("o"))) {
			System.out.println("Enter 'x' or 'o'.");
			choice = input.next();
		}
		return choice;
	}
	
	/**
	 * This method sets up the markers and the board, and introduces the user to the game
	 * @param choice
	 */
	public static void setMarkersAndBoard(String choice) {
		//The computer's marker is based on the user's marker choice
		//If the user chooses 'x', the computer must be 'o', and vice versa
		if (choice.equalsIgnoreCase("x")) {
			userMarker = 'x';
			computerMarker = 'o';
		}
		else if (choice.equalsIgnoreCase("o")) {
			userMarker = 'o';
			computerMarker = 'x';
		}
		else {
			System.out.println("ERROR");
		}
		//Initialize the game board and the display board
		board = new char[3][3];
		boardNumbers = new char[3][3];
		System.out.println("Here is the tic tac toe game board:");
		//Display the empty game board
		System.out.println("-----------");
		for (int i = 0; i < boardNumbers[0].length; i ++) {
			for (int j = 0; j < boardNumbers.length; j ++) {
				System.out.print(boardNumbers[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		System.out.println("The computer will go first.");
		System.out.println("On your turn, to select where you want to place your marker, simply enter the corresponding number on the squre, as shown in the diagram below.");
		char counter = 49;
		//Display the game board with numbers in the squares from 1 to 9 (ASCII values 49 to 57)
		System.out.println("-----------");
		for (int i = 0; i < boardNumbers[0].length; i ++) {
			for (int j = 0; j < boardNumbers.length; j ++) {
				boardNumbers[i][j] = counter;
				counter ++;
				System.out.print(boardNumbers[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		System.out.println("The first player to land 3 markers in a row horizontally, vertically, or diagonally is the winner!");
	}
	
	/**
	 * This method runs through the computer's first turn
	 */
	public static void computerTurn1() {
		System.out.println("It is now the computer's turn.");
		//The best strategy is for the contestant that goes first to place their marker in the centre
		board[1][1] = computerMarker;
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
	}
	
	/**
	 * This method runs through the user's first turn
	 * @return
	 */
	public static int userTurn1() {
		boolean vacancyFlag = false;
		System.out.println("It is now your turn.");
		int location;
		//The user may not place a marker on the centre square, as it is already taken
		//In the event the user selects the centre square, they must select another square
		do {
			System.out.println("Enter the location where you want to place your marker.");
			System.out.println("You must place your marker on a vacant square.");
			location = input.nextInt();
			switch (location) {
			case 1: vacancyFlag = true; break;
			case 2: vacancyFlag = true; break;
			case 3: vacancyFlag = true; break;
			case 4: vacancyFlag = true; break;
			case 5: vacancyFlag = false; break;
			case 6: vacancyFlag = true; break;
			case 7: vacancyFlag = true; break;
			case 8: vacancyFlag = true; break;
			case 9: vacancyFlag = true; break;
			default: vacancyFlag = false; break;
			}
		} while (vacancyFlag == false);
		//Place the user's marker at the corresponding location
		switch (location) {
		case 1: board[0][0] = userMarker; break;
		case 2: board[0][1] = userMarker; break;
		case 3: board[0][2] = userMarker; break;
		case 4: board[1][0] = userMarker; break;
		case 6: board[1][2] = userMarker; break;
		case 7: board[2][0] = userMarker; break;
		case 8: board[2][1] = userMarker; break;
		case 9: board[2][2] = userMarker; break;
		default: System.out.println("ERROR"); break;
		}
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		return location;
	}
	
	/**
	 * This method runs through the computer's second turn
	 * @param userLocation1
	 */
	public static void computerTurn2(int userLocation1) {
		System.out.println("It is now the computer's turn.");
		//The computer will strategically place its marker
		switch (userLocation1) {
		case 1: board[0][2] = computerMarker; break;
		case 2: board[0][2] = computerMarker; break;
		case 3: board[0][0] = computerMarker; break;
		case 4: board[0][0] = computerMarker; break;
		case 6: board[0][2] = computerMarker; break;
		case 7: board[0][0] = computerMarker; break;
		case 8: board[2][0] = computerMarker; break;
		case 9: board[0][2] = computerMarker; break;
		default: System.out.println("ERROR"); break;
		}
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
	}
	
	/**
	 * This method runs through the user's second turn
	 * @return
	 */
	public static int userTurn2() {
		boolean vacancyFlag = false;
		System.out.println("It is now your turn.");
		int location;
		//The user cannot place their marker on an occupied square
		//Error check to ensure that the user chooses a valid location
		do {
			System.out.println("Enter the location where you want to place your marker.");
			System.out.println("You must place your marker on a vacant square.");
			location = input.nextInt();
			if (location == 1) {
				if ((board[0][0] == 'x') || (board[0][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 2) {
				if ((board[0][1] == 'x') || (board[0][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 3) {
				if ((board[0][2] == 'x') || (board[0][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 4) {
				if ((board[1][0] == 'x') || (board[1][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 5) {
				if ((board[1][1] == 'x') || (board[1][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 6) {
				if ((board[1][2] == 'x') || (board[1][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 7) {
				if ((board[2][0] == 'x') || (board[2][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 8) {
				if ((board[2][1] == 'x') || (board[2][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 9) {
				if ((board[2][2] == 'x') || (board[2][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else {
				vacancyFlag = false;
			}
		} while (vacancyFlag == false);
		//Place the user's marker at the corresponding square
		switch (location) {
		case 1: board[0][0] = userMarker; break;
		case 2: board[0][1] = userMarker; break;
		case 3: board[0][2] = userMarker; break;
		case 4: board[1][0] = userMarker; break;
		case 6: board[1][2] = userMarker; break;
		case 7: board[2][0] = userMarker; break;
		case 8: board[2][1] = userMarker; break;
		case 9: board[2][2] = userMarker; break;
		default: System.out.println("ERROR"); break;
		}
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		return location;
	}
	
	/**
	 * This method runs through the computer's third turn
	 * @param userLocation1
	 * @param userLocation2
	 * @return
	 */
	public static boolean computerTurn3(int userLocation1, int userLocation2) {
		boolean winFlag = false;
		System.out.println("It is now the computer's turn.");
		//The computer will place its marker strategically, according to the user's previous turns
		if (userLocation1 == 1) {
			switch (userLocation2) {
			case 2: board[2][0] = computerMarker; winFlag = true; break;
			case 4: board[2][0] = computerMarker; winFlag = true; break;
			case 6: board[2][0] = computerMarker; winFlag = true; break;
			case 7: board[1][0] = computerMarker; break;
			case 8: board[2][0] = computerMarker; winFlag = true; break;
			case 9: board[2][0] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 2) {
			switch (userLocation2) {
			case 1: board[2][0] = computerMarker; winFlag = true; break;
			case 4: board[2][0] = computerMarker; winFlag = true; break;
			case 6: board[2][0] = computerMarker; winFlag = true; break;
			case 7: board[2][2] = computerMarker; break;
			case 8: board[2][0] = computerMarker; winFlag = true; break;
			case 9: board[2][0] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 3) {
			switch (userLocation2) {
			case 2: board[2][2] = computerMarker; winFlag = true; break;
			case 4: board[2][2] = computerMarker; winFlag = true; break;
			case 6: board[2][2] = computerMarker; winFlag = true; break;
			case 7: board[2][2] = computerMarker; winFlag = true; break;
			case 8: board[2][2] = computerMarker; winFlag = true; break;
			case 9: board[1][2] = computerMarker; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 4) {
			switch (userLocation2) {
			case 2: board[2][2] = computerMarker; winFlag = true; break;
			case 3: board[2][2] = computerMarker; winFlag = true; break;
			case 6: board[2][2] = computerMarker; winFlag = true; break;
			case 7: board[2][2] = computerMarker; winFlag = true; break;
			case 8: board[2][2] = computerMarker; winFlag = true; break;
			case 9: board[0][2] = computerMarker; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 6) {
			switch (userLocation2) {
			case 1: board[2][0] = computerMarker; winFlag = true; break;
			case 2: board[2][0] = computerMarker; winFlag = true; break;
			case 4: board[2][0] = computerMarker; winFlag = true; break;
			case 7: board[0][0] = computerMarker; break;
			case 8: board[2][0] = computerMarker; winFlag = true; break;
			case 9: board[2][0] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 7) {
			switch (userLocation2) {
			case 2: board[2][2] = computerMarker; winFlag = true; break;
			case 3: board[2][2] = computerMarker; winFlag = true; break;
			case 4: board[2][2] = computerMarker; winFlag = true; break;
			case 6: board[2][2] = computerMarker; winFlag = true; break;
			case 8: board[2][2] = computerMarker; winFlag = true; break;
			case 9: board[2][1] = computerMarker; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 8) {
			switch (userLocation2) {
			case 1: board[0][2] = computerMarker; winFlag = true; break;
			case 2: board[0][2] = computerMarker; winFlag = true; break;
			case 3: board[0][0] = computerMarker; break;
			case 4: board[0][2] = computerMarker; winFlag = true; break;
			case 6: board[0][2] = computerMarker; winFlag = true; break;
			case 9: board[0][2] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 9) {
			switch (userLocation2) {
			case 1: board[2][0] = computerMarker; winFlag = true; break;
			case 2: board[2][0] = computerMarker; winFlag = true; break;
			case 4: board[2][0] = computerMarker; winFlag = true; break;
			case 6: board[2][0] = computerMarker; winFlag = true; break;
			case 7: board[2][1] = computerMarker; break;
			case 8: board[2][0] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else {
			System.out.println("ERROR");
		}
		//Display the board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		return winFlag;
 	}
	
	/**
	 * If the computer wins after its third or fourth turn, this method will be displayed, and the game will be over
	 */
	public static void results() {
		System.out.println("The computer wins!");
	}
	
	/**
	 * This method runs through the user's third turn, if the computer fails to win after 3 turns
	 * @return
	 */
	public static int userTurn3() {
		boolean vacancyFlag = false;
		System.out.println("It is now your turn.");
		int location;
		//The player must place their marker on a vacant unit
		//Error check to ensure the user selects a valid location
		do {
			System.out.println("Enter the location where you want to place your marker.");
			System.out.println("You must place your marker on a vacant square.");
			location = input.nextInt();
			if (location == 1) {
				if ((board[0][0] == 'x') || (board[0][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 2) {
				if ((board[0][1] == 'x') || (board[0][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 3) {
				if ((board[0][2] == 'x') || (board[0][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 4) {
				if ((board[1][0] == 'x') || (board[1][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 5) {
				if ((board[1][1] == 'x') || (board[1][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 6) {
				if ((board[1][2] == 'x') || (board[1][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 7) {
				if ((board[2][0] == 'x') || (board[2][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 8) {
				if ((board[2][1] == 'x') || (board[2][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 9) {
				if ((board[2][2] == 'x') || (board[2][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else {
				vacancyFlag = false;
			}
		} while (vacancyFlag == false);
		//Place the user's marker at the corresponding location
		switch (location) {
		case 1: board[0][0] = userMarker; break;
		case 2: board[0][1] = userMarker; break;
		case 3: board[0][2] = userMarker; break;
		case 4: board[1][0] = userMarker; break;
		case 6: board[1][2] = userMarker; break;
		case 7: board[2][0] = userMarker; break;
		case 8: board[2][1] = userMarker; break;
		case 9: board[2][2] = userMarker; break;
		default: System.out.println("ERROR"); break;
		}
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		return location;
	}
	
	/**
	 * This method runs through the computer's fourth turn
	 * @param userLocation1
	 * @param userLocation2
	 * @param userLocation3
	 * @return
	 */
	public static boolean computerTurn4(int userLocation1, int userLocation2, int userLocation3) {
		boolean winFlag = false;
		System.out.println("It is now the computer's turn.");
		//The computer will place its marker strategically, depending on the user's previous turns
		if (userLocation1 == 1) {
			switch (userLocation3) {
			case 2: board[1][2] = computerMarker; winFlag = true; break;
			case 6: board[2][1] = computerMarker; break;
			case 8: board[1][2] = computerMarker; winFlag = true; break;
			case 9: board[1][2] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 2) {
			switch (userLocation3) {
			case 1: board[1][2] = computerMarker; winFlag = true; break;
			case 4: board[1][2] = computerMarker; winFlag = true; break;
			case 6: board[0][0] = computerMarker; winFlag = true; break;
			case 8: board[1][2] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 3) {
			switch (userLocation3) {
			case 2: board[1][0] = computerMarker; winFlag = true; break;
			case 4: board[2][1] = computerMarker; break;
			case 7: board[1][0] = computerMarker; winFlag = true; break;
			case 8: board[1][0] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 4) {
			switch (userLocation3) {
			case 2: board[2][0] = computerMarker; winFlag = true; break;
			case 6: board[2][0] = computerMarker; winFlag = true; break;
			case 7: board[0][1] = computerMarker; winFlag = true; break;
			case 8: board[2][0] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 6) {
			switch (userLocation3) {
			case 2: board[2][2] = computerMarker; winFlag = true; break;
			case 4: board[0][1] = computerMarker; winFlag = true; break;
			case 8: board[0][1] = computerMarker; winFlag = true; break;
			case 9: board[0][1] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 7) {
			switch (userLocation3) {
			case 2: board[1][2] = computerMarker; break;
			case 3: board[0][1] = computerMarker; winFlag = true; break;
			case 4: board[0][1] = computerMarker; winFlag = true; break;
			case 6: board[0][1] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 8) {
			switch (userLocation3) {
			case 2: board[1][0] = computerMarker; winFlag = true; break;
			case 4: board[2][2] = computerMarker; winFlag = true; break;
			case 6: board[1][0] = computerMarker; winFlag = true; break;
			case 9: board[1][0] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 9) {
			switch (userLocation3) {
			case 1: board[0][1] = computerMarker; winFlag = true; break;
			case 2: board[1][0] = computerMarker; break;
			case 4: board[0][1] = computerMarker; winFlag = true; break;
			case 6: board[0][1] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else {
			System.out.println("ERROR");
		}
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		return winFlag;
	}
	
	/**
	 * This method runs through the user's final turn
	 * @return
	 */
	public static int userTurn4() {
		boolean vacancyFlag = false;
		System.out.println("It is now your turn.");
		int location;
		//The user must place their marker on a vacant unit
		//Error check to ensure the user chooses a valid location
		do {
			System.out.println("Enter the location where you want to place your marker.");
			System.out.println("You must place your marker on a vacant square.");
			location = input.nextInt();
			if (location == 1) {
				if ((board[0][0] == 'x') || (board[0][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 2) {
				if ((board[0][1] == 'x') || (board[0][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 3) {
				if ((board[0][2] == 'x') || (board[0][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 4) {
				if ((board[1][0] == 'x') || (board[1][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 5) {
				if ((board[1][1] == 'x') || (board[1][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 6) {
				if ((board[1][2] == 'x') || (board[1][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 7) {
				if ((board[2][0] == 'x') || (board[2][0] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 8) {
				if ((board[2][1] == 'x') || (board[2][1] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else if (location == 9) {
				if ((board[2][2] == 'x') || (board[2][2] == 'o')) {
					vacancyFlag = false;
				}
				else {
					vacancyFlag = true;
				}
			}
			else {
				vacancyFlag = false;
			}
		} while (vacancyFlag == false);
		//Place the user's marker at the corresponding location
		switch (location) {
		case 1: board[0][0] = userMarker; break;
		case 2: board[0][1] = userMarker; break;
		case 3: board[0][2] = userMarker; break;
		case 4: board[1][0] = userMarker; break;
		case 6: board[1][2] = userMarker; break;
		case 7: board[2][0] = userMarker; break;
		case 8: board[2][1] = userMarker; break;
		case 9: board[2][2] = userMarker; break;
		default: System.out.println("ERROR"); break;
		}
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		return location;
	}
	
	/**
	 * This method runs through the computer's final turn
	 * @param userLocation1
	 * @param userLocation2
	 * @param userLocation3
	 * @param userLocation4
	 * @return
	 */
	public static boolean computerTurn5(int userLocation1, int userLocation2, int userLocation3, int userLocation4) {
		boolean winFlag = false;
		System.out.println("It is now the computer's turn.");
		//The computer will place its marker strategically, based on the user's previous moves
		if (userLocation1 == 1) {
			switch (userLocation4) {
			case 2: board[2][2] = computerMarker; break;
			case 9: board[0][1] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 3) {
			switch (userLocation4) {
			case 2: board[2][0] = computerMarker; break;
			case 7: board[0][1] = computerMarker; winFlag = true; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 7) {
			switch (userLocation4) {
			case 3: board[1][0] = computerMarker; winFlag = true; break;
			case 4: board[0][2] = computerMarker; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else if (userLocation1 == 9) {
			switch (userLocation4) {
			case 1: board[1][2] = computerMarker; winFlag = true; break;
			case 6: board[0][0] = computerMarker; break;
			default: System.out.println("ERROR"); break;
			}
		}
		else {
			System.out.println("ERROR");
		}
		//Display the game board
		System.out.println("-----------");
		for (int i = 0; i < board[0].length; i ++) {
			for (int j = 0; j < board.length; j ++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		return winFlag;
	}
	
	/**
	 * This method displays the results if all spaces on the board are occupied. The game will be over.
	 * @param winFlag
	 */
	public static void results(boolean winFlag) {
		//The computer wins if it gets three markers in a row horizontally, vertically, or diagonally
		//Otherwise, the game ends in a draw
		if (winFlag == true) {
			System.out.println("The computer wins!");
		}
		else if (winFlag == false) {
			System.out.println("DRAW!");
		}
		else {
			System.out.println("ERROR");
		}
	}
	
}
