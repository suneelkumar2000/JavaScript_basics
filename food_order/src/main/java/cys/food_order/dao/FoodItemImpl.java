package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.food_order.model.FoodItem;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class FoodItemImpl implements FoodItemDAO {

	Validation val = new Validation();

	@Override
	public int insertFoodDetails(FoodItem food) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into fooditem(name,quantity,unit_price,item_category) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean name = val.nameValidation(food.getName());
		boolean quantity = val.numberValidation(food.getQuantity());
		boolean unitPrice = val.numberValidation(food.getUnitPrice());
		boolean itemCategory = val.nameValidation(food.getItemCategory());

		if (name == true && quantity == true && unitPrice == true && itemCategory == true) {
			ps.setString(1, food.getName());
			ps.setInt(2, food.getQuantity());
			ps.setInt(3, food.getUnitPrice());
			ps.setString(4, food.getItemCategory());

			int execute = ps.executeUpdate();
			return execute;
		} else
			return 0;
	}

	@Override
	public int updateQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update fooditem set quantity =? where id=?";
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
	public int updatePrice(int id, int price) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update fooditem set unit_price =? where id=?";
		PreparedStatement ps = con.prepareStatement(update);
		boolean num = val.numberValidation(id);
		boolean prices = val.numberValidation(price);
		if (num == true && prices == true) {
			ps.setInt(1, price);
			ps.setInt(2, id);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate;
		} else
			return 0;
	}

	@Override
	public int updateCategory(int id, String category) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update fooditem set item_category =? where id=?";
		PreparedStatement ps = con.prepareStatement(update);
		boolean num = val.numberValidation(id);
		boolean categorys = val.nameValidation(category);
		if (num == true && categorys == true) {
			ps.setString(1, category);
			ps.setInt(2, id);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate;
		} else
			return 0;
	}

	@Override
	public int deleteFoodDetails(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from fooditem where id=?";
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
	public List<FoodItem> foodList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,name,quantity,unit_price,item_category from fooditem";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int quantity = rs.getInt(3);
			int unitPrice = rs.getInt(4);
			String itemCategory = rs.getString(5);
			FoodItem food = new FoodItem();
			food.setId(id);
			food.setName(name);
			food.setQuantity(quantity);
			food.setUnitPrice(unitPrice);
			food.setItemCategory(itemCategory);
			foodList.add(food);
		}
		return foodList;
	}

	@Override
	public int selectQuantity(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select quantity from fooditem where id=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int quantity = rs.getInt(1);
			return quantity;
		}
		return 0;
	}

	public int reduceQuantity(int customerId) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		String find = "select food_id from orders where customer_id=?";
		PreparedStatement ps = con.prepareStatement(find);
		ps.setInt(1, customerId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int foodId = (rs.getInt(1));
			String find1 = "select quantity from fooditem where id=?";
			PreparedStatement ps1 = con.prepareStatement(find1);
			ps1.setInt(1, foodId);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int foodQuantity = rs1.getInt(1);
				String find2 = "select quantity from orders where food_id=?";
				PreparedStatement ps2 = con.prepareStatement(find2);

				ps2.setInt(1, foodId);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					int orderQuantity = rs2.getInt(1);
					int newQuantity = foodQuantity - orderQuantity;
					String update = "update fooditem set quantity =? where id=?";
					PreparedStatement ps3 = con.prepareStatement(update);
					ps3.setInt(1, newQuantity);
					ps3.setInt(2, foodId);
					int executeUpdate = ps3.executeUpdate();
					return executeUpdate;
				}
			}
		}
		return 0;
	}

}
