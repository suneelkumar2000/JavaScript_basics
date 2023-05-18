package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cys.food_order.model.Order;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class OrderImpl implements OrderDAO {

	Validation val = new Validation();
	Date date=new Date();
	java.sql.Date sqldate=new java.sql.Date(date.getTime());
	
	@Override
	public int insertOrder(Order order) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into orders(food_id,quantity) values(?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		
		boolean foodId = val.numberValidation(order.getFoodId());
		boolean quantity = val.numberValidation(order.getQuantity());
		
		if (foodId == true && quantity == true) {
		ps.setInt(1, order.getFoodId());
		ps.setInt(2, order.getQuantity());
		int execute = ps.executeUpdate();
		return execute;
		} else
			return 0;
	}

	@Override
	public int updateOrderQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update orders set quantity=? where id=?";
		PreparedStatement ps = con.prepareStatement(update);
		boolean num = val.numberValidation(id);
		boolean quan = val.numberValidation(quantity);
		if (num == true && quan == true) {
			ps.setInt(1, quantity);
			ps.setInt(2, id);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate;
		} else
			return 0;
	}

	@Override
	public int deleteOrder(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from orders where id=?";
		PreparedStatement ps = con.prepareStatement(delete);

		boolean num = val.numberValidation(id);
		if (num == true) {
			ps.setInt(1, id);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate;
		} else
			return 0;
	}

	@Override
	public List<Order> orderList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,food_id,quantity from orders";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<Order> orderList = new ArrayList<Order>();
		while (rs.next()) {
			int id = rs.getInt(1);
			int foodId = rs.getInt(2);
			int quantity = rs.getInt(3);
			Order order = new Order();
			order.setId(id);
			order.setFoodId(foodId);
			order.setQuantity(quantity);
			orderList.add(order);
		}
		return orderList;
	}

	@Override
	public int showId(Order order) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id from orders where food_id=?,quantity=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, order.getFoodId());
		ps.setInt(2, order.getQuantity());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			return id;
		}
		return 0;
	}
}
