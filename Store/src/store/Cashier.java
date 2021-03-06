package store;



import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import products.PerishableProduct;
import products.Product;


public class Cashier {
	
	public void printAReceipt(Collection<Product> cart,GregorianCalendar purchaseDate) {
		if(cart == null || purchaseDate == null) {//I could also throw an exception here!
			System.out.println("Invalid input parameters!");
			return;
		}
		
		
		DecimalFormat df = new DecimalFormat("###.##");
		
		System.out.println("Date: " + getFormattedDate(purchaseDate));
		System.out.println();
		System.out.println("---Products---");
		System.out.println();
		System.out.println();
		
		double subtotal = 0;
		double totalDiscount = 0;
		
		for (Product product : cart) {
			if(product==null) continue;
			
			//The assignment text doesn't specify how program should act in this case. I've handled it in my way. 
			if(pastExpirationDate(product,purchaseDate)) {
				System.out.println("Product \"" + product.toString() +  "\"" + " is past its expiration date!");
				System.out.println();
				continue;
			}
				
			System.out.println(product.toString());
			System.out.println(df.format(product.getQuantity()) + " x $" + df.format(product.getPrice()) + " = " + "$" + df.format(product.getQuantity() * product.getPrice()));
			double discount = product.getDiscount(purchaseDate);
			if(discount != -1) {
				System.out.println("#discount " + (int) (discount * 100) + "%" + " -$" + df.format((discount * product.getPrice() * product.getQuantity())));
				totalDiscount += discount * product.getPrice() * product.getQuantity();
			}
			subtotal += product.getQuantity() * product.getPrice();
			System.out.println();
		}
		
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println("SUBTOTAL: $" + df.format(subtotal));
		System.out.println("DISCOUNT: -$" + df.format(totalDiscount));
		System.out.println();
		System.out.println("TOTAL: $" + df.format(subtotal - totalDiscount));
		
	}
	
	private boolean pastExpirationDate(Product product, GregorianCalendar purchaseDate) {
		if(!(product instanceof PerishableProduct)) return false;
		PerishableProduct pp = (PerishableProduct) product;
		
		//The assignment text says: "and 50% if the product expires at the date of purchase." Thus, if the product is past its expiration date
		//(in terms of hours and minutes), but it's the same day, it has not expired yet. This if statement covers that case.
		if(PerishableProduct.isTheSameDay(purchaseDate, pp.getExpirationDate())) return false;
		
		return purchaseDate.after(pp.getExpirationDate());
	}

	private String getFormattedDate(GregorianCalendar purchaseDate) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dateToFormat = purchaseDate.getTime();
		return dateFormat.format(dateToFormat);
	}
	
	//I commented out the main method that I've used to test the application.
	
	/*public static void main(String[] args) {
		
		Cashier cashier = new Cashier();
		Product apple = new Food("apples", "BrandA", 1.5, 2.45, new GregorianCalendar(2021, 5, 14));
		Product milk = new Beverage("milk", "BrandM", 0.99, 3, new GregorianCalendar(2022, 1 ,2));
		Product tShirt = new Clothes("T-shirt", "BrandT", 15.99, 2, Size.M, "violet");
		Product laptop = new Appliance("laptop", "BrandL", 2345, 1, "ModelL", new GregorianCalendar(2021, 2, 3), 1.125);
		
		Collection<Product> cart = new ArrayList<>();
		cart.add(apple);
		cart.add(milk);
		cart.add(tShirt);
		cart.add(laptop);
		
		GregorianCalendar purchaseDate = new GregorianCalendar(2021, 5, 14, 12, 34, 56);
		
		
		cashier.printAReceipt(cart, purchaseDate);
			
	}*/
	
}
