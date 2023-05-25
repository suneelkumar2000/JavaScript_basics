package cys.food_order.model;

public class OrderItem {
	private int customerId;
	private int quantity;
	private int foodId;
	

	public OrderItem() {
	}

	public OrderItem(int customerId, int foodId, int quantity) {
		this.customerId = customerId;
		this.foodId = foodId;
		this.quantity = quantity;
		
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
	@Override

	public String toString() {
		return "OrderItem [customerId = " + customerId + " food id = " + foodId + ", quantity = " + quantity +"]";
	}
}
