package com.saurav.applyRules;

import java.util.Scanner;

import com.saurav.bean.Buyer;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;

public class RegisterBuyer {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email for Register");
		
		String em = sc.next();
		
		System.out.println("Enter Password : ");
		
		String ps = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		Buyer buyer = new Buyer(em, ps);
		
		String res = dao.registerBuyer(buyer);
		
		System.out.println(res);

	}

}
