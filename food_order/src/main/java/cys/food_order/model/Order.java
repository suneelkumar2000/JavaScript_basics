package cys.food_order.model;

import java.sql.Date;

public class Order {
	private int id;
	private int quantity;
	private int foodId;

	public Order() {
	}

	public Order(int id, int foodId, int quantity) {
		this.id = id;
		this.foodId = foodId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override

	public String toString() {
		return "Order [id = " + id + " food id = " + foodId + ", quantity = " + quantity + "]";
	}
}
