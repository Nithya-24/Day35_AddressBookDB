package com;

import java.util.List;
import java.util.Scanner;


public class AddressBookService {
	

	public void addContact(List<Contact> contact) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();

		System.out.print("Please enter the last name: ");
		String lastName = scan.next();

		System.out.print("Please enter the address: ");
		String address = scan.next();

		System.out.print("Please enter the city: ");
		String city = scan.next();

		System.out.print("Please enter the state: ");
		String state = scan.next();

		System.out.print("Please enter the zip: ");
		int zip = scan.nextInt();

		System.out.print("Please enter the phone number: ");
		String phoneNumber = scan.next();

		System.out.print("Please enter the email: ");
		String email = scan.next();
 
		/**
		 * here it add the contact List which is given in console by the User
		 */
		Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		contact.add(newContact);

	}
}
