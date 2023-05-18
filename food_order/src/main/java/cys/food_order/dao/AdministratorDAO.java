package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.Administrator;

public interface AdministratorDAO {
	public int insertAdministratorDetails(Administrator admin)throws ClassNotFoundException, SQLException;
	public int showAdminId(String userName) throws ClassNotFoundException, SQLException;
	public boolean adminLogin(String userName,String password) throws ClassNotFoundException, SQLException;
}
