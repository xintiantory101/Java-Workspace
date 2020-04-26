package programs;


import java.util.Scanner;


public class Bingo {


	static Scanner input = new Scanner(System.in);
	static String[] names;
	static int[][] board1 = new int[5][5];
	static int[][] board2 = new int[5][5];
	static int[][] board3 = new int[5][5];
	static int[][] board4 = new int[5][5];
	static int[][] board5 = new int[5][5];
	static int[][] board6 = new int[5][5];
	static boolean[] bingo = new boolean[6];


	// getNumOfPlayers() initializes the number of players

	public static int getNumOfPlayers() {
		int num = 0;
		while (true) {
			System.out.println("How many players are playing? This game is designed for 1 to 6 players.");
			num = input.nextInt();
			if (num < 1 || num > 6) {
				System.out.println("This game is designed for 1 to 6 players.");
			} else {
				break;
			}
		}
		return num;
	}


	// getNames(numOfPlayers) gets the players' names
	// requires: 1 <= numOfPlayers <= 6

	public static void getNames(int numOfPlayers) {
		assert(numOfPlayers >= 1);
		assert(numOfPlayers <= 6);
		names = new String[numOfPlayers];
		for (int i = 0; i < numOfPlayers; i++) {
			System.out.println("Player " + (i + 1) + ": Please enter your name.");
			names[i] = input.next();
		}
	}


	// setup(numOfPlayers) sets up the game boards according to the number of players
	// requires: 1 <= numOfPlayers <= 6

