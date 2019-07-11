package evaluations;

import java.util.Scanner;
import java.io.*;

public class WilliamWangMultipleChoice {
	
	static Scanner input = new Scanner(System.in);
	static File answerKey;
	static PrintWriter pw;
	static int numberOfQuestions, numberOfLetters;
	static char[] answer;

	public static void main(String[] args) throws FileNotFoundException {
		getInfo();
		getFileName();
		generateLetterArray();
		writeToFile();

	}
	
	public static void getInfo() throws FileNotFoundException {
		System.out.println("How many questions do you want to generate?");
		numberOfQuestions = input.nextInt();
		System.out.println("How many letter options do you want to generate per question?");
		System.out.println("You must generate between 2 and 6 letters inclusive per question.");
		numberOfLetters = input.nextInt();
		while ((numberOfLetters < 2) || (numberOfLetters > 6)) {
			System.out.println("You must generate between 2 and 6 letters inclusive per question.");
			System.out.println("Please re-enter the number of letter options per question.");
			numberOfLetters = input.nextInt();
		}
	}
	
	public static void getFileName() throws FileNotFoundException {
		System.out.println("Enter a file name for the answer sheet.");
		String name = input.next();
		answerKey = new File(name + ".txt");
	}
	
	public static void generateLetterArray() throws FileNotFoundException {
		answer = new char[numberOfQuestions];
		for (int i = 0; i < answer.length; i ++) {
			answer[i] = (char) ((int) (Math.random() * numberOfLetters + 65));
		}
	}
	
	public static void writeToFile() throws FileNotFoundException {
		pw = new PrintWriter(answerKey);
		Scanner fileIn = new Scanner(answerKey);
		pw.println("Correct Responses");
		for (int i = 0; i < answer.length; i ++) {
			pw.println("Question #" + (i + 1) + ": " + answer[i]);
		}
		pw.flush();
		pw.close();
		while (fileIn.hasNextLine()) {
			System.out.println(fileIn.nextLine());
		}
		fileIn.close();
	}

}
