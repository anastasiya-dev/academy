package by.academy.DealApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

@DealSettings(numProducts = 2)

public class Deal <P extends Product>{
		
	ArrayList<P> products;
	User<P> buyer;
	User<P> seller;
	boolean supplyEnough;
	Calendar deadlineDate;
	static int DealNumber = 0;
	int DealID;
	
	
	public Deal() {
		super();
		setDeadlineDate();
	}
	
	public Deal(ArrayList<P> products, User<P> buyer, User<P> seller) {
		super();
		this.products = products;
		this.buyer = buyer;
		this.seller = seller;
		setDeadlineDate();
		DealNumber++;
		this.DealID = DealNumber;
	}

	public ArrayList<P> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<P> products) {
		this.products = products;
	}

	public User<P> getBuyer() {
		return buyer;
	}

	public void setBuyer(User<P> buyer) {
		this.buyer = buyer;
	}

	public User<P> getSeller() {
		return seller;
	}

	public void setSeller(User<P> seller) {
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
	
	public double calcFullPrice(ArrayList<P> products) {
		double fullPrice = 0;
		for (int i = 0; i < products.size(); i++) {
			fullPrice += products.get(i).getPrice() * products.get(i).getQuantity();
		}
		return fullPrice;
	}
	
	public boolean supplyCheck() {	
		for (int i = 0; i < products.size(); i++) {
			for (int j = 0; j < seller.getProducts().size(); j++) {
				if(products.get(i).getName() == ((Product) seller.getProducts().get(j)).getName()) {
					if(products.get(i).getQuantity() > ((Product) seller.getProducts().get(j)).getQuantity()) {
						products.get(i).setQuantity(((Product) seller.getProducts().get(j)).getQuantity());
						if(products.get(i).getQuantity() != 0) {
							System.out.println("Unfortunately only " + products.get(i).getQuantity() + " of " + products.get(i).getName() + " is availiable");
						}						
					}					
				}
			}				
		}
		
		return supplyEnough;
	}
	
	@Deprecated
	public void makeDealUSSR() {
		System.out.println("Deprecated method");
	}
	
	public void makeDeal()  {
		supplyCheck();
		if (calcFullPrice (products) <= buyer.getMoneyQ()) {
			buyer.setmoneyQ(buyer.getMoneyQ() - calcFullPrice(products));
			seller.setmoneyQ(seller.getMoneyQ() + calcFullPrice(products));
			StringBuilder cheque = new StringBuilder();
			cheque.append("Our deal: ");
			cheque.append("\n");
			for (int i = 0; i < products.size(); i++) {
				cheque.append(products.get(i).getName());
				cheque.append(" in the quantity of ");
				cheque.append(products.get(i).getQuantity());
				cheque.append(" at price ");
				cheque.append(products.get(i).getPrice());
				cheque.append("\n");
			}			
			
			File dir = new File("src\\by\\academy\\DealApplication");
			File file = new File(dir,"cheque" + DealID + ".txt");
			if(!file.exists()) {
				file.mkdir();
			}
			
			try(PrintWriter pw = new PrintWriter(file)){
				pw.print(cheque);
			}
			catch(FileNotFoundException e) {
				e.getMessage();
			}			
			
			System.out.println(cheque);
			System.out.println("Deal total price: " + calcFullPrice(products));
			System.out.println("Buyer remaining cash: " + buyer.getMoneyQ());
			System.out.println("Seller remaining products: ");
			for (int i = 0; i < seller.getProducts().size(); i++) {
				((Product) seller.getProducts().get(i)).setQuantity(((Product) seller.getProducts().get(i)).getQuantity() - products.get(i).getQuantity());
				System.out.println(((Product) seller.getProducts().get(i)).getName() + " in the quantity of " + ((Product) seller.getProducts().get(i)).getQuantity() + " at price " + ((Product) seller.getProducts().get(i)).getPrice());
			}
			System.out.println("Now seller has " + seller.getMoneyQ());

	}
		else {
			System.out.println("Deal cannot be completed");
		}
	}	
}
