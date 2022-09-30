package com.saurav.applyRules;

import java.util.Scanner;

import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;

public class RegisterSeller {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email for Register");
		
		String em = sc.next();
		
		System.out.println("Enter Password : ");
		
		String ps = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		String res = dao.registerSeller(em, ps);
		
		System.out.println(res);

	}

}
