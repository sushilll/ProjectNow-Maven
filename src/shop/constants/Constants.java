package shop.constants;

import java.util.HashMap;

public class Constants {
	public static HashMap<String, String> Guest_menu;
	public static HashMap<String, String> User_menu;
	public static HashMap<String, String> Employee_menu;
	public static HashMap<String, String> Manager_menu;
	
	static{
		Guest_menu = new HashMap<>();
		Guest_menu.put("Home", "home");
		Guest_menu.put("Product List", "productlist");
		Guest_menu.put("My Cart", "cart");
		
		User_menu = new HashMap<>(Guest_menu);
		
		Employee_menu = new HashMap<>(User_menu);
		Employee_menu.put("Order List", "orders");
		
		Manager_menu = new HashMap<>(Employee_menu);
		Employee_menu.put("Add New Product", "addproduct");		
	}
	
	public static HashMap<String, String> getMenu(String usertype) {
		HashMap<String, String> menu;
		switch (usertype) {
		case "Guest":
			menu = Constants.Guest_menu;
			break;
		case "Employee":
			menu = Constants.Employee_menu;
			break;
		case "Manager":
			menu = Constants.Manager_menu;
			break;
		default:
			menu = Constants.User_menu;
			break;
		}
		return menu;
	}
	 
}
