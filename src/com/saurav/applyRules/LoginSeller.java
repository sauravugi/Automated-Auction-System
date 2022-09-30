package com.saurav.applyRules;

import java.util.Scanner;

import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class LoginSeller {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email for Login");
		
		String em = sc.next();
		
		System.out.println("Enter Password : ");
		
		String ps = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		
		try {
			String res = dao.loginSeller(em, ps);
			System.out.println(res);
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
