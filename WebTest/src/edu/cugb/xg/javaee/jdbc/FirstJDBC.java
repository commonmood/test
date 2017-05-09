package edu.cugb.xg.javaee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.cugb.xg.javaee.util.JDBCUtils;

public class FirstJDBC {
	/**
	 * 查找所有的用户
	 */
	public static void findUsers() {
		try {
			String sql = "select * from users";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("username=" + rs.getString(2));
				// rs.getString(3);
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据用户名和口令查找某一个用户是否存在
	 * @param username
	 * @param password
	 * @return
	 */

	public static boolean findUser(String username,String password){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean rtn = false;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from users where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				rtn = true;
			}					
			JDBCUtils.free(rs, ps, conn);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtn;
	}
	
	
	public static void main(String[] args) {
		// System.out.println("test");
//		findUsers();
		System.out.println(findUser("test","123456"));

	}

}
