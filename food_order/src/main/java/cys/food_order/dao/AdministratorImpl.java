package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cys.food_order.model.Administrator;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class AdministratorImpl implements AdministratorDAO {
	Validation val = new Validation();

	@Override
	public int insertAdministratorDetails(Administrator admin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into administrator(name,user_name,password) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean name = val.nameValidation(admin.getName());

		if (name == true) {
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getUserName());
			ps.setString(3, admin.getPassword());
			int execute = ps.executeUpdate();

			return execute;
		} else
			return 0;
	}

	@Override
	public int showAdminId(String userName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		boolean user = val.usernameValidation(userName);
		if (user == true) {
			String customerId = "select id from administrator where user_name=?";
			PreparedStatement ps1 = con.prepareStatement(customerId);
			ps1.setString(1, userName);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				return id;
			}
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean adminLogin(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select password from administrator where user_name=?";
		PreparedStatement ps = con.prepareStatement(find);
		ps.setString(1, userName);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String pass = rs.getString(1);
			if (password.equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
