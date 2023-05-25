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
		String insert = "insert into orders(customer_id,food_id,quantity,amount) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		
		boolean customerId = val.numberValidation(order.getCustomerId());
		boolean foodId = val.numberValidation(order.getFoodId());
		boolean quantity = val.numberValidation(order.getQuantity());
		boolean amount = val.numberValidation(order.getAmount());
		
		if (amount == true && customerId == true && foodId == true && quantity == true) {
		ps.setInt(1,order.getCustomerId());
		ps.setInt(2, order.getFoodId());
		ps.setInt(3, order.getQuantity());
		ps.setInt(4, order.getAmount());
		int execute = ps.executeUpdate();
		return execute;
		} else
			return 0;
	}

	@Override
	public int updateOrderQuantity(int id, int quantity,int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update orders set quantity=? where food_id=? and customer_id=?";
		PreparedStatement ps = con.prepareStatement(update);
		boolean num = val.numberValidation(id);
		boolean quan = val.numberValidation(quantity);
		if (num == true && quan == true) {
			ps.setInt(1, quantity);
			ps.setInt(2, id);
			ps.setInt(3, customerId);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate;
		} else
			return 0;
	}
	@Override
	public int updateAmount(int amount, int fooodId,int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update orders set amount=? where food_id=? and customer_id=?";
		PreparedStatement ps = con.prepareStatement(update);
		boolean amo = val.numberValidation(amount);
		boolean fi = val.numberValidation(fooodId);
		if (amo == true && fi == true) {
			ps.setInt(1, amount);
			ps.setInt(2, fooodId);
			ps.setInt(3, customerId);
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
	public int deleteOrderByCustomer(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from orders where customer_id=?";
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
		String display = "select id,food_id,quantity,amount from orders";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<Order> orderList = new ArrayList<Order>();
		while (rs.next()) {
			int customer_id = rs.getInt(1);
			int foodId = rs.getInt(2);
			int quantity = rs.getInt(3);
			int amount = rs.getInt(4);
			Order order = new Order();
			order.setCustomerId(customer_id);
			order.setFoodId(foodId);
			order.setQuantity(quantity);
			order.setAmount(amount);
			orderList.add(order);
		}
		return orderList;
	}
	
	@Override
	public int findFoodId(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select food_id from orders where customer_id=?";
		PreparedStatement ps = con.prepareStatement(find);
		ps.setInt(1, customerId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int foodId = (rs.getInt(1));
			return foodId;
		}
		return 0;
	}
	@Override
	public int selectQuantity(int foodId,int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select quantity from orders where food_id=? and customer_id=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, foodId);
		ps.setInt(2, customerId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int quantity= rs.getInt(1);
			return quantity;
		}
		return 0;
	}
}
