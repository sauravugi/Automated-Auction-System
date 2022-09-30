package com.saurav.buyer;

import java.util.List;
import java.util.Scanner;

import com.saurav.bean.Item;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.AdminExceptions;

public class SearchByCatagory {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Catagory Name");
		
		String cat = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			List<Item> lists = dao.viewItemByCatagory(cat);
			lists.forEach(l->System.out.println(l));
		} catch (AdminExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
