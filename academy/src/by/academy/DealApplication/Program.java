package by.academy.DealApplication;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.academy.lesson7.Homework3.Task5.Validator;

public class Program {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Wine wineS = new Wine (5, "Chardonnay", 100);
		Cheese cheeseS = new Cheese (2, "Gauda", 100);
		Wine wineD = new Wine (5, "Chardonnay", 3);
		Cheese cheeseD = new Cheese (2, "Gauda", 4);
		
		ArrayList<Product> sellerProducts = new ArrayList<Product>();
		sellerProducts.add(wineS);
		sellerProducts.add(cheeseS);
		ArrayList<Product> dealProducts = new ArrayList<Product>();
		dealProducts.add(cheeseD);
		dealProducts.add(wineD);
					
		User<Product> buyer1 = new User<> ("A", null, 100);
		User<Product> seller1 = new User<> ("B", sellerProducts, 10);
		
		Deal <Product>deal1 = new Deal <>(dealProducts, buyer1, seller1);
		deal1.makeDeal();
		buyer1.setEmail("anastasiya.kalach@gmail.com");
		
//		deal1.makeDealUSSR();
//		Class<? extends Deal> dc = deal1.getClass();
//		DealSettings ds = (DealSettings) dc.getAnnotation(DealSettings.class);
//		System.out.println(ds.Legality());
		
		menu(dealProducts);
		
		Validator emailValidator = new Validator() {

			@Override
			public boolean validate(String email) {		
				Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
				Matcher matcher = p.matcher(email);				
				return matcher.find();
			}
			
		};
		
		System.out.println(emailValidator.validate(buyer1.getEmail()));
	}
	public static <P> void menu(ArrayList<P> dealProducts) {
		Scanner scan = new Scanner(System.in);
		int operationChoiceInt = 0;
		String operationChoice = "";
		String productType = "";
		String productNameDel = "";
	
		while (!"3".equals(operationChoice)) {
			System.out.println("1. To add product enter 1");
			System.out.println("2. To delete product enter 2");
			System.out.println("3. To exit enter 3");
			operationChoice = scan.next();

			try {
				operationChoiceInt = Integer.parseInt(operationChoice);
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input");
			}

			switch (operationChoiceInt) {
			case 1:
				Product newProduct = null;
				System.out.println("Enter the type of the product to add:");
				productType = scan.next();
				String name = keyboard(scan, "    Name");
				String price = keyboard(scan, "    Price");
				String quantity = keyboard(scan, "    Quantity");				
				
				switch (productType) {
				case "Wine":
					newProduct = new Wine();					
					break;
				case "Cheese":
					newProduct = new Cheese();
					break;
				default:
					newProduct = new Product();
					System.out.println("No specification for such product yet");
				}
				dealProducts.add((P) newProduct);
				newProduct.setName(name);
				newProduct.setPrice(Double.valueOf(price));
				newProduct.setQuantity(Integer.valueOf(quantity));
				break;
			case 2:
				System.out.println("Enter the name of the product to delete:");
				productNameDel = scan.next();
				for(int i = 0; i < dealProducts.size(); i++) {

					if(((Product) dealProducts.get(i)).getName().contentEquals(productNameDel)) {
						dealProducts.remove(dealProducts.get(i));
					}
				}			
				break;
			case 3:
				System.out.println("Menu closed");
			}				
		}
	}
	private static String keyboard(Scanner scan, String message) {
		System.out.print(message + ": ");
		return scan.next();
	}
}
