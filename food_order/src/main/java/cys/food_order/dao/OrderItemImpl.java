package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.food_order.model.OrderItem;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class OrderItemImpl implements OrderItemDAO {

	Validation val = new Validation();

	@Override
	public int insertOrder(int customerId) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		String insert = "INSERT INTO Orderiteam (customer_id,food_id,quantity)SELECT customer_id,food_id,quantity from orders where customer_id=?";
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1, customerId);
		int execute = ps.executeUpdate();
		return execute;

	}

	@Override
	public int deleteOrder(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from Orderiteam where order_id=?";
		PreparedStatement ps = con.prepareStatement(delete);

		ps.setInt(1, id);

		int execute = ps.executeUpdate();
		return execute;
	}
}
