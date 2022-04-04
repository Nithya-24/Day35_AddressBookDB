package com;

import java.util.List;
import java.util.Scanner;

public class AddressBookJDBC {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
        	  System.out.println(" Press\n 1 ->  Retrieve data\n 2 -> Update Address,city,state,zip  by FirstName\n 3 -> exit");
              int choice = scanner.nextInt();
              switch (choice) {
                  case 1:
                      retrieveData();
                      break;
                  case 2:
                      updateAddress();
                      break;
                  case 3:
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
}