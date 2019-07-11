package evaluations;

import java.util.Scanner;

/**
 * This program will generate a minesweeper board.
 * @author TTW
 *
 */

public class WilliamWangMinesweeper {
	
	//Set up the scanner and variables for the area of the board, the coordinates of the mines, and the array for the board.
	static Scanner input = new Scanner(System.in);
	static int area;
	static int coordinateX, coordinateY;
	static char[][] board;

	public static void main(String[] args) {

		int sideLength = getSize();
		int mines = getNumberOfMines(sideLength);
		minePlacement(sideLength, mines);
		checkMinePlacement(sideLength, mines);

	}

	public static int getSize() {
		
		//Get the side length of the board from the user.
		int sideLength;
		do {
			System.out.println("What do you want the side length of the board to be?");
			sideLength = input.nextInt();

			if (sideLength <= 0) {
				System.out.println("Please enter a number greater than 0.");
				sideLength = input.nextInt();
			}

		} while (sideLength <= 0);
		
		//The board is a square, so the area is the square of the side length.
		area = (int) (Math.pow(sideLength, 2));

		return sideLength;

	}



	public static int getNumberOfMines(int sideLength) {
		
		//Initialize the board array.
		board = new char[sideLength][sideLength];

		int mines;
		
		//Get the number of mines from the user, ensuring that at least 1 mine is placed, and that the number of mines does not exceed the area of the board.
		do {
			System.out.println("Enter the number of mines you want on your board.");
			System.out.println("You must enter at least 1 mine and no more than " + area + " mines.");
			mines = input.nextInt();

			if ((mines > area) || (mines <= 0)) {
				System.out.println("You must enter at least 1 mine and no more than " + area + " mines.");
				System.out.println("Please re-enter the number of mines to be placed.");
				mines = input.nextInt();
			}
		} while ((mines > area) || (mines <= 0));

		return mines;
	}


	public static void minePlacement(int sideLength, int mines) {
		
		int counter = 0;

		//Place the mines at random locations on the board.
		do {

			coordinateX = (int) (Math.random() * sideLength);
			coordinateY = (int) (Math.random() * sideLength);



			//Ensure that no single space is marked more than once.
			if (board[coordinateX][coordinateY] != 'x') {
				board[coordinateX][coordinateY] = 'x';
				counter ++;
			}
			
			
			else {
				counter += 0;
			}
			
		} while (counter < mines);



	}


	public static void checkMinePlacement(int sideLength, int mines) {
		
		//The 48th value of the ASCII table is 0.
		char counter = 48;
		
		
		//Check the squares around all bombs.
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[0].length; j ++) {
				if (board[i][j] != 'x') {
					for (int k = i - 1; k <= i + 1; k ++) {
						for (int l = j - 1; l <= j + 1; l ++) {
							if ((k >= 0) && (k < board.length) && (l >= 0) && (l < board[0].length)) {
								if (board[k][l] == 'x') {
									counter ++;
								}
							}
						}
					}
					
					//Place the counter at the designated location.
					board[i][j] = counter;
					counter = 48;
				}
			}
		}
		
		//Output the board, placing the counters and mine markers where necessary.
		for (int m = 0; m < board.length; m ++) {
			for (int n = 0; n < board[0].length; n ++) {
				System.out.print(board[m][n] + " ");
			}

			System.out.print("\n");
		}

	}

}
