package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookRepo {
	static final String URL = "jdbc:mysql://localhost:3306/addressbookservices";
	static final String USER_NAME = "root";
	
	//To establish the connection
	static Connection connection = null;
	private static AddressBookRepo config = new AddressBookRepo();
	
	/**
	 * Method to establish the connection
	 *  We are using the connection interface and then using the Driver Manager class and get connection method to establish the connection.
	 *  We are using the MySql driver.
	 */
	AddressBookRepo() {
		try {
			//load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER_NAME, "Nithya1234@");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static AddressBookRepo getInstance() {
		return config;
	}

    public static List<Contacts> retrieveData() {
        ResultSet resultSet = null;
        List<Contacts> addressBookList = new ArrayList<Contacts>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from addressbook";
            resultSet = statement.executeQuery(sql);
          //  int count = 0;
            while (resultSet.next()) {
                Contacts contactInfo = new Contacts();
               
                contactInfo.setFirstName(resultSet.getString("firstName"));
                contactInfo.setLastName(resultSet.getString("Lastname"));
                contactInfo.setAddress(resultSet.getString("address"));
                contactInfo.setCity(resultSet.getString("city"));
                contactInfo.setState(resultSet.getString("state"));
                contactInfo.setZip(resultSet.getInt("zip"));
                contactInfo.setPhoneNumber(resultSet.getString("phoneNumber"));
                contactInfo.setEmailId(resultSet.getString("email"));
//                contactInfo.setBookName(resultSet.getString("bookName"));
//                contactInfo.setContactType(resultSet.getString("contactType"));
//                contactInfo.setDateAdded(resultSet.getDate("Date_added").toLocalDate());

                addressBookList.add(contactInfo);
            }
        } catch (SQLException e) {
        	 e.printStackTrace();
        }
        return addressBookList;

    }
    /**
     * Here Updating the AddressBook Database using FirstName
     * @param address
     * @param firstName
     */
    public void updateCityByFirstName(String address, String firstName) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "UPDATE addressbook SET address = 'ttL' WHERE FirstName = 'XYZ' " ;
            int result = statement.executeUpdate(query);
            System.out.println(result);
            if (result > 0) {
                System.out.println("Address Updated Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}