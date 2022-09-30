package com.saurav.seller;

import java.util.Scanner;

import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class DeleteItem {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name of item");
		
		String name = sc.next();
		
		System.out.println("Enter Catagory of item ");
		
		String ct = sc.next();
		
		System.out.println("Enter Table name ");
		
		String tb = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		
		try {
			String msg = dao.deleteItems(name, ct, tb);
			System.out.println(msg);
		} catch (SellerException e) {
			
			e.printStackTrace();
		}

	}

}
