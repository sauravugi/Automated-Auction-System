package com.saurav.buyer;

import java.util.List;

import com.saurav.bean.Item;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.BuyerException;

public class BuyerItems {

	public static void main(String[] args) {


		AuctionDao dao = new AuctionDaoImpl();
		
		try {
			List<Item> lists = dao.viewBuyerItems();
			lists.forEach(l->System.out.println(l));
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
