package edu.cugb.xg.javaee.dao;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.Users;

public class UserDAOImpl2 extends baseDAO implements UserDAO {

	@Override
	public ArrayList<Users> findUsers() {
		String sql = "select userid Userid,username "
				+ "Username,password Password from users";
		return findObjs(sql, Users.class);
	}

	@Override
	public boolean findUser(Users user) {
		String sql = "select userid Userid,username "
				+ "Username,password Password from users where username=? and password=?";
		Object[] params = {user.getUsername(),user.getPassword()};
		if(findObj(sql,params,Users.class) != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int insertUser(Users user) {
		String sql = "insert into users(username,password,"
				+ "createdate) values(?,?,?)";
		Object[] params = {user.getUsername(),user.getPassword(),user.getCreatedate()};
		return modifyObj(sql, params);
	}

	@Override
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Users user) {
		String sql = "delete from users where userid=?";
		Object[] params = {user.getUserid()};
		return modifyObj(sql, params);
	}

}
