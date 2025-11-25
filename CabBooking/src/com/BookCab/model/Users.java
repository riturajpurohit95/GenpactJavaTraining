package com.BookCab.model;

public class Users {
	
//	public Users(int user_id, String name, String email, String password, String phone) {
//		super();
//		this.user_id = user_id;
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.phone = phone;
//	}
	
	public Users() {};
	
	
	private int user_id;
	private String name;
	private String email;
	private String password;
	private String phone;
	
	
	public int getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + "]";
	}
	
	
	

}
