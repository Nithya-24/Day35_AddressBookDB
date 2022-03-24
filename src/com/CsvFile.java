package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvFile {

	public static void readCSVfileUsingScanner(String filePath) {
		/**
		 * try catch block to check file exists or not
		 */
		try {
			/**
			 * Scanning the file path
			 */
			Scanner sc = new Scanner(new File(filePath));

			/**
			 * creating a loop to pop out every string values
			 */
			while (sc.hasNext()) {
				System.out.println("User data  :" + sc.next().toString());
			}
			sc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * created method to write in csv file
	 */
	public static void writeCSVfileUsingScanner() {
		Scanner sc = new Scanner(System.in);
		File file = new File("D:\\Users\\eclipse-workspace\\Day24\\src\\com\\Book.csv");

		/**
		 * try catch block to check file exists or not
		 */
		try {
			/**
			 * creation object of file writer
			 */
			FileWriter fileWriter = new FileWriter(file);

			/**
			 * creating object of print writer
			 */
			PrintWriter printWriter = new PrintWriter(fileWriter);

			System.out.println("Enter the First name :");
			String fName = sc.nextLine();
			System.out.println("Enter the Last name :");
			String lName = sc.nextLine();
			System.out.println("Enter the Address :");
			String address = sc.nextLine();
			System.out.println("Enter the city :");
			String city = sc.nextLine();
			System.out.println("Enter the state :");
			String state = sc.nextLine();
			System.out.println("Enter the zipCode :");
			String zipcode = sc.nextLine();
			System.out.println("Enter the phoneNumber :");
			String phoneNumber = sc.nextLine();
			System.out.println("Enter the emailID :");
			String emailId = sc.nextLine();

			printWriter.print(fName);
			printWriter.print(",");
			printWriter.print(lName);
			printWriter.print(",");
			printWriter.print(address);
			printWriter.print(",");
			printWriter.print(city);
			printWriter.print(",");
			printWriter.print(state);
			printWriter.print(",");
			printWriter.print(zipcode);
			printWriter.print(phoneNumber);
			printWriter.print(",");
			printWriter.print(emailId);

			printWriter.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		/**
		 * Switch Cases to make a choice for user
		 */
		while (true) {
			System.out.println("Enter \n 1.Read csv file \n2.Write csv file \n3.exit");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {

			/**
			 * calling Static method to read and write
			 */
			case 1:
				readCSVfileUsingScanner("D:\\Users\\eclipse-workspace\\Day24\\src\\com\\CSV_Book1.csv");

				break;
			case 2:
				writeCSVfileUsingScanner();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input");
			}
		}

	}
}