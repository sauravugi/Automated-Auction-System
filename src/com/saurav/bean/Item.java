package com.saurav.bean;

public class Item {
	
	private int id;
	private String name;
	private int price;
	
	private int quantity;
	private String seller;

	private String catagory;
	private String status;
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String name, int price, int quantity, String seller, String catagory, String status) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.seller = seller;
		this.catagory = catagory;
		this.status = status;
	}

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

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", seller="
				+ seller + ", catagory=" + catagory + ", status=" + status + "]";
	}

	public Item(int id, String name, int price, int quantity, String seller, String catagory, String status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.seller = seller;
		this.catagory = catagory;
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
