package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.FoodItem;

public interface FoodItemDAO {
	public int insertFoodDetails(FoodItem food)throws ClassNotFoundException, SQLException;
	public int updateQuantity(int id,int quantity)throws ClassNotFoundException, SQLException;
	public int updatePrice(int id, int price) throws ClassNotFoundException, SQLException;
	public int updateCategory(int id,String category) throws ClassNotFoundException, SQLException;
	public int deleteFoodDetails(int id)throws ClassNotFoundException, SQLException;
	public List<FoodItem> foodList()throws ClassNotFoundException, SQLException;
	public int selectQuantity(int id)throws ClassNotFoundException, SQLException;
	public int reduceQuantity(int id) throws ClassNotFoundException, SQLException;
}