	public static void setup(int numOfPlayers) {
		assert(numOfPlayers >= 1);
		assert(numOfPlayers <= 6);
		int numPl = numOfPlayers;
		int min = 0;
		int max = 0;
		int num = 0;
		boolean dup = false;
		System.out.println(names[0] + ": ");
		for (int i = 0; i < board1[0].length; i++) {
			for (int j = 0; j < board1.length; j++) {
				while (true) {
					dup = false;
					System.out.println("Enter the number you wish to place in row " + j + ", column " + i + ".");
					if (i == 0) {
						min = 1;
						max = 15;
					} else if (i == 1) {
						min = 16;
						max = 30;
					} else if (i == 2) {
						min = 31;
						max = 45;
					} else if (i == 3) {
						min = 46;
						max = 60;
					} else if (i == 4) {
						min = 61;
						max = 75;
					}
					System.out.println("Please enter a number from " + min + " to " + max + ".");
					System.out.println("Note that all numbers must be distinct.");
					num = input.nextInt();
					for (int k = 0; k < board1.length; k++) {
						if (board1[k][i] == num) {
							dup = true;
						}
					}
					if (num >= min && num <= max && !dup) {
						break;
					}
					System.out.println("Invalid Entry");
				}
				board1[j][i] = num;
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[1] + ": ");
			for (int i = 0; i < board2[0].length; i++) {
				for (int j = 0; j < board2.length; j++) {
					while (true) {
						dup = false;
						System.out.println("Enter the number you wish to place in row " + j + ", column " + i + ".");
						if (i == 0) {
							min = 1;
							max = 15;
						} else if (i == 1) {
							min = 16;
							max = 30;
						} else if (i == 2) {
							min = 31;
							max = 45;
						} else if (i == 3) {
							min = 46;
							max = 60;
						} else if (i == 4) {
							min = 61;
							max = 75;
						}
						System.out.println("Please enter a number from " + min + " to " + max + ".");
						System.out.println("Note that all numbers must be distinct.");
						num = input.nextInt();
						for (int k = 0; k < board2.length; k++) {
							if (board2[k][i] == num) {
								dup = true;
							}
						}
						if (num >= min && board2[i][j] <= num && !dup) {
							break;
						}
						System.out.println("Invalid Entry");
					}
					board2[j][i] = num;
				}
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[2] + ": ");
			for (int i = 0; i < board3[0].length; i++) {
				for (int j = 0; j < board3.length; j++) {
					while (true) {
						dup = false;
						System.out.println("Enter the number you wish to place in row " + j + ", column " + i + ".");
						if (i == 0) {
							min = 1;
							max = 15;
						} else if (i == 1) {
							min = 16;
							max = 30;
						} else if (i == 2) {
							min = 31;
							max = 45;
						} else if (i == 3) {
							min = 46;
							max = 60;
						} else if (i == 4) {
							min = 61;
							max = 75;
						}
						System.out.println("Please enter a number from " + min + " to " + max + ".");
						System.out.println("Note that all numbers must be distinct.");
						num = input.nextInt();
						for (int k = 0; k < board3.length; k++) {
							if (board3[k][i] == num) {
								dup = true;
							}
						}
						if (num >= min && num <= max && !dup) {
							break;
						}
						System.out.println("Invalid Entry");
					}
					board3[j][i] = num;
				}
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[3] + ": ");
			for (int i = 0; i < board4[0].length; i++) {
				for (int j = 0; j < board4.length; j++) {
					while (true) {
						dup = false;
						System.out.println("Enter the number you wish to place in row " + j + ", column " + i + ".");
						if (i == 0) {
							min = 1;
							max = 15;
						} else if (i == 1) {
							min = 16;
							max = 30;
						} else if (i == 2) {
							min = 31;
							max = 45;
						} else if (i == 3) {
							min = 46;
							max = 60;
						} else if (i == 4) {
							min = 61;
							max = 75;
						}
						System.out.println("Please enter a number from " + min + " to " + max + ".");
						System.out.println("Note that all numbers must be distinct.");
						num = input.nextInt();
						for (int k = 0; k < board4.length; k++) {
							if (board4[k][i] == num) {
								dup = true;
							}
						}
						if (num >= min && num <= max && !dup) {
							break;
						}
						System.out.println("Invalid Entry");
					}
					board4[j][i] = num;
				}
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[4] + ": ");
			for (int i = 0; i < board5[0].length; i++) {
				for (int j = 0; j < board5.length; j++) {
					while (true) {
						dup = false;
						System.out.println("Enter the number you wish to place in row " + j + ", column " + i + ".");
						if (i == 0) {
							min = 1;
							max = 15;
						} else if (i == 1) {
							min = 16;
							max = 30;
						} else if (i == 2) {
							min = 31;
							max = 45;
						} else if (i == 3) {
							min = 46;
							max = 60;
						} else if (i == 4) {
							min = 61;
							max = 75;
						}
						System.out.println("Please enter a number from " + min + " to " + max + ".");
						System.out.println("Note that all numbers must be distinct.");
						num = input.nextInt();
						for (int k = 0; k < board5.length; k++) {
							if (board5[k][i] == num) {
								dup = true;
							}
						}
						if (num >= min && num <= max && !dup) {
							break;
						}
						System.out.println("Invalid Entry");
					}
					board5[j][i] = num;
				}
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[5] + ": ");
			for (int i = 0; i < board6[0].length; i++) {
				for (int j = 0; j < board6.length; j++) {
					while (true) {
						dup = false;
						System.out.println("Enter the number you wish to place in row " + j + ", column " + i + ".");
						if (i == 0) {
							min = 1;
							max = 15;
						} else if (i == 1) {
							min = 16;
							max = 30;
						} else if (i == 2) {
							min = 31;
							max = 45;
						} else if (i == 3) {
							min = 46;
							max = 60;
						} else if (i == 4) {
							min = 61;
							max = 75;
						}
						System.out.println("Please enter a number from " + min + " to " + max + ".");
						System.out.println("Note that all numbers must be distinct.");
						num = input.nextInt();
						for (int k = 0; k < board6.length; k++) {
							if (board6[k][i] == num) {
								dup = true;
							}
						}
						if (num >= min && num <= max && !dup) {
							break;
						}
						System.out.println("Invalid Entry");
					}
					board6[j][i] = num;
				}
			}
		}
	}


	// printBoards(numOfPlayers) prints the boards of all the players
	// requires: 1 <= numOfPlayers <= 6

