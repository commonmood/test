package edu.cugb.xg.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.cugb.xg.javaee.bean.Users;

public class UsersTest {
	Users userbean = null;
	@Before
	public void setUp() throws Exception {
		userbean = new Users();
	}

	@Test
	public void test() {
		Users user = new Users();
		user.setUsername("test");
		user.setPassword("1234");
		assertTrue(userbean.getValid(user));
	}

}
