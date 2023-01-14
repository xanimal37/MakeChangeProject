package app;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		// create scanner that will be passed to input methods
		// scanner
		Scanner scanner = new Scanner(System.in);
		//amount the item costs
		double cost = 0;
		cost = getInput(scanner);
		//amount tendered
		double tender = 0;
		tender = getAmountTendered(scanner);
		//close scanner!
		scanner.close();
		
		// test amount tendered

		// calculate change

		// debug -- input steps
		//test for crap input
		System.out.println(cost);
		System.out.println(tender);
		System.out.println(isEnough(cost, tender));

	}

	// User story 1
	// get user input
	// do not allow negative input!
	public static double getInput(Scanner s) {
		// variable to hold the price
		double price = 0;

		// ui
		System.out.print("Please enter the price of the item:");
		price = s.nextDouble();
		
		// round the price to an amount that can be represented in currency
		//if 45.32143245 round to 45.32

		// return price
		return price;
	}

	// User story 2
	// get the amount tendered
	// do not allow negative input!
	public static double getAmountTendered(Scanner s) {
		// variable to hold the amount tendered
		double tendered = 0;

		// ui
		System.out.print("Please enter the amount tendered:");
		tendered = s.nextDouble();
		
		
		// round the price to an amount that can be represented in currency

		// return price
		return tendered;
	}
	
	//User story 3
	//Display an appropriate message if the customer provided too little money or the exact amount.
	public static boolean isEnough(double price, double tender) {
		//test condition
		//if too little or just enough tendered, display message return false
		//else return true (and do rest of calculations)
		if(price > tender) {
			System.out.println("Sorry, this item is too expensive!");
			return false;
		}
		else if(price == tender) {
			System.out.println("Thank you for exact change! Goodbye!");
			return false;
		}
		//we need to calculate change (continue the program)
		else {
			return true;
		}
	}
	
	//User story 4
	//Calculate and display change
	public static double makeChange(double price, double tender) {
		
		return 0;
	}
	
	
	/* this extra method will test and convert dollar amount
	   example:
	   45.234923482400 should be calculated as 45.23
	   3.000000 or 3 should be 3.00
	   -2 is a fail
	 */
	

}
