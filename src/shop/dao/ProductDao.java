package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import shop.dto.ProductDto;
import shop.pagination.Pagination;
import shop.sql.SqlStrings;

public class ProductDao {

	public static Pagination getPage(int currentPage) throws Exception {
		Connection con = CommonDao.getConnection();
		int totalRecords;
		List<ProductDto> list;
		int maxResult = 5;
		int totalPages;
		int maxNavigationPage;
		List<Integer> navigationPages;
		
		try {
			// get total records
			ResultSet rs = con.prepareStatement(SqlStrings.totalRecordsSql).executeQuery();
			rs.next();
			totalRecords = rs.getInt(1);
			if (((double)totalRecords) % maxResult == 0.0) {
				totalPages = totalRecords/maxResult;
			}
			else{
				totalPages = totalRecords/maxResult + 1;
			}
			// validate current page
			if (currentPage < 1 || currentPage > totalPages) {
				throw new Exception();
			}
			// get products
			PreparedStatement pst = con.prepareStatement(SqlStrings.getProductsByPage);
			pst.setInt(1, (currentPage-1)*5);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while(rs.next()){
				list.add(new ProductDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
			//maxNavigationPage
			maxNavigationPage = currentPage+3;
			if (maxNavigationPage > totalPages) {
				maxNavigationPage = totalPages;
			}
			//navigationPages
			int start = currentPage > 3 ? currentPage-3: 1;
			navigationPages = new ArrayList<>();
			for (int i = start; i <= maxNavigationPage; i++) {
				navigationPages.add(i);
			}
			return new Pagination(currentPage, list, maxResult, totalPages, maxNavigationPage, navigationPages);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con = null;
		}
		return null;
	}
	
	public static ProductDto getProduct(int id){
		if (id > 0) {
			try {
				PreparedStatement pst = CommonDao.getConnection().prepareStatement(SqlStrings.getProductById);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					return new ProductDto(rs.getInt("id"), rs.getString("name"), rs.getString("details"), rs.getInt("price"), rs.getString("imageLink"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static int getNewPid() {
		try {
			ResultSet rs = CommonDao.getConnection().createStatement().executeQuery(SqlStrings.getNewPid);
			if (rs.next()) {
				return rs.getInt(1)+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean addProduct(String pname, String pdetails, int pprice, String imageLink) {
		try {
			PreparedStatement pst = CommonDao.getConnection().prepareStatement("INSERT INTO products(name, details, price, imageLink) VALUES(?, ?, ?, ?)");
			pst.setString(1, pname);pst.setString(2, pdetails);pst.setInt(3, pprice);pst.setString(4, imageLink);
			if(pst.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateProduct(int pid, String pname, String pdetails, int price, String imageLink) {
		try {
			PreparedStatement pst = CommonDao.getConnection().prepareStatement(SqlStrings.updateProduct);
			pst.setString(1, pname);pst.setString(2, pdetails);pst.setInt(3, price);pst.setString(4, imageLink);pst.setInt(5, pid);
			if (pst.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
