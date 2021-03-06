package edu.cugb.xg.javaee.bean;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import edu.cugb.xg.javaee.dao.UserDAO;
import edu.cugb.xg.javaee.util.DAOFactory;

public class Users {
	public Users(){
		
	}
	public Users(String user,String pass){
		this.username = user;
		this.password = pass;
	}
	private Integer userid;
	private String username;
	private String password;
	private Date createdate;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	public boolean getValid(Users user){
		UserDAO userdao = (UserDAO) DAOFactory.newInstance("UserDAO");
		return userdao.findUser(user);
	}
	public boolean getValid(){		
		UserDAO userdao = (UserDAO) DAOFactory.newInstance("UserDAO");
		return userdao.findUser(this);
	}
}
