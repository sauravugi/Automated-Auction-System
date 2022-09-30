package com.saurav.applyRules;

import java.util.ArrayList;
import java.util.List;

import com.saurav.bean.Sold;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class CheckSold {

	public static void main(String[] args) {


		AuctionDao dao = new AuctionDaoImpl();
		
		List<Sold> solds = new ArrayList<>();
		
		try {
			solds = dao.soldList();
		} catch (SellerException e) {
			
			e.printStackTrace();
		}
		
		solds.forEach(s->System.out.println(s));

	}

}
