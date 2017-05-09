package edu.cugb.xg.javaee.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.dao.UserDAO;
import edu.cugb.xg.javaee.util.DAOFactory;

public class UserDAOImpl2Test {
	UserDAO userdao =null;

	@Before
	public void setUp() throws Exception {
		userdao = (UserDAO) DAOFactory.newInstance("UserDAO");
	}

	@Test
	public void testFindUsers() {
		System.out.println(userdao.findUsers());
	}
	
	@Test
	public void testInsertUser() throws ParseException{
		Users user = new Users();		
		user.setUsername("test8");
		user.setPassword("123456");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		user.setCreatedate(sdf.parse("2017/04/25"));
		assertEquals(1, userdao.insertUser(user));
	}
	
	@Test
	public void testDeleteUser() throws ParseException{
		Users user = new Users();	
		user.setUserid(13);
		assertEquals(1, userdao.deleteUser(user));
	}

}
