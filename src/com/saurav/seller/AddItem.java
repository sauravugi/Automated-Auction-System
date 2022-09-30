package com.saurav.seller;

import java.util.Scanner;

import com.saurav.bean.Item;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class AddItem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id : ");
		
		int i = sc.nextInt();
		
		System.out.println("Enter Name");
		
		String n = sc.next();
		
		System.out.println("Enter Price : ");
		
		int p = sc.nextInt();
		
		System.out.println("Enter Quantity :");
		
		int q = sc.nextInt();
		
		System.out.println("Enter Seller Name : ");
		
		String sn = sc.next();
		
		System.out.println("Enter Catagory");
		
		String c = sc.next();
		
		System.out.println("Enter status (sold/unsold) : ");
		
		String s = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		Item item = new Item(i,n, p, q, sn, c, s);
		
		System.out.println("Enter Table name ");
		String table = sc.next();
		
		try {
			String msg = dao.addItems(item, table);
			System.out.println(msg);
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
