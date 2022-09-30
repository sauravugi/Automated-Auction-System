package com.saurav.dao;

import java.util.List;

import com.saurav.bean.Buyer;
import com.saurav.bean.Item;
import com.saurav.bean.Seller;
import com.saurav.bean.Sold;
import com.saurav.bean.Unsold;
import com.saurav.exceptions.AdminExceptions;
import com.saurav.exceptions.BuyerException;
import com.saurav.exceptions.SellerException;

public interface AuctionDao {
	
	public String registerSeller(String email,String password);
	
	public String registerBuyer(Buyer buyer);
	
	public String loginAdmin(String email,String password) throws AdminExceptions;
	
	public String loginBuyer(String email,String password) throws BuyerException;
	
	public String loginSeller(String email,String password) throws SellerException;
	
	public List<Buyer> allBuyerList() throws BuyerException;
	
	public List<Seller> allSellerList() throws SellerException;
	
	public List<Unsold> unsoldList() throws SellerException;
	
	public List<Sold> soldList() throws SellerException;
	
	public String deleteDispute(int id) throws AdminExceptions;
	
	public String createList(String name) throws SellerException;
	
	public String addItems(Item item,String table) throws SellerException;
	
	public String deleteItems(String name,String catagory,String table) throws SellerException;
	
	public String updateItem(int price,int quantity,String table,String name,String catagory) throws SellerException;
	
	public List<Sold> soldItemsFromSeller(String table) throws SellerException;
	
	public List<Item> viewItemByCatagory(String catagory) throws AdminExceptions;
	
	public List<Buyer> viewBuyerList() throws BuyerException;
	
	public List<Item> viewBuyerItems() throws BuyerException;
	
	public String buyItem(String name,String catagory,String table) throws BuyerException;

}
