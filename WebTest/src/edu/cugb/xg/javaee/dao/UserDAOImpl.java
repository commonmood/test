package edu.cugb.xg.javaee.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.util.JDBCUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public ArrayList<Users> findUsers() {
		ArrayList<Users> users = null;
		try {
			users = new ArrayList();
			String sql = "select * from users";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users user = (Users) mappingObj(rs,Users.class);
				users.add(user);
//				System.out.println("username=" + rs.getString(2));
				// rs.getString(3);
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	private Object mappingObj(ResultSet rs,Class clazz) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//ʵ����ӳ�����
		Object obj = clazz.newInstance();
		//��ȡӳ��������еķ���
		Method[] methods = clazz.getMethods();
		//��ȡ�������Ԫ������Ϣ
		ResultSetMetaData meta = rs.getMetaData();
		// ���ֶ���Ŀѭ��������м�¼�����ж���ӳ��
		for(int i=1;i<=meta.getColumnCount();i++){
			// ���쵱ǰ�е�set��������
			String colname = meta.getColumnLabel(i);
			String methodname = "set" + colname;
			// ѭ������ͬ����������ͨ��������ø÷�������������ֵ
			for(Method method:methods){
				if(method.getName().equals(methodname)){
					method.invoke(obj, rs.getObject(i));
					break;
				}
			}
			
		}
		return obj;
	}

	@Override
	public boolean findUser(Users user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean rtn = false;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from users where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
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

	@Override
	public int insertUser(Users user) {
		Connection conn = null;
		PreparedStatement ps = null;
		Integer rtn = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into users(username,password,createdate) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setTimestamp(3,new Timestamp(user.getCreatedate().getTime()));
			rtn =  ps.executeUpdate();							
			JDBCUtils.free(null, ps, conn);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtn;
	}

	@Override
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
