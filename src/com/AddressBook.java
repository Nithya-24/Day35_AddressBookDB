package com;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	
	public static void main(String[] args) {

		System.out.println("Address Book");
		/**
		 * creating an array list to store the Address
		 */

		List<Contact> contact = new ArrayList<>();                                  
		
		Contact newContact = new Contact("Nithya", "R", "Satchiyapuram Road", "Sivakasi", "TamilNadu", 626130, "9876543210", "nithyaramadoz@gmail.com");                                                                       // created a object
		
		/**
		 * Adding a new Contact to the Address Book
		 */
		// contact.add(newContact); 
		
		/**
		 * Creating Object to access the class
		 **/
		 
		AddressBookService addnew = new AddressBookService(); 
		
		addnew.addContact(contact);  
		System.out.println(contact);
		
	}

}