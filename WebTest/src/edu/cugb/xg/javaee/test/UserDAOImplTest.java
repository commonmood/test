package edu.cugb.xg.javaee.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.dao.UserDAO;
import edu.cugb.xg.javaee.dao.UserDAOImpl;
import edu.cugb.xg.javaee.util.DAOFactory;

public class UserDAOImplTest {
	UserDAO userdao =null;
	@Before
	public void setUp() throws Exception {
//		userdao = new UserDAOImpl();
		userdao = (UserDAO) DAOFactory.newInstance("UserDAO");
	}

	
	public void testFindUsers() {
//		UserDAOImpl userdao = new UserDAOImpl();
//		UserDAO userdao = new UserDAOImpl();
//		UserDAO userdao = DAOFactory.newInstance("UserDAO");
		System.out.println(userdao.findUsers());
	}
	
	
	public void testFindUser(){
//		UserDAO userdao = new UserDAOImpl();
		Users user = new Users();
		user.setUsername("test");
		user.setPassword("1234");
		assertTrue(userdao.findUser(user));
	}
	
	@Test
	public void testInsertUser() throws ParseException{
		Users user = new Users();		
		user.setUsername("test6");
		user.setPassword("123456");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		user.setCreatedate(sdf.parse("2017/04/18"));
		assertEquals(1, userdao.insertUser(user));
	}

	
	
	
	
	
	
	
	
	
}
