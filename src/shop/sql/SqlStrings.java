package shop.sql;

public interface SqlStrings {
	public static String loginSql = "Select userid from users where userid=? and pwd=?";
	public static String getProductsByPage = "SELECT id, name, details, price, imageLink FROM products ORDER BY create_date DESC LIMIT ?,5";
	public static String totalRecordsSql = "SELECT COUNT(id) FROM products";
	public static String getProductById = "SELECT id, name, details, price, imageLink FROM products WHERE id=?";
	public static String getUserByUserid = "SELECT id, userid, name, email, userRole, isActive FROM users WHERE userid = ?";
	public static String insertOrder = "INSERT INTO orders(orderDate, totalAmount, cust_name, cust_email, cust_mobile, cust_address) VALUES(CURRENT_DATE, ?, ?, ?, ?, ? )";
	public static String getCartByUser_id = "SELECT cd.productid, cd.quantity FROM cart c INNER JOIN cart_details cd ON c.user_id=?";
	public static String maxId_orders = "SELECT MAX(id) FROM orders";
	public static String insertOrderDetails = "INSERT INTO order_details(orderid, productid, quantity, price, amount) VALUES(?, ?, ?, ?, ?)";
	public static String getNewPid = "SELECT MAX(id) FROM products";
	public static String updateProduct = "UPDATE products SET name=?, details=?, price=?, imageLink=? WHERE id=?";
	public static String getAllOrders = "SELECT `id`, `orderDate`, `totalAmount`, `cust_name`, `cust_email`, `cust_mobile`, `cust_address` FROM `orders` ORDER BY id DESC";
	public static String getOrderDetails = "SELECT `productid`, `quantity`, `price` FROM `order_details` WHERE orderid = ?";
	
	
}