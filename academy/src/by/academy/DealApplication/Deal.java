package by.academy.DealApplication;

import java.util.Calendar;

@DealSettings(numProducts = 2)

public class Deal {
		
	Product [] products;
	User buyer;
	User seller;
	boolean supplyEnough;
	Calendar deadlineDate;
	
	
	public Deal() {
		super();
		setDeadlineDate();
	}
	
	public Deal(Product [] products, User buyer, User seller) {
		super();
		this.products = products;
		this.buyer = buyer;
		this.seller = seller;
		setDeadlineDate();
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	public Calendar getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate() {
		Calendar todayTechnical = Calendar.getInstance();
		todayTechnical.add(Calendar.DAY_OF_MONTH, 10);
		this.deadlineDate = todayTechnical;		
	}
	
	public double calcFullPrice(Product[] products) {
		double fullPrice = 0;
		for (int i = 0; i < products.length; i++) {
			fullPrice += products[i].getPrice() * products[i].getQuantity();
		}
		return fullPrice;
	}
	
	public boolean supplyCheck() {
		boolean supplySupport;
		for (int i = 0; i < products.length; i++) {
			for (int j = 0; j < seller.getProducts().length; j++) {
				if(products[i].getName() == seller.getProducts()[j].getName()) {
					if(products[i].getQuantity() > seller.getProducts()[j].getQuantity()) {
						products[i].setQuantity(seller.getProducts()[j].getQuantity());
						if(products[i].getQuantity() != 0) {
							System.out.println("Unfortunately only " + products[i].getQuantity() + " of " + products[i].getName() + " is availiable");
						}						
					}					
				}
			}				
		}
		//не дописано пока
//		for(int i = 0; i < products.length; i++) {
//			if(p.getQuantity() == 0) {
//				supplyEnough = false;
//				
//			}
//			
//			System.out.println("Sorry, there're no necessary products availiable");
//			if(supplyEnough == true)
//				
//			if(p.getQuantity() != 0) {
//				System.out.println("All the necessary products are in supply");
//			}
//		}
		
		return supplyEnough;
	}
	
	@Deprecated
	public void makeDealUSSR() {
		System.out.println("Deprecated method");
	}
	
	public void makeDeal() {
		supplyCheck();
		if (calcFullPrice (products) <= buyer.getMoneyQ()) {
			buyer.setmoneyQ(buyer.getMoneyQ() - calcFullPrice(products));
			seller.setmoneyQ(seller.getMoneyQ() + calcFullPrice(products));
			StringBuilder cheque = new StringBuilder();
			cheque.append("Our deal: ");
			cheque.append("\n");
			for (int i = 0; i < products.length; i++) {
				cheque.append(products[i].getName());
				cheque.append(" in the quantity of ");
				cheque.append(products[i].getQuantity());
				cheque.append(" at price ");
				cheque.append(products[i].getPrice());
				cheque.append("\n");
			}
			System.out.println(cheque);
			System.out.println("Deal total price: " + calcFullPrice(products));
			System.out.println("Buyer remaining cash: " + buyer.getMoneyQ());
			System.out.println("Seller remaining products: ");
			for (int i = 0; i < seller.getProducts().length; i++) {
				seller.getProducts()[i].setQuantity(seller.getProducts()[i].getQuantity() - products[i].getQuantity());
				System.out.println(seller.getProducts()[i].getName() + " in the quantity of " + seller.getProducts()[i].getQuantity() + " at price " + seller.getProducts()[i].getPrice());
			}
			System.out.println("Now seller has " + seller.getMoneyQ());
//			for (int i = 0; i < products.length; i++) {
//				if (products[i].getQuantity() == null) {
//					
//				}
//				
//			}
	}
		else {
			System.out.println("Deal cannot be completed");
		}
	}	
}
