package com.saurav.applyRules;

import java.util.List;


import com.saurav.bean.Seller;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class CheckSellerList {

	public static void main(String[] args) {


		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			List<Seller> sellers = dao.allSellerList();
			sellers.forEach(b->System.out.println(b));
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
