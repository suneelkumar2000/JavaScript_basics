package cys.food_order.model;

public class Customer {
	private Integer id;
	private String email;
	private Long phoneNumber;
	private String userName;
	private String password;

	public Customer() {
	}

	public Customer(Integer id, String email, Long phoneNumber, String userName, String password) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber =phoneNumber;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Customers [Customer id= " + id + ", email= " + email + ", Phone Number = " + phoneNumber + ", userName = " + userName + ", password = " + password +"]";
	}
}
