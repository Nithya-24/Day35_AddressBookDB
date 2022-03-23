package com;

import java.util.List;
import java.util.*;
import java.util.ArrayList;


public class AddressBookService {
	
	Scanner sc = new Scanner(System.in);	

	List<Contact> contacts = new ArrayList<Contact>();
	/**
	 * Check that no duplicate entry for the Address Book
	 * if first name equals the given name mean, it display Name already exist 
	 * or else it add to the contactDetails
	 */
	
	Map<String, AddressBookService> addressBookMap = new HashMap<>(); 
	public static HashMap<String, ArrayList<Contact>> personByCity  = new HashMap<String, ArrayList<Contact>>();
	public static HashMap<String, ArrayList<Contact>> personByState = new HashMap<String, ArrayList<Contact>>();
	Contact person = new Contact();
	
	public void duplicateCheck() {  
		System.out.print(" Please enter the first name: ");
		String name = sc.next();
		for(Contact i : contacts) {
		   if(i.getFirstName().equals(name)) {
			   System.out.println(" Given name already exist");
			   return;
		   } 
        }  addContactDetails();
	}
	
	/**
	 * adding Multiple Contact Details from the  User
	 */
	
	public void addContact() {                                                           
		System.out.println("Enter the number of contacts you want to enter");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter the contact details of person ");
            addContactDetails();
        }
	}
	
	public void addContactDetails() {

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
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setPhoneNumber(phoneNumber);
		person.setEmail(email);
		person.setCity(city);
		person.setState(state);
		person.setZip(zip);
		addPersonToCity(person);
		addPersonToState(person);
		
		contacts.add(person);
		
	}
	/**
	 * to find the contact using duplicate 
	 * @return
	 */
	public Contact findContact() {                                       
		System.out.println("\n Enter the first name of the contact to edit: ");
		String name = sc.next();
		int duplicate = 0;                                                
		Contact temp = null;
		for (Contact contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				duplicate++;
				temp = contact;
			}
		}
		if (duplicate == 1) {
			return temp;

		} else if( duplicate > 1) {
			System.out.print(" There are multiple contacts with given name.\n Please enter their email id: ");
			String email = sc.next();
			for (Contact contact : contacts) {
				if (contact.getFirstName().equals(name) && contact.getEmail().equals(email)) {
					return contact;
				}
			}
		}
		else{
			System.out.println("No contact with the given first name. Please enter the correct first name");
			findContact();
		}
		return temp;
	} 
		
	/**
	 * Edit the contact by findContact()
	 * and after finding we may edit the existing contact with new Value
	 */
		public void editContact() {

			Contact contact = findContact();

			System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
					+ "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit zipcode"
					+ "\n 7.Edit phone number"  + "\n 8.Edit email");

			int choice = sc.nextInt();                                
			switch (choice) {
			case 1:
				System.out.println("Enter new first name");
				String newFirstName = sc.next();
				contact.setFirstName(newFirstName);
				System.out.println("new first name updated");

				break;
			case 2:
				System.out.println("Enter new last name");
				String newLastName = sc.next();
				contact.setLastName(newLastName);
				System.out.println("new last name updated");

				break;
			case 3:
				System.out.println("Enter new address");
				String newAddress = sc.next();
				contact.setAddress(newAddress);
				System.out.println("new newaddress updated");

				break;
			case 4:
				System.out.println("Enter new city");
				String newCity = sc.next();
				contact.setCity(newCity);
				System.out.println("new city updated");

				break;
			case 5:
				System.out.println("Enter new state");
				String newState = sc.next();
				contact.setState(newState);
				System.out.println("new state updated");

				break;
			case 6:
				System.out.println("Enter new zip code");
				int newZipCode = sc.nextInt();
				contact.setZip(newZipCode);
				System.out.println("new zip code updated");
				break;
				
			case 7:
				System.out.println("Enter new phone number");
				String newPhoneNumber = sc.next();
				contact.setPhoneNumber(newPhoneNumber);
				System.out.println("new phone number updated");

				break;
				
			case 8:
				System.out.println("Enter new email");
				String newEmail = sc.next();
				contact.setEmail(newEmail);
				System.out.println("new email updated");

				break;

			default:
				System.out.println("Please enter a number between 1 to 8 only...");
				break;
			}
			System.out.println("The updated contact is  : " + contact);
		}
			
			public void displayContact() {                                                       
				System.out.println(contacts);
		}
			/**
			 * delete the Contact by findContact()
			 * 
			 */
			public void deleteContact() {                                                                      
				Contact contact = findContact();
				if (contact == null) {
					System.out.println("No contact found with the given name");
					return;
				}
				contacts.remove(contact);                                                                     
				System.out.println("The contact is deleted from the Address Book");
			}
			
			
			public void addPersonToCity(Contact contact) {
				if (personByCity.containsKey(contact.getCity())) {
					personByCity.get(contact.getCity()).add(contact);
				}
				else {
					ArrayList<Contact> cityList = new ArrayList<Contact>();
					cityList.add(contact);
					personByCity.put(contact.getCity(), cityList);
				}
			}


			/**
			 *  In this method we are checking the person by state
			 * @param contact- We are parsing the contact there
			 */
			public void addPersonToState(Contact contact) {
				if (personByState.containsKey(contact.getState())) {			
					personByState.get(contact.getState()).add(contact);
				}
				else {
					ArrayList<Contact> stateList = new ArrayList<Contact>();
					stateList.add(contact);
					personByState.put(contact.getState(), stateList);
				}
			}

	
}
