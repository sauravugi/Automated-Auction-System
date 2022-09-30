package com.saurav.applyRules;

import java.util.Scanner;

import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.AdminExceptions;

public class DeleteDispute {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Pass Product Id for Delete Dispute");
		
		int id = sc.nextInt();
		
		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			String msg = dao.deleteDispute(id);
			System.out.println(msg);
		} catch (AdminExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
