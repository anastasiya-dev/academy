package by.academy.DealApplication;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Wine wineS = new Wine (5, "Chardonnay", 100);
		Cheese cheeseS = new Cheese (2, "Gauda", 100);
		Wine wineD = new Wine (5, "Chardonnay", 3);
		Cheese cheeseD = new Cheese (2, "Gauda", 4);
		
		Product[] sellerProducts = {wineS, cheeseS};
		Product[] dealProducts = {wineD, cheeseD};
		
		User buyer1 = new User ("A", null, 100);
		User seller1 = new User ("B", sellerProducts, 10);
		
		Deal deal1 = new Deal (dealProducts, buyer1, seller1);
		deal1.makeDeal();
		
//		deal1.makeDealUSSR();
//		Class<? extends Deal> dc = deal1.getClass();
//		DealSettings ds = (DealSettings) dc.getAnnotation(DealSettings.class);
//		System.out.println(ds.Legality());
		
		menu(dealProducts);		
	}
	public static void menu(Product[] dealProducts) {
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
				newProduct.setName(name);
				newProduct.setPrice(Double.valueOf(price));
				newProduct.setQuantity(Integer.valueOf(quantity));
			case 2:
				System.out.println("Enter the name of the product to delete:");
				productNameDel = scan.next();
				for (int i = 0; i < dealProducts.length; i++) {
					if(dealProducts[i].getName().equals(productNameDel)) {
						for (int j = i; j < dealProducts.length - 1; j++) {
						dealProducts[j] = dealProducts[j + 1];
						}
						dealProducts[dealProducts.length - 1] = null;
					}					
				break;			
				}
			}
		System.out.println("Menu closed");		
		}
	}
	private static String keyboard(Scanner scan, String message) {
		System.out.print(message + ": ");
		return scan.next();
	}
}