	public static void printBoards(int numOfPlayers) {
		assert(numOfPlayers >= 1);
		assert(numOfPlayers <= 6);
		int numPl = numOfPlayers;
		System.out.println("Here are the boards at current.");
		System.out.println(names[0] + ": ");
		System.out.println(" B  I  N  G  O");
		for (int i = 0; i < board1.length; i++) {
			for (int j = 0; j < board1[0].length; j++) {
				if (board1[i][j] < 10) {
					System.out.print(" ");
				}
				System.out.print(board1[i][j] + " ");
			}
			System.out.println();
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[1] + ": ");
			System.out.println(" B  I  N  G  O");
			for (int i = 0; i < board2.length; i++) {
				for (int j = 0; j < board2[0].length; j++) {
					if (board2[i][j] < 10) {
						System.out.print(" ");
					}
					System.out.print(board2[i][j] + " ");
				}
				System.out.println();
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[2] + ": ");
			System.out.println(" B  I  N  G  O");
			for (int i = 0; i < board3.length; i++) {
				for (int j = 0; j < board3[0].length; j++) {
					if (board3[i][j] < 10) {
						System.out.print(" ");
					}
					System.out.print(board3[i][j] + " ");
				}
				System.out.println();
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[3] + ": ");
			System.out.println(" B  I  N  G  O");
			for (int i = 0; i < board4.length; i++) {
				for (int j = 0; j < board4[0].length; j++) {
					if (board4[i][j] < 10) {
						System.out.print(" ");
					}
					System.out.print(board4[i][j] + " ");
				}
				System.out.println();
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[4] + ": ");
			System.out.println(" B  I  N  G  O");
			for (int i = 0; i < board5.length; i++) {
				for (int j = 0; j < board5[0].length; j++) {
					if (board5[i][j] < 10) {
						System.out.print(" ");
					}
					System.out.print(board5[i][j] + " ");
				}
				System.out.println();
			}
		}
		numPl--;
		if (numPl > 0) {
			System.out.println(names[5] + ": ");
			System.out.println(" B  I  N  G  O");
			for (int i = 0; i < board6.length; i++) {
				for (int j = 0; j < board6[0].length; j++) {
					if (board6[i][j] < 10) {
						System.out.print(" ");
					}
					System.out.print(board6[i][j] + " ");
				}
				System.out.println();
			}
		}
	}


	// checkColumns(numOfPlayers) checks to see if any players have won through columns with numOfPlayers
	// requires: 1 <= numOfPlayers <= 6

	public static void checkColumns(int numOfPlayers) {
		assert(numOfPlayers >= 1);
		assert(numOfPlayers <= 6);
		int numPl = numOfPlayers;
		boolean[] colBingo1 = new boolean[5];
		boolean[] colBingo2 = new boolean[5];
		boolean[] colBingo3 = new boolean[5];
		boolean[] colBingo4 = new boolean[5];
		boolean[] colBingo5 = new boolean[5];
		boolean[] colBingo6 = new boolean[5];
		int counter = 0;
		for (int i = 0; i < board1[0].length; i++) {
			for (int j = 0; j < board1.length; j++) {
				if (board1[j][i] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				colBingo1[i] = true;
				break;
			}
			counter = 0;
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board2[0].length; i++) {
				for (int j = 0; j < board2.length; j++) {
					if (board2[j][i] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					colBingo2[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board3[0].length; i++) {
				for (int j = 0; j < board3.length; j++) {
					if (board3[j][i] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					colBingo3[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board4[0].length; i++) {
				for (int j = 0; j < board4.length; j++) {
					if (board4[j][i] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					colBingo4[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board5[0].length; i++) {
				for (int j = 0; j < board5.length; j++) {
					if (board5[j][i] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					colBingo5[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board6[0].length; i++) {
				for (int j = 0; j < board6.length; j++) {
					if (board6[j][i] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					colBingo6[i] = true;
					break;
				}
				counter = 0;
			}
		}
		for (int i = 0; i < colBingo1.length; i++) {
			if (colBingo1[i]) {
				bingo[0] = true;
				break;
			}
		}
		for (int i = 0; i < colBingo2.length; i++) {
			if (colBingo2[i]) {
				bingo[1] = true;
				break;
			}
		}
		for (int i = 0; i < colBingo3.length; i++) {
			if (colBingo3[i]) {
				bingo[2] = true;
				break;
			}
		}
		for (int i = 0; i < colBingo4.length; i++) {
			if (colBingo4[i]) {
				bingo[3] = true;
				break;
			}
		}
		for (int i = 0; i < colBingo5.length; i++) {
			if (colBingo5[i]) {
				bingo[4] = true;
				break;
			}
		}
		for (int i = 0; i < colBingo6.length; i++) {
			if (colBingo6[i]) {
				bingo[5] = true;
				break;
			}
		}
	}


	// checkRows(numOfPlayers) checks to see if any players have won through rows with numOfPlayers
	// requires: 1 <= numOfPlayers <= 6

	public static void checkRows(int numOfPlayers) {
		assert(numOfPlayers >= 1);
		assert(numOfPlayers <= 6);
		int numPl = numOfPlayers;
		boolean[] rowBingo1 = new boolean[5];
		boolean[] rowBingo2 = new boolean[5];
		boolean[] rowBingo3 = new boolean[5];
		boolean[] rowBingo4 = new boolean[5];
		boolean[] rowBingo5 = new boolean[5];
		boolean[] rowBingo6 = new boolean[5];
		int counter = 0;
		for (int i = 0; i < board1.length; i++) {
			for (int j = 0; j < board1[0].length; j++) {
				if (board1[i][j] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				rowBingo1[i] = true;
				break;
			}
			counter = 0;
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board2.length; i++) {
				for (int j = 0; j < board2[0].length; j++) {
					if (board2[i][j] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					rowBingo2[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board3.length; i++) {
				for (int j = 0; j < board3[0].length; j++) {
					if (board3[i][j] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					rowBingo3[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board4.length; i++) {
				for (int j = 0; j < board4[0].length; j++) {
					if (board4[i][j] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					rowBingo4[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board5.length; i++) {
				for (int j = 0; j < board5[0].length; j++) {
					if (board5[i][j] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					rowBingo5[i] = true;
					break;
				}
				counter = 0;
			}
		}
		numPl--;
		counter = 0;
		if (numPl > 0) {
			for (int i = 0; i < board6.length; i++) {
				for (int j = 0; j < board6[0].length; j++) {
					if (board6[i][j] == 0) {
						counter++;
					}
				}
				if (counter == 5) {
					rowBingo6[i] = true;
					break;
				}
				counter = 0;
			}
		}
		for (int i = 0; i < rowBingo1.length; i++) {
			if (rowBingo1[i]) {
				bingo[0] = true;
				break;
			}
		}
		for (int i = 0; i < rowBingo2.length; i++) {
			if (rowBingo2[i]) {
				bingo[1] = true;
				break;
			}
		}
		for (int i = 0; i < rowBingo3.length; i++) {
			if (rowBingo3[i]) {
				bingo[2] = true;
				break;
			}
		}
		for (int i = 0; i < rowBingo4.length; i++) {
			if (rowBingo4[i]) {
				bingo[3] = true;
				break;
			}
		}
		for (int i = 0; i < rowBingo5.length; i++) {
			if (rowBingo5[i]) {
				bingo[4] = true;
				break;
			}
		}
		for (int i = 0; i < rowBingo6.length; i++) {
			if (rowBingo6[i]) {
				bingo[5] = true;
				break;
			}
		}
	}
	
	
	// checkDiagonals(numOfPlayers)
	
	public static void checkDiagonals(int numOfPlayers) {
		assert(numOfPlayers >= 1);
		assert(numOfPlayers <= 6);
		int numPl = numOfPlayers;
		boolean[] diagBingo1 = new boolean[2];
		boolean[] diagBingo2 = new boolean[2];
		boolean[] diagBingo3 = new boolean[2];
		boolean[] diagBingo4 = new boolean[2];
		boolean[] diagBingo5 = new boolean[2];
		boolean[] diagBingo6 = new boolean[2];
		int counter = 0;
		for (int i = 0; i < board1.length; i++) {
			if (board1[i][i] == 0) {
				counter++;
			}
		}
		if (counter == 5) {
			diagBingo1[0] = true;
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board2.length; i++) {
				if (board2[i][i] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo2[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board3.length; i++) {
				if (board3[i][i] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo3[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board4.length; i++) {
				if (board4[i][i] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo4[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board5.length; i++) {
				if (board5[i][i] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo5[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board6.length; i++) {
				if (board6[i][i] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo6[0] = true;
			}
		}
		counter = 0;
		numPl = numOfPlayers;
		for (int i = 0; i < board1.length; i++) {
			if (board1[i][board1.length - i - 1] == 0) {
				counter++;
			}
		}
		if (counter == 5) {
			diagBingo1[0] = true;
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board2.length; i++) {
				if (board2[i][board2.length - i - 1] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo2[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board3.length; i++) {
				if (board3[i][board3.length - i - 1] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo3[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board4.length; i++) {
				if (board4[i][board4.length - i - 1] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo4[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board5.length; i++) {
				if (board5[i][board5.length - i - 1] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo5[0] = true;
			}
		}
		counter = 0;
		numPl--;
		if (numPl > 0) {
			for (int i = 0; i < board6.length; i++) {
				if (board6[i][board6.length - i - 1] == 0) {
					counter++;
				}
			}
			if (counter == 5) {
				diagBingo6[0] = true;
			}
		}
		for (int i = 0; i < diagBingo1.length; i++) {
			if (diagBingo1[i]) {
				bingo[0] = true;
				break;
			}
		}
		for (int i = 0; i < diagBingo2.length; i++) {
			if (diagBingo2[i]) {
				bingo[1] = true;
				break;
			}
		}
		for (int i = 0; i < diagBingo3.length; i++) {
			if (diagBingo3[i]) {
				bingo[2] = true;
				break;
			}
		}
		for (int i = 0; i < diagBingo4.length; i++) {
			if (diagBingo4[i]) {
				bingo[3] = true;
				break;
			}
		}
		for (int i = 0; i < diagBingo5.length; i++) {
			if (diagBingo5[i]) {
				bingo[4] = true;
				break;
			}
		}
		for (int i = 0; i < diagBingo6.length; i++) {
			if (diagBingo6[i]) {
				bingo[5] = true;
				break;
			}
		}
	}


	// bingo(numOfPlayers) runs the Bingo game with numOfPlayers
	// requires: 1 <= numOfPlayers <= 6

	public static void bingo(int numOfPlayers) {
		assert(numOfPlayers >= 1);
		assert(numOfPlayers <= 6);
		System.out.println("Welcome to BINGO!");
		System.out.println("Every turn, a random number between 1 and 75 will be drawn.");
		System.out.println("If the number matches a number on your card, that number on your card will be replaced with 0.");
		System.out.println("If you have 5 zeros in a row, column, or diagonal, you win!");
		int num = 0;
		boolean end = false;
		while (true) {
			num = (int) (Math.random() * 75 + 1);
			if (num >= 1 && num <= 15) {
				System.out.println("B" + num);
				for (int i = 0; i < board1.length; i++) {
					if (board1[i][0] == num) {
						board1[i][0] = 0;
						break;
					}
				}
				for (int i = 0; i < board2.length; i++) {
					if (board2[i][0] == num) {
						board2[i][0] = 0;
						break;
					}
				}
				for (int i = 0; i < board3.length; i++) {
					if (board3[i][0] == num) {
						board3[i][0] = 0;
						break;
					}
				}
				for (int i = 0; i < board4.length; i++) {
					if (board4[i][0] == num) {
						board4[i][0] = 0;
						break;
					}
				}
				for (int i = 0; i < board5.length; i++) {
					if (board5[i][0] == num) {
						board5[i][0] = 0;
						break;
					}
				}
				for (int i = 0; i < board6.length; i++) {
					if (board6[i][0] == num) {
						board6[i][0] = 0;
						break;
					}
				}
			} else if (num >= 16 && num <= 30) {
				System.out.println("I" + num);
				for (int i = 0; i < board1.length; i++) {
					if (board1[i][1] == num) {
						board1[i][1] = 0;
						break;
					}
				}
				for (int i = 0; i < board2.length; i++) {
					if (board2[i][1] == num) {
						board2[i][1] = 0;
						break;
					}
				}
				for (int i = 0; i < board3.length; i++) {
					if (board3[i][1] == num) {
						board3[i][1] = 0;
						break;
					}
				}
				for (int i = 0; i < board4.length; i++) {
					if (board4[i][1] == num) {
						board4[i][1] = 0;
						break;
					}
				}
				for (int i = 0; i < board5.length; i++) {
					if (board5[i][1] == num) {
						board5[i][1] = 0;
						break;
					}
				}
				for (int i = 0; i < board6.length; i++) {
					if (board6[i][1] == num) {
						board6[i][1] = 0;
						break;
					}
				}
			} else if (num >= 31 && num <= 45) {
				System.out.println("N" + num);
				for (int i = 0; i < board1.length; i++) {
					if (board1[i][2] == num) {
						board1[i][2] = 0;
						break;
					}
				}
				for (int i = 0; i < board2.length; i++) {
					if (board2[i][2] == num) {
						board2[i][2] = 0;
						break;
					}
				}
				for (int i = 0; i < board3.length; i++) {
					if (board3[i][2] == num) {
						board3[i][2] = 0;
						break;
					}
				}
				for (int i = 0; i < board4.length; i++) {
					if (board4[i][2] == num) {
						board4[i][2] = 0;
						break;
					}
				}
				for (int i = 0; i < board5.length; i++) {
					if (board5[i][2] == num) {
						board5[i][2] = 0;
						break;
					}
				}
				for (int i = 0; i < board6.length; i++) {
					if (board6[i][2] == num) {
						board6[i][2] = 0;
						break;
					}
				}
			} else if (num >= 46 && num <= 60) {
				System.out.println("G" + num);
				for (int i = 0; i < board1.length; i++) {
					if (board1[i][3] == num) {
						board1[i][3] = 0;
						break;
					}
				}
				for (int i = 0; i < board2.length; i++) {
					if (board2[i][3] == num) {
						board2[i][3] = 0;
						break;
					}
				}
				for (int i = 0; i < board3.length; i++) {
					if (board3[i][3] == num) {
						board3[i][3] = 0;
						break;
					}
				}
				for (int i = 0; i < board4.length; i++) {
					if (board4[i][3] == num) {
						board4[i][3] = 0;
						break;
					}
				}
				for (int i = 0; i < board5.length; i++) {
					if (board5[i][3] == num) {
						board5[i][3] = 0;
						break;
					}
				}
				for (int i = 0; i < board6.length; i++) {
					if (board6[i][3] == num) {
						board6[i][3] = 0;
						break;
					}
				}
			} else if (num >= 61 && num <= 75) {
				System.out.println("O" + num);
				for (int i = 0; i < board1.length; i++) {
					if (board1[i][4] == num) {
						board1[i][4] = 0;
						break;
					}
				}
				for (int i = 0; i < board2.length; i++) {
					if (board2[i][4] == num) {
						board2[i][4] = 0;
						break;
					}
				}
				for (int i = 0; i < board3.length; i++) {
					if (board3[i][4] == num) {
						board3[i][4] = 0;
						break;
					}
				}
				for (int i = 0; i < board4.length; i++) {
					if (board4[i][4] == num) {
						board4[i][4] = 0;
						break;
					}
				}
				for (int i = 0; i < board5.length; i++) {
					if (board5[i][4] == num) {
						board5[i][4] = 0;
						break;
					}
				}
				for (int i = 0; i < board6.length; i++) {
					if (board6[i][4] == num) {
						board6[i][4] = 0;
						break;
					}
				}
			}

			printBoards(numOfPlayers);
			checkColumns(numOfPlayers);
			checkRows(numOfPlayers);
			checkDiagonals(numOfPlayers);
			for (int i = 0; i < bingo.length; i++) {
				if (bingo[i]) {
					end = true;
					break;
				}
			}
			if (end) {
				System.out.println("BINGO!");
				break;
			}
		}
		System.out.println("The following players have won BINGO: ");
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[i]) {
				System.out.println(names[i]);
			}
		}
	}


	public static void main(String[] args) {
		int numOfPlayers = getNumOfPlayers();
		getNames(numOfPlayers);
		setup(numOfPlayers);
		printBoards(numOfPlayers);
		bingo(numOfPlayers);
	}

}
