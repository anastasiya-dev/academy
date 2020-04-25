package by.academy.DealApplication;

public class Product {
	public double price;
	public String name;
	public int quantity;
	
	public Product() {
		super();	
	}
		
	public Product(double price, String name, int quantity) {
		super();
		this.price = price;
		this.name = name;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice (double price) {
		this.price = price;
	}
	
	public double getPrice () {
		return price;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
}
