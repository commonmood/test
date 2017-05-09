package edu.cugb.xg.javaee.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import edu.cugb.xg.javaee.util.JDBCUtils;

public class JDBCUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConnection() throws SQLException {
		Connection conn = null;
		for(int i=0;i<4;i++){
			conn = JDBCUtils.getConnection();
			System.out.println(conn);
			conn.close();
		}
//		assertNotNull(JDBCUtils.getConnection());
	}

	

}
