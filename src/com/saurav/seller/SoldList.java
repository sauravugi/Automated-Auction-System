package com.saurav.seller;

import java.util.List;
import java.util.Scanner;

import com.saurav.bean.Sold;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class SoldList {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Table name");
		
		String table = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			List<Sold> list= dao.soldItemsFromSeller(table);
			
			list.forEach(l->System.out.println(l));
			
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
