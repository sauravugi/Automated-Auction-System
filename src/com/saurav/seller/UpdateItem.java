package com.saurav.seller;

import java.util.Scanner;

import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class UpdateItem {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name of item");
		
		String name = sc.next();
		
		System.out.println("Enter Catagory of item ");
		
		String ct = sc.next();
		
		System.out.println("Enter Table name ");
		
		String tb = sc.next();
		
		System.out.println("Enter Updated price");
		
		int price = sc.nextInt();
		
		System.out.println("Enter Updated Quantity");
		
		int quantity = sc.nextInt();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			String msg = dao.updateItem(price, quantity, tb, name, ct);
			System.out.println(msg);
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
