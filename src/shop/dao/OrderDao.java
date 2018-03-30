package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.dto.OrderDto;
import shop.dto.ProductDto;
import shop.sql.SqlStrings;

public class OrderDao {

	public static int makeOrder(String name, String email, String mobile, String address, ArrayList<ProductDto> cart , int cartValue) {
		int orderNo = -1;
		Connection con = CommonDao.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SqlStrings.insertOrder);
			pst.setDouble(1, cartValue);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setString(4, mobile);
			pst.setString(5, address);
			pst.executeUpdate();
			ResultSet rs = con.createStatement().executeQuery(SqlStrings.maxId_orders);
			if (rs.next()) {
				orderNo = rs.getInt(1);
			}
			for(ProductDto p : cart){
				pst = con.prepareStatement(SqlStrings.insertOrderDetails);
				pst.setInt(1, orderNo);
				pst.setInt(2, p.getId());
				pst.setInt(3, p.getQuantity());
				pst.setInt(4, p.getPrice());
				pst.setInt(5, p.getPrice()*p.getQuantity());
				pst.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderNo;
	}
	
	public static int getTotalCount() {
		try {
			ResultSet rs = CommonDao.getConnection().createStatement().executeQuery("SELECT COUNT(id) FROM orders");
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static ArrayList<OrderDto> getAllOrders(){
		try {
			ResultSet rs = CommonDao.getConnection().prepareStatement(SqlStrings.getAllOrders).executeQuery();
			ArrayList<OrderDto> list = new ArrayList<>();
			while(rs.next()){
				list.add(new OrderDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static OrderDto getOrder(int id) {
		if (id > 0) {
			try {
				PreparedStatement ps = CommonDao.getConnection().prepareStatement(SqlStrings.getOrderDetails);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return new OrderDto(0, "", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static ArrayList<ProductDto> getOrder_productList(int orderid) {
		if (orderid > 0) {
			try {
				PreparedStatement pst = CommonDao.getConnection().prepareStatement(SqlStrings.getOrder_productList);
				pst.setInt(1, orderid);
				ResultSet rs = pst.executeQuery();
				ArrayList<ProductDto> list = new ArrayList<>();
				while(rs.next()){
					ProductDto p = ProductDao.getProduct(rs.getInt(1));
					p.setQuantity(rs.getInt(2));
					p.setPrice(rs.getInt(3));
					list.add(p);
				}
				if (list.size() > 0) {
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
