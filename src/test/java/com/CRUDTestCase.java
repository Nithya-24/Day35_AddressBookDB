package com;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Test;

public class CRUDTestCase {

	@Test
	/**
	 * To check the count in database is matching in java program or not
	 */
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
		// AddressBookRepo addressBookRepo = new AddressBookRepo();
		java.util.List<Contacts> employeePayrollData = AddressBookRepo.retrieveData();
		equals(employeePayrollData);
	}
	



}
