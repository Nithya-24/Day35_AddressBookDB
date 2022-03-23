package com;

import java.util.*;

public class AddressBook {
	
	public static void main(String[] args) {

		System.out.println("Address Book");
		/**
		 * creating an array list to store the Address
		 */

		List<Contact> contact = new ArrayList<>();                                  
		
	//	Contact newContact = new Contact("Nithya", "R", "Satchiyapuram Road", "Sivakasi", "TamilNadu", 626130, "9876543210", "nithyaramadoz@gmail.com");                                                                       // created a object
		
		/**
		 * Adding a new Contact to the Address Book
		 */
		// contact.add(newContact); 
		
		/**
		 * Creating Object to access the class
		 **/
		 
		AddressBookService addnew = new AddressBookService();
		MultipleAddressBook obj = new MultipleAddressBook();
		Scanner sc = new Scanner(System.in);



		while (true) {
			System.out.println("Enter \n 1. To add the new AddressBook\n 2. To add contact in AddressBook\n "
					+ "3. To edit the contact in AddressBook\n 4. To delete the contact in AddressBook\n 5. To delete the AddressBook\n "
					+ "6. To Print the AddressBook\n 7. To Print the contacts in AddressBook\n 8. Search Person By City. \n 9. Search Person by State \n 10. View Person by City"
					+ "\n 11. View Person by State \n 12. Count People \n 13.Sort By Person Name \n 14. To exit");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				obj.addAddressBook();
				break;
			case 2:
				obj.addContact();
				break;
			case 3:
				obj.editContactInBook();
				break;
			case 4:
				obj.deleteContactInBook();
				break;
			case 5:
				obj.deleteAddressBook();
				break;
			case 6:
				obj.printBook();
				break;
			case 7:
				obj.printContactsInBook();
				break;
			case 8:
				obj.searchByCity();
				break;
			case 9:
				obj.searchByState();
				break;
			case 10:
				obj.displayPeopleByRegion(AddressBookService.personByCity);
				break;
			case 11:
				obj.displayPeopleByRegion(AddressBookService.personByState);
				break;
			case 12:
				System.out.println("Enter \n1.Display By City\n2.Display By State");
				int countChoice = sc.nextInt();
				if(countChoice==1)
					obj.countPeopleByRegion(AddressBookService.personByCity);
				else 
					obj.countPeopleByRegion(AddressBookService.personByState);
				break;
			case 13:
				obj.sortAddressBook();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Enter the wrong input");
			}
		}
	}
}