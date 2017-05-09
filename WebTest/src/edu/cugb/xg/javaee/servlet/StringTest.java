package edu.cugb.xg.javaee.servlet;

public class StringTest {

	public static void main(String[] args) {
		String username = "test";
		String password = "test";
//		String username = new String("test");
//		String password = new String("test");
//		int param01 = 1;
//		if(username == password){
		if(username.equals(password)){
			System.out.println("username == password");
		}else{
			System.out.println("username != password");
		}
		
//		if(param01=1){
//			System.out.println(password="test");
//		}
			


	}

}
