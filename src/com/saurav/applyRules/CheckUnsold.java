package com.saurav.applyRules;

import java.util.ArrayList;
import java.util.List;

import com.saurav.bean.Unsold;
import com.saurav.dao.AuctionDao;
import com.saurav.dao.AuctionDaoImpl;
import com.saurav.exceptions.SellerException;

public class CheckUnsold {

	public static void main(String[] args) {


		AuctionDao dao = new AuctionDaoImpl();
		
		List<Unsold> unsolds = new ArrayList<>();
		
		try {
			unsolds = dao.unsoldList();
		} catch (SellerException e) {
			
			e.printStackTrace();
		}
		
		unsolds.forEach(u->System.out.println(u));

	}

}
