package com.saurav.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.saurav.bean.Buyer;
import com.saurav.bean.Item;
import com.saurav.bean.Seller;
import com.saurav.bean.Sold;
import com.saurav.bean.Unsold;
import com.saurav.exceptions.AdminExceptions;
import com.saurav.exceptions.BuyerException;
import com.saurav.exceptions.SellerException;
import com.saurav.utility.DBConnection;

public class AuctionDaoImpl implements AuctionDao{

	@Override
	public String registerSeller(String email, String password) {
		
		String msg = "Not Inserted";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("insert into seller(s_email,s_password) values(?,?)");
			ps.setString(1, email);
			ps.setString(2, password);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Seller Id Registered Sucessfully";
			}
			
		}catch(SQLException e) {
			msg = e.getMessage();
		}
		
		
		
		return msg;
	}

	@Override
	public String registerBuyer(Buyer buyer) {
		
		String msg = "Not Inserted";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("insert into buyer(b_email,b_password) values(?,?)");
			
			ps.setString(1, buyer.getEmail());
			ps.setString(2, buyer.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Seller Id Registered Sucessfully";
			}
			
			
		}catch(SQLException e) {
			
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String loginAdmin(String email, String password) throws AdminExceptions {
		
		String msg = "Not Logged in";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement
			("select * from admin where email = ? AND password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			int id;
			if(rs.next()) {
				id=rs.getInt("id");
				msg="Logged with ID "+id;
			}else
				throw new AdminExceptions("Invalid Email or Password !");
			
			
			
		}catch(SQLException e) {
			throw new AdminExceptions(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public String loginBuyer(String email, String password) throws BuyerException {
		
		String msg = "Not Logged in";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement
			("select * from buyer where b_email = ? AND b_password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			int id;
			if(rs.next()) {
				id=rs.getInt("b_id");
				msg="Logged with ID "+id;
			}else
				throw new BuyerException("Invalid Email or Password !");
			
			
			
		}catch(SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public String loginSeller(String email, String password) throws SellerException {
		
		String msg = "Not Logged in";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement
			("select * from seller where s_email = ? AND s_password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			int id;
			if(rs.next()) {
				id=rs.getInt("s_id");
				msg="Logged with ID "+id;
			}else
				throw new SellerException("Invalid Email or Password !");
			
			
			
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public List<Buyer> allBuyerList() throws BuyerException {
		List<Buyer> buyers = new ArrayList<>();
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from buyer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("b_id");
				String email = rs.getString("b_email");
				String password = rs.getString("b_password");
				
				Buyer b = new Buyer(id, email, password);
				
				buyers.add(b);
			}
			
			
			
		}catch(SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		if(buyers.size()==0) throw new BuyerException("No Buyer found !");
		
		return buyers;
	}

	@Override
	public List<Seller> allSellerList() throws SellerException {
		List<Seller> sellers = new ArrayList<>();
		try(Connection conn = DBConnection.accessConnection()){
		
		PreparedStatement ps = conn.prepareStatement("select * from seller");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("s_id");
			String email = rs.getString("s_email");
			String password = rs.getString("s_password");
			
			Seller s = new Seller(id, email, password);
			
			sellers.add(s);
		}
		
		
		
	}catch(SQLException e) {
		throw new SellerException(e.getMessage());
	}
	
	if(sellers.size()==0) throw new SellerException("No Seller found !");
		
		
		
		return sellers;
	}

	@Override
	public List<Unsold> unsoldList() throws SellerException {
		List<Unsold> unsolds = new ArrayList<>();
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from items where status = 'unsold'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String name = rs.getString("name");
				String seller = rs.getString("sellername");
				String status = rs.getString("status");
				
				
				Unsold unsold = new Unsold(id, name, price, status, quantity, seller);
				
				unsolds.add(unsold);
			
			}
			
			
			
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		if(unsolds.size()==0) throw new SellerException("No Sold List found !");
		
		
		
		
		
		
		return unsolds;
	}

	@Override
	public List<Sold> soldList() throws SellerException {
		
		List<Sold> solds = new ArrayList<>();
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from items where status = 'sold'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String name = rs.getString("name");
				String seller = rs.getString("sellername");
				String status = rs.getString("status");
				
				
				Sold sold = new Sold(id, name, price, status, quantity, seller);
				
				solds.add(sold);
			
			}
			
			
			
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		if(solds.size()==0) throw new SellerException("No Sold List found !");
		
		
		
		
		
		return solds;
	}

	@Override
	public String deleteDispute(int id) throws AdminExceptions {
		String msg = "";
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from items where status = 'unsold' and id=?");
			
			ps.setInt(1, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) msg = x+" Record Disputed Sucessfully !";
			else throw new AdminExceptions("Wrong Id Pass or Record not found");
			
			
		}catch(SQLException e) {
			throw new AdminExceptions(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public String createList(String name) throws SellerException {
		String msg = "";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("create table "+name+"(id int primary key,name varchar(20) unique not null,price int not null,quantity int not null,sellername varchar(20) not null,catagory varchar(20) not null,status varchar(20) not null)");
			
			ps.executeUpdate();
			
			msg = name+" create table Sucessfully !";
			
			
			
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		
		return msg;
	}

	@Override
	public String addItems(Item item,String table) throws SellerException {
		
		String msg = "";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into "+table+" values(?,?,?,?,?,?,?)");
			ps.setInt(1, item.getId());
			ps.setString(2, item.getName());
			ps.setInt(3, item.getPrice());
			ps.setInt(4, item.getQuantity());
			ps.setString(5, item.getSeller());
			ps.setString(6, item.getCatagory());
			ps.setString(7, item.getStatus());
			
			int x = ps.executeUpdate();
			
			
			PreparedStatement ps1 = conn.prepareStatement("insert into items values(?,?,?,?,?,?,?)");
			ps1.setInt(1, item.getId());
			ps1.setString(2, item.getName());
			ps1.setInt(3, item.getPrice());
			ps1.setInt(4, item.getQuantity());
			ps1.setString(5, item.getSeller());
			ps1.setString(6, item.getCatagory());
			ps1.setString(7, item.getStatus());
			
			ps1.executeUpdate();
			
			
			if(x>0)
				msg = x+" Item Inserted Sucessfully";
			
		
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
	
		return msg;
	}

	@Override
	public String deleteItems(String name,String catagory,String table) throws SellerException {
		String msg = "";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from "+table+" where name = ? and catagory = ?");
			
			PreparedStatement ps1 = conn.prepareStatement("delete from items where name = ? and catagory = ?");
			
			ps.setString(1, name);
			ps.setString(2, catagory);
			
			ps1.setString(1, name);
			ps1.setString(2, catagory);
			
			int x = ps.executeUpdate();
			
			ps1.executeUpdate();
			
			if(x>0)
				msg =  x+" item deleted Sucessfully !";
			else
				throw new SellerException("Enter valid name or catagory !") ;
			
			
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		
		return msg;
	}

	@Override
	public String updateItem(int price, int quantity, String table,String name,String catagory) throws SellerException {
		String msg = "";
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update "+table+" set price ="+price+",quantity ="+quantity+" where name = ? and catagory = ? and status='unsold'");
			
			PreparedStatement ps1 = conn.prepareStatement("update items set price  ="+price+",quantity ="+quantity+" where name = ? and catagory = ? and status='unsold'");
			
			ps.setString(1, name);
			ps.setString(2, catagory);
			
			ps1.setString(1, name);
			ps1.setString(2, catagory);
			
			int x = ps.executeUpdate();
			
			ps1.executeUpdate();
			
			if(x>0)
				msg =  x+" item Updated Sucessfully !";
			else
				throw new SellerException("Enter valid name or catagory or Item is Already Sold !") ;
			
			
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		
		return msg;
	}

	@Override
	public List<Sold> soldItemsFromSeller(String table) throws SellerException {
		
		List<Sold> solds = new ArrayList<>();
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from "+table+" where status = 'sold'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String name = rs.getString("name");
				String seller = rs.getString("sellername");
				String status = rs.getString("status");
				
				
				Sold sold = new Sold(id, name, price, status, quantity, seller);
				
				solds.add(sold);
			
			}
			
			
			
		}catch(SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		if(solds.size()==0) throw new SellerException("No Sold List found !");
		
		
		
		
		
		return solds;
	}

	@Override
	public List<Item> viewItemByCatagory(String catagory) throws AdminExceptions {
		List<Item> lists = new ArrayList<>();
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from items where catagory = ?");
			
			ps.setString(1, catagory);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String name = rs.getString("name");
				String seller = rs.getString("sellername");
				String status = rs.getString("status");
				String cat = rs.getString("catagory");
				
				Item item = new Item(id, name, price, quantity, seller, cat, status);
				
				lists.add(item);
			
			}
			
			
			
		}catch(SQLException e) {
			throw new AdminExceptions(e.getMessage());
		}
		
		if(lists.size()==0) throw new AdminExceptions("No Item found in this catagory !");

		return lists;
	}

	@Override
	public List<Buyer> viewBuyerList() throws BuyerException {
		List<Buyer> lists = new ArrayList<>();
		
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from buyer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("b_id");
				String name = rs.getString("b_email");
				String password = rs.getString("b_password");
				
				Buyer buyer = new Buyer(id, name, password);
				
				lists.add(buyer);
			
			}
			
			
			
			
		}catch(SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		if(lists.size()==0) throw new BuyerException("No Buyer Found !");
		
		
		return lists;
	}

	@Override
	public List<Item> viewBuyerItems() throws BuyerException {
		
		List<Item> lists = new ArrayList<>();
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from buyerlist");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String name = rs.getString("name");
				String seller = rs.getString("sellername");
				String status = rs.getString("status");
				String cat = rs.getString("catagory");
				
				Item item = new Item(id, name, price, quantity, seller, cat, status);
				
				lists.add(item);
			
			}
			
			
			
		}catch(SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		if(lists.size()==0) throw new BuyerException("No Item found !");

		return lists;
	}

	@Override
	public String buyItem(String name,String catagory,String table) throws BuyerException {
		
		String msg = "";
		
		
		try(Connection conn = DBConnection.accessConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from "+table+" where name = ? and catagory = ? and status='unsold'");
			
			PreparedStatement ps2 = conn.prepareStatement("update "+table+" set status='sold' where name = ? and catagory = ? and status='unsold'");
			
			PreparedStatement ps3 = conn.prepareStatement("update items set status='sold' where name = ? and catagory = ? and status='unsold'");

			ps.setString(1, name);
			ps.setString(2, catagory);
			
			
			ps2.setString(1, name);
			ps2.setString(2, catagory);
			
			ps3.setString(1, name);
			ps3.setString(2, catagory);
			
			ResultSet rs = ps.executeQuery();
			
			
			ps2.executeUpdate();
			ps3.executeUpdate();
			
			if(rs.next()) {
				
				int id = rs.getInt("id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String nam = rs.getString("name");
				String seller = rs.getString("sellername");
				String status = rs.getString("status");
				String cat = rs.getString("catagory");
				
				PreparedStatement ps4 = conn.prepareStatement("insert into buyerlist values(?,?,?,?,?,?,?)");
				
				ps4.setInt(1, id);
				ps4.setInt(3, price);
				ps4.setInt(4, quantity);
				ps4.setString(2, nam);
				ps4.setString(5, seller);
				ps4.setString(6, cat);
				ps4.setString(7, status);
				
				ps4.executeUpdate();
				
				msg="Item Buy Sucessfully !";
				
			}else
				throw new BuyerException("Enter valid name or catagory or Item is Already Sold !") ;
			
			}catch(SQLException e) {
				throw new BuyerException(e.getMessage());
			}
		
		
		
		
		return msg;
	}


	
	

}
