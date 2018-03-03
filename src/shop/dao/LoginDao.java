package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.sql.SqlStrings;

public class LoginDao {
	
	public boolean checkLogin(String userid,String pwd) {
		Connection con = CommonDao.getConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(SqlStrings.loginSql);
			stmt.setString(1, userid);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con = null;
		}
		return false;
	}
}
