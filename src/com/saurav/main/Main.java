package com.saurav.main;

import java.util.Scanner;

import com.saurav.applyRules.CheckBuyerList;
import com.saurav.applyRules.CheckSellerList;
import com.saurav.applyRules.CheckSold;
import com.saurav.applyRules.CheckUnsold;
import com.saurav.applyRules.DeleteDispute;
import com.saurav.applyRules.LoginAdmin;
import com.saurav.applyRules.LoginBuyer;
import com.saurav.applyRules.LoginSeller;
import com.saurav.applyRules.RegisterBuyer;
import com.saurav.applyRules.RegisterSeller;
import com.saurav.buyer.BuyItem;
import com.saurav.buyer.BuyerItems;
import com.saurav.buyer.SearchByCatagory;
import com.saurav.buyer.ViewBuyers;
import com.saurav.seller.AddItem;
import com.saurav.seller.CreateList;
import com.saurav.seller.DeleteItem;
import com.saurav.seller.SoldList;
import com.saurav.seller.UpdateItem;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Login Admin");
		System.out.println("2. Register Buyer");
		System.out.println("3. Register Seller");
		System.out.println("4. Login Buyer");
		System.out.println("5. Login Seller");
		System.out.println("6. Exit");
		
		System.out.println("Enter Choice");
		int c = sc.nextInt();
		
		if(c==1) {
			new LoginAdmin().main(args);
			
			System.out.println("1. View Buyer List");
			System.out.println("2. View Seller List");
			System.out.println("3. Daily Dispute/Unsold List");
			System.out.println("4. View Sold List");
			System.out.println("5. Remove Dispute Item");
			System.out.println("6. Exit");
			
			System.out.println("Enter Choice");
			int c3 = sc.nextInt();
			
			if(c3==1) new CheckBuyerList().main(args);
			else if(c3==2) new CheckSellerList().main(args);
			else if(c3==3) new CheckUnsold().main(args);
			else if(c3==4) new CheckSold().main(args);
			else if(c3==5) new DeleteDispute().main(args);
			else return;
			
		}else if(c==2) {
			new RegisterBuyer().main(args);
			System.out.println("1. Login Buyer");
			System.out.println("2. Exit");
			System.out.println("Enter Choice");
			int c1 = sc.nextInt();
			if(c1==1) {
				new LoginBuyer().main(args);
				
				System.out.println("1. Search and view Items by category");
				System.out.println("2. View All Buyers");
				System.out.println("3. Buyer Item List");
				System.out.println("4. Buy A item");
				System.out.println("5. Exit");
				
				System.out.println("Enter Choice");
				int c4 = sc.nextInt();
				
				if(c4==1) new SearchByCatagory().main(args);
				else if(c4==2) new ViewBuyers().main(args);
				else if(c4==3) new BuyerItems().main(args);
				else if(c4==4) new BuyItem().main(args);
				else return;
				
			}else return;
		}else if(c==3) {
			new RegisterSeller().main(args);
			System.out.println("1. Login Seller");
			System.out.println("2. Exit");
			System.out.println("Enter Choice");
			int c2 = sc.nextInt();
			if(c2==1) {
				new LoginSeller().main(args);
				
				System.out.println("1. Create A List");
				System.out.println("2. Update price, Quantity of item");
				System.out.println("3. Add item in List");
				System.out.println("4. Remove item from List");
				System.out.println("5. View Sold Items");
				System.out.println("6. Exit");
				
				System.out.println("Enter Choice");
				int c5 = sc.nextInt();
				
				if(c5==1) new CreateList().main(args);
				else if(c5==2) new UpdateItem().main(args);
				else if(c5==3) new AddItem().main(args);
				else if(c5==4) new DeleteItem().main(args);
				else if(c5==5) new SoldList().main(args);
				else return;
				
			}else return;
		}else if(c==4) {
			new LoginBuyer().main(args);
			
			System.out.println("1. Search and view Items by category");
			System.out.println("2. View All Buyers");
			System.out.println("3. Buyer Item List");
			System.out.println("4. Buy A item");
			System.out.println("5. Exit");
			
			System.out.println("Enter Choice");
			int c6 = sc.nextInt();
			
			if(c6==1) new SearchByCatagory().main(args);
			else if(c6==2) new ViewBuyers().main(args);
			else if(c6==3) new BuyerItems().main(args);
			else if(c6==4) new BuyItem().main(args);
			else return;
			
			
		}else if(c==5) {
			new LoginSeller().main(args);
			
			System.out.println("1. Create A List");
			System.out.println("2. Update price, Quantity of item");
			System.out.println("3. Add item in List");
			System.out.println("4. Remove item from List");
			System.out.println("5. View Sold Items");
			System.out.println("6. Exit");
			
			System.out.println("Enter Choice");
			int c7 = sc.nextInt();
			
			if(c7==1) new CreateList().main(args);
			else if(c7==2) new UpdateItem().main(args);
			else if(c7==3) new AddItem().main(args);
			else if(c7==4) new DeleteItem().main(args);
			else if(c7==5) new SoldList().main(args);
			else return;
			
		}else return;
		

	}

}
