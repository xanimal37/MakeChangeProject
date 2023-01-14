package app;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		// create scanner that will be passed to input methods
		// scanner
		Scanner scanner = new Scanner(System.in);
		/*
		 * this variable will set if we continue the program if bad input is received it
		 * will be false and we will exit this isn't great but best I can do for now
		 * initially it is true
		 */
		boolean keepGoing = true;

		// amount the item costs
		double cost = 0;
		// amount tendered
		double tender = 0;

		cost = getPrice(scanner);
		// test this input
		keepGoing = isValidAmount(cost);

		if (keepGoing) {
			tender = getTender(scanner);
		}

		// close scanner!
		scanner.close();

		// test this input
		if (keepGoing) {
			keepGoing = isValidAmount(tender);
		}

		// test amounts - if too little or exact change
		if (keepGoing) {
			keepGoing = isEnough(cost, tender);
		}

		// calculate change if keepGoing
		if (keepGoing) {
			makeChange(cost, tender);

		}

	}

	// User story 1
	// get the cost from the user
	public static double getPrice(Scanner s) {
		// variable to hold the price
		double price = 0;

		// ui
		System.out.print("Please enter the price of the item:");
		price = s.nextDouble();
		s.nextLine(); // <<<<<<< da Fix

		// return price
		return price;
	}

	// User story 2
	// get the amount tendered from the user
	public static double getTender(Scanner s) {
		// variable to hold the amount tendered
		double tendered = 0;

		// ui
		System.out.print("Please enter the amount tendered:");
		tendered = s.nextDouble();
		s.nextLine(); // <<<<<<< da Fix

		// return price
		return tendered;
	}

	// User story 3
	// Display an appropriate message if the customer provided too little money or
	// the exact amount.
	public static boolean isEnough(double price, double tender) {
		// test condition
		// if too little or just enough tendered, display message return false
		// else return true (and do rest of calculations)
		if (price > tender) {
			System.out.println("Sorry, this item is too expensive!");
			return false;
		} else if (price == tender) {
			System.out.println("Thank you for exact change! Goodbye!");
			return false;
		}
		// we need to calculate change (continue the program)
		else {
			System.out.println("OK! Let's get you some change!");
			return true;
		}
	}

	// User story 4
	// Calculate and display change
	public static void makeChange(double price, double tender) {
		double change = tender - price;
		// convert to two decimal places first
		// tell the user the amount they are owed
		System.out.println("Your change is " + change);

		// add to this string which will be our final output
		// only add if denomination not zero
		String currency = "Your denominations are:";

		// now figure out each denomination
		// keep track of how many of each
		int twenties, tens, fives, ones, quarters, dimes, nickels, pennies = 0;

		// this is going to change as we 'subtract' bills
		double tempAmount = change;

		// largest bill is $20
		twenties = (int) tempAmount / 20;
		if (twenties != 0) {
			currency += " Twenties: " + twenties;
		}
		// get remainder
		tempAmount = tempAmount % 20;

		// next largest is $10
		tens = (int) tempAmount / 10;
		if (twenties != 0) {
			currency += " Tens: " + tens;
		}
		tempAmount = tempAmount % 10;

		// next largest is $5
		fives = (int) tempAmount / 5;
		if (fives != 0) {
			currency += " Fives: " + fives;
		}
		tempAmount = tempAmount % 5;

		// next largest is $1
		ones = (int) tempAmount;
		if (ones != 0) {
			currency += " Ones: " + ones;
		}
		tempAmount -= ones;

		// for the change, convert the remainder to whole number amount and continue
		// process
		tempAmount *= 100;
		// round up or down
		double diff = tempAmount - (int) tempAmount;
		// checks for basically ONLY DOLLARS -- no rounding or change required
		if (diff == 0) {
			currency += " and no coins";
		} else if (diff >= 0.5) {
			tempAmount += 1;
		} else {

		}

		// next largest is quarters
		quarters = (int) tempAmount / 25;
		if (quarters != 0) {
			currency += " Quarters: " + quarters;
		}
		tempAmount = tempAmount % 25;

		// next largest is dimes
		dimes = (int) tempAmount / 10;
		if (dimes != 0) {
			currency += " Dimes: " + dimes;
		}
		tempAmount = tempAmount % 10;

		// next largest is nickels
		nickels = (int) tempAmount / 5;
		if (nickels != 0) {
			currency += " Nickels: " + nickels;
		}
		tempAmount = tempAmount % 5;
		
		//finally we get the number of pennies
		pennies = (int)tempAmount;
		if(pennies!=0) {
			currency += " Pennies: " + pennies;
		}
		
		System.out.println(currency);

	}

	// this method tests for valid input
	public static boolean isValidAmount(double amount) {

		if (amount < 0) {
			System.out.println(amount + " is invalid! Quitting!");
			return false;
		} else {
			System.out.println("Continuing using " + amount);
			return true;
		}

	}

}
