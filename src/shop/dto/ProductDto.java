package shop.dto;

public class ProductDto {
	private int id;
	private String name;
	private String details;
	private int price;
	private String imageLink;
	private String create_date;
	private int quantity;
	
	public ProductDto(int id) {
		this.id = id;
	}
	
	public ProductDto(int id, String name, String details, int price, String imageLink) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.price = price;
		this.imageLink = imageLink;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getCreate_date() {
		return create_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		return this.id == ((ProductDto)obj).id;
	}
}
