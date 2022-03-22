package com;

import java.util.*;

public class AddressBook {
	
	public static void main(String[] args) {

		System.out.println("Address Book");
		/**
		 * creating an array list to store the Address
		 */

	//	List<Contact> contact = new ArrayList<>();                                  
		
	//	Contact newContact = new Contact("Nithya", "R", "Satchiyapuram Road", "Sivakasi", "TamilNadu", 626130, "9876543210", "nithyaramadoz@gmail.com");                                                                       // created a object
		
		/**
		 * Adding a new Contact to the Address Book
		 */
		// contact.add(newContact); 
		
		/**
		 * Creating Object to access the class
		 **/
		 
		AddressBookService addnew = new AddressBookService(); 
		Scanner sc=new Scanner(System.in);
		
		addnew.addContact();  
		while (true) {
			System.out.println("Enter your choice:\n 1. Add Contact\n 2. Edit Contact 4. Exit ");
			int choice= sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the contact detais to add in the Address Book: ");
				addnew.addContact();
				
				break;
			case 2:
				System.out.println("Enter the detais to edit: ");
				addnew.editContact();
				
				break;
				
			case 3:
				System.out.println("Exit : ");
				sc.close();
				return;
				
			}
		}
		// System.out.println(contact);
		
	}

}