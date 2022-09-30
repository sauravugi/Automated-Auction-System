package com.saurav.applyRules;

import java.util.Scanner;

import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.BuyerException;

public class LoginBuyer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email for Login");
		
		String em = sc.next();
		
		System.out.println("Enter Password : ");
		
		String ps = sc.next();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			String res = dao.loginBuyer(em, ps);
			System.out.println(res);
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
