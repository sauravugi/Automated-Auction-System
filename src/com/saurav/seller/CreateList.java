package com.saurav.seller;

import java.util.Scanner;

import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class CreateList {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Pass Table Name");
		
		String name = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			String msg = dao.createList(name);
			System.out.println(msg);
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
