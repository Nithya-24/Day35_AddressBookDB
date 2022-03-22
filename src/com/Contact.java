package com;

public class Contact {
	
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private int zip;
		private String phoneNumber;
		private String email;

		public Contact(String firstName, String lastName, String address, String city, String state, int zip,      
				String phoneNumber, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.phoneNumber = phoneNumber;
			this.email = email;
		}

		@Override
		public String toString() {                                                                                      
			return "Contact: firstName=" + firstName + "\n lastName=" + lastName + "\n address=" + address + "\n city="
					+ city + "\n state=" + state + "\n zip=" + zip + "\n phoneNumber=" + phoneNumber + "\n email=" + email + "\n";
		}

	}