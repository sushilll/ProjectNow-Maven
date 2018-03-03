package shop.dto;

public class OrderDto {
	private int id;
	private String orderDate;
	private int totalAmount;
	private String cust_name;
	private String cust_email;
	private String cust_mobile;
	private String cust_address;
	
	public OrderDto(int id) {
		this.id = id;
	}

	public OrderDto(int id, String orderDate, int totalAmount, String cust_name, String cust_email, String cust_mobile,
			String cust_address) {
		this.id = id;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.cust_name = cust_name;
		this.cust_email = cust_email;
		this.cust_mobile = cust_mobile;
		this.cust_address = cust_address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
}
