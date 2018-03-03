package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.dto.UserDto;
import shop.sql.SqlStrings;

public class UserDao {
	
	public static UserDto getUser(String userid) {
		Connection con = CommonDao.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SqlStrings.getUserByUserid);
			pst.setString(1, userid);
			ResultSet rs = pst.executeQuery();
			UserDto dto;
			while(rs.next()){
				return new UserDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
