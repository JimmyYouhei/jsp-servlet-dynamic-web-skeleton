package com.jimmyyouhei.servlet_and_jsp.bean;

import com.jimmyyouhei.servlet_and_jsp.entity.UserAuthority;

public class UserBean {
	
	private String username;
	private String password;
	
	private UserAuthority userAuthority;
	
	

	public UserBean() {

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

	public UserAuthority getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthority userAuthority) {
		this.userAuthority = userAuthority;
	}
	
	public static UserBean validateUser(String username , String password) {
		
		UserBean user = new UserBean();
		
		switch(username) {
		
		case "system":
			if(password.equals("java")) {
				user.setUserAuthority(UserAuthority.NORMAL);
			} else {
				user.setUserAuthority(UserAuthority.REJECTED);
			}
			break;
			
		case "admin":
			if(password.equals("passw0rd")) {
				user.setUserAuthority(UserAuthority.ADMIN);
			}else {
				user.setUserAuthority(UserAuthority.REJECTED);
			}
			break;
		
			default:
				user.setUserAuthority(UserAuthority.REJECTED);
				
		}
		
		if(user.getUserAuthority() != UserAuthority.REJECTED) {
			user.setUsername(username);
			user.setPassword(password);

		}
		
		return user;
		
	}

}
