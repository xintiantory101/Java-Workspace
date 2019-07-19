package programs;

import java.util.Scanner;

public class Flipper {
	
	static Scanner input = new Scanner(System.in);
	static int[][] numbers = new int[2][2];

	public static void main(String[] args) {
		String[] flip;
		String flipInput = null;
		numbers[0][0] = 1;
		numbers[0][1] = 2;
		numbers[1][0] = 3;
		numbers[1][1] = 4;
		int spare = 0;
		flipInput = input.next();
		flip = new String[flipInput.length()];
		for (int i = 0; i < flip.length; i ++) {
			flip[i] = flipInput.substring(i, i+1);
		}
		for (int i = 0; i < flip.length; i ++) {
			if (flip[i].equals("H")) {
				spare = numbers[1][0];
				numbers[1][0] = numbers[0][0];
				numbers[0][0] = spare;
				spare = numbers[1][1];
				numbers[1][1] = numbers[0][1];
				numbers[0][1] = spare;
			}
			else if (flip[i].equals("V")) {
				spare = numbers[0][1];
				numbers[0][1] = numbers[0][0];
				numbers[0][0] = spare;
				spare = numbers[1][1];
				numbers[1][1] = numbers[1][0];
				numbers[1][0] = spare;
			}
		}
		for (int i = 0; i < numbers.length; i ++) {
			for (int j = 0; j < numbers[0].length; j ++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}

	}

}
