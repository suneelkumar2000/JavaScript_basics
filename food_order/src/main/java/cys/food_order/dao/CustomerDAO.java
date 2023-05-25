package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.Customer;

public interface CustomerDAO {
	public int insertCustomerDetails(Customer customer)throws ClassNotFoundException, SQLException;
	public int findCustomerId(String userName)throws ClassNotFoundException, SQLException;
	public boolean customerLogin(String userName,String password) throws ClassNotFoundException, SQLException;
	public String findEmail(int id) throws ClassNotFoundException, SQLException ;
	public boolean paymentLogin(int customerId,String userName, String password) throws ClassNotFoundException, SQLException;
}
