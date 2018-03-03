package shop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.dto.ProductDto;
import shop.sql.SqlStrings;

public class CartDao {
	
	public static ArrayList<ProductDto> getCart(int user_id) {
		if (user_id > 0) 
			try {
				PreparedStatement pst = CommonDao.getConnection().prepareStatement(SqlStrings.getCartByUser_id);
				pst.setInt(1, user_id);
				ResultSet rs = pst.executeQuery();
				ArrayList<ProductDto> list = new ArrayList<>();
				while(rs.next()){
					ProductDto dto = ProductDao.getProduct(rs.getInt(1));
					dto.setQuantity(rs.getInt(2));
					list.add(dto);
				}
				if (!list.isEmpty()) {
					return list;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public static boolean updateCart(int user_id,ArrayList<ProductDto> cart){
		
		return false;
	}
}
