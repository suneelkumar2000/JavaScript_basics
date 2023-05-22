package cys.food_order.model;

import java.sql.Date;

public class Order {
	private int customerId;
	private int quantity;
	private int foodId;
	private int amount;

	public Order() {
	}

	public Order(int customerId, int foodId, int quantity,int amount) {
		this.customerId = customerId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.amount=amount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override

	public String toString() {
		return "Order [customerId = " + customerId + " food id = " + foodId + ", quantity = " + quantity + ", amount = " + amount + "]";
	}

	
}
