package evaluations;

import java.util.Scanner;

public class WilliamWangHoroscope {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter your first name.");
		String firstName = input.next();
		
		System.out.println("Please enter your middle name.");
		String middleName = input.next();
		
		System.out.println("Please enter your last name.");
		String lastName = input.next();
		
		System.out.println("Please enter your month of birth. Enter your month as a numerical value. For example, enter 1 for January, 2 for February, 3 for March, and so on.");
		int month = input.nextInt();
		
			
		System.out.println("Please enter the day of that month on which your birthday occurs.");
		int day = input.nextInt();
		
		if (month == 1) {
			
			if ((day > 0) && (day <=19)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Capricorn.");
			}
			
			else if ((day > 19) && (day <= 31)){
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Aquarius.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		
		else if (month == 2) {
			
			if ((day > 0) && (day <= 18)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Aquarius.");
			}
			
			else if ((day > 18) && (day <= 29)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Pisces.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		
		else if (month == 3) {
			
			if ((day > 0) && (day <= 20)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Pisces.");
			}
			
			else if ((day > 20) && (day <= 31)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Aries.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
			
		else if (month == 4) {
			
			if ((day > 0) && (day <= 19)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Aries.");
			}
			
			else if ((day > 19) && (day <= 30)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Taurus.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		else if (month == 5) {
			
			if ((day > 0) && (day <= 20)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Taurus.");
			}
			
			else if ((day > 20) && (day <= 31)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Gemini.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		else if (month == 6) {
			
			if ((day > 0) && (day <= 20)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Gemini.");
			}
			
			else if ((day > 20) && (day <= 30)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Cancer.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		
		else if (month == 7) {
			
			if ((day > 0) && (day <= 22)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Cancer.");
			}
			
			else if ((day > 22) && (day <= 31)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Leo.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		
		else if (month == 8) {
			
			if ((day > 0) && (day <= 22)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Leo.");
			}
			
			else if ((day > 22) && (day <= 31)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Virgo.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		
		else if (month == 9) {
			
			if ((day > 0) && (day <= 22)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Virgo.");
			}
			
			else if ((day > 22) && (day <= 30)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Libra.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		
		else if (month == 10) {
			
			if ((day > 0) && (day <= 22)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Libra.");
		}
			
			else if ((day > 22) && (day <= 31)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Scorpio.");
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		
		else if (month == 11) {
			
			if ((day > 0) && (day <= 21)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Scorpio.");
			}
			
			else if ((day > 21) && (day <= 30)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Sagittarius.");
		}
		
			else {
				System.out.println("ERROR");
			}
		}
			
		else if (month == 12) {
			
			if ((day > 0) && (day <= 21)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Sagittarius.");
			}
			
			else if ((day > 21) && (day <= 31)) {
				System.out.println(firstName + " " + middleName + " " + lastName + ", your horoscope is Capricorn.");
				
			}
			
			else {
				System.out.println("ERROR");
			}
		}
		else {
			System.out.println("ERROR");
		}
		}
		

	}


