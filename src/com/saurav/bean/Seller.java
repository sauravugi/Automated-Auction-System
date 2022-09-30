package com.saurav.bean;

public class Seller {
	
	private int id;
	private String email;
	private String password;
	
	public Seller() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Seller(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}


	public Seller(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Seller [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	
	

}
