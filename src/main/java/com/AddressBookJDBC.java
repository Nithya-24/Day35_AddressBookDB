package com;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AddressBookJDBC {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
        	  System.out.println(" Press\n 1 ->  Retrieve data\n 2 -> Update Address by Name\n 3 -> Retrieve data for particular Period\n" + 
        	  		 " 4 -> Retrieve Count of Contacts for City or State\n   5 -> exit\n");
              int choice = scanner.nextInt();
              switch (choice) {
                  case 1:
                      retrieveData();
                      break;
                  case 2:
                      updateAddress();
                      break;
                  case 3:
                      reteriveDataForParticularDate();
                      break;
                  case 4:
                      retrieveCountByCityOrState();
                      break;
                  case 5:
                      exit = true;
              }
          }
      }

    static void retrieveData() {
        AddressBookRepo addressBookRepo = new AddressBookRepo();
        List<Contacts> employeeInfoList = addressBookRepo.retrieveData();
        for (Contacts employee : employeeInfoList ) {
            System.out.println(employee + "\n");
        }
    }
    private static void updateAddress() {
        AddressBookRepo addressBookRepo = new AddressBookRepo();
        System.out.println("Enter the address and FirstName  to Update");
        addressBookRepo.updateCityByFirstName(scanner.next(), scanner.next());
    
    }
    
    private static void reteriveDataForParticularDate() {
        AddressBookRepo addressBookRepo = new AddressBookRepo();
        System.out.println("Enter the Date of Joining (YYYY-MM-DD");
        System.out.println("Enter year , month and Day");
        List<Contacts> employeeInfoList = addressBookRepo.findAllForParticularDate(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        for (Contacts employee : employeeInfoList ) {
            System.out.println(employee + "\n");
        }
    }
    private static void retrieveCountByCityOrState() {
        AddressBookRepo addressBookRepo = new AddressBookRepo();
        System.out.println("Enter 1 -> Contacts count by City\n" +
                "2 -> Contacts count by State");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter city Name");
                int cityContactsCount = addressBookRepo.countByCiy(scanner.next());
                System.out.println("Number of Contacts is Given city= " + cityContactsCount);
                break;
            case 2:
                System.out.println("Enter state name");
                int stateContactsCount=  addressBookRepo.countByState(scanner.next());
                System.out.println("Number of Contacts is Given state= " + stateContactsCount);
                break;
        }


    }
    
}