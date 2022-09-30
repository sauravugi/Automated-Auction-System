package com.saurav.bean;

public class Unsold {
	
	private int id;
	private String name;
	private int price;
	private String status;
	private int quantity;
	private String seller;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Unsold(int id, String name, int price, String status, int quantity, String seller) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.quantity = quantity;
		this.seller = seller;
	}
	@Override
	public String toString() {
		return "Unsold [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + ", quantity="
				+ quantity + ", seller=" + seller + "]";
	}
	
	public Unsold() {
		// TODO Auto-generated constructor stub
	}

}
