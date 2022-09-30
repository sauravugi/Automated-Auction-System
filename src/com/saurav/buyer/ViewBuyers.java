package com.saurav.buyer;

import java.util.List;

import com.saurav.bean.Buyer;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.BuyerException;

public class ViewBuyers {

	public static void main(String[] args) {
		
		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			List<Buyer> buyers = dao.viewBuyerList();
			buyers.forEach(b->System.out.println(b));
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
