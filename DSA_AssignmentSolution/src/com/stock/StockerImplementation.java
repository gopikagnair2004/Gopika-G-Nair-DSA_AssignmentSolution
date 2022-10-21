package com.stock;

import java.util.Scanner;

public class StockerImplementation {
	static MergeSort sort = new MergeSort();
	static Stockers[] companies ;
	static int noOfCompanies;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter no of Companies");
		noOfCompanies = sc.nextInt();
		
		if(noOfCompanies == 0) {
			System.out.println("Please enter the no of Companies greater than 0");
			noOfCompanies = sc.nextInt();
		}
		companies = new Stockers[noOfCompanies];
		
		
		for(int i=0;i<noOfCompanies;i++)
		{
			System.out.println("Enter current stock price of the company "+(i+1));
			double sharePrice = sc.nextDouble();
			System.out.println("Whether the company's stock price rose today compared to yesterday?");
			boolean priceIncreased = sc.nextBoolean();
			companies[i] = new Stockers(sharePrice,priceIncreased);
			
		}
		sort.mergesort(companies,0,noOfCompanies-1);
		
		boolean continueOperation = true;
		
		do {
			System.out.println("\nEnter the operation that you want to perform\r\n"
					+ "1. Display the companies stock prices in ascending order\r\n"
					+ "2. Display the companies stock prices in descending order\r\n"
					+ "3. Display the total no of companies for which stock prices rose today\r\n"
					+ "4. Display the total no of companies for which stock prices declined today\r\n"
					+ "5. Search a specific stock price\r\n"
					+ "6. press 0 to exit");
			int selectedOption = sc.nextInt();
			switch(selectedOption) {
				case 0:
					continueOperation = false;
					System.out.println("Exiting the program!!");
					break;
				case 1:
					printStockInAscending();
					break;
				case 2:
					printStockInDescending();
					break;
				case 3:
					displayIncreasedStockPrice();
					break;
				case 4:
					displayDecreasedStockPrice();
					break;
				case 5:
					System.out.println("enter the key value");
					double key = sc.nextDouble();
					searchSharePrice(key);
					
					break;
					
					
			}
		}while(continueOperation);
		}
		
		

	private static void searchSharePrice(double key) {
		boolean keyPresent = false;
		for(int i=0;i<noOfCompanies;i++) {
			if(companies[i].sharePrice == key) {
				System.out.println("Stock of value "+key+" is present ");
				keyPresent = true;
				break;
			}
		}
		if(!keyPresent)
			System.out.println("Stock of value "+key+" is not present ");
		
	}

	private static void displayDecreasedStockPrice() {
		int count = 0;
		for(int i=0;i<noOfCompanies;i++) {
			if(companies[i].priceIncreased == false)
				count++;
			
		}
		System.out.println("Total no of companies whose stock price declined today : "+count);
		
		
	}

	private static void displayIncreasedStockPrice() {
		int count = 0;
		for(int i=0;i<noOfCompanies;i++) {
			if(companies[i].priceIncreased == true)
				count++;
		}
		System.out.println("Total no of companies whose stock price rose today : "+count);
		
	}

	private static void printStockInDescending() {
		System.out.println("Stocks in Descending Order : ");
		for(int j=noOfCompanies-1;j>=0;j--) {
			System.out.println(companies[j].sharePrice);
		}
		
	}

	private static void printStockInAscending() {
		System.out.println("Stocks in Ascending Order : ");
		for(int i=0;i<noOfCompanies;i++) {
			System.out.println(companies[i].sharePrice);
		}
		
	}

}
