package products;

import java.util.GregorianCalendar;

public class PerishableProduct extends Product{
	
	
	protected GregorianCalendar expirationDate;

	
	public PerishableProduct(String name, String brand, double price, double quantity,
			GregorianCalendar expirationDate) {
		super(name, brand, price, quantity);
		if(expirationDate == null) throw new IllegalArgumentException();//I just want to make sure that NullReferenceException doesn't occur and that I am aware of the potential problem.
		//If this app accepted user input, I would handle this exception in a better way, by informing a user and making them input a new value.  
		this.expirationDate = expirationDate;
	}

	public GregorianCalendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(GregorianCalendar expirationDate) {
		if(expirationDate == null) throw new IllegalArgumentException();
		this.expirationDate = expirationDate;
	}

	//I implemented this by adding 5 days, so it takes minutes and seconds in consideration now. I hope that's what you meant by "within 5 days". 
	//On the other hand, when I implemented the 50% discount part, I didn't take minutes and seconds in consideration because it says "at the date of purchase".
	@Override
	public double getDiscount(GregorianCalendar purchaseDate) {
		if(isTheSameDay(purchaseDate, expirationDate)) return 0.5;
		
		GregorianCalendar pDClone = (GregorianCalendar) purchaseDate.clone();//If I didn't clone purchase date here, I would add 5 days to it, and it could cause problems later in the program.
		pDClone.add(GregorianCalendar.DAY_OF_MONTH, 5);
		
		if(pDClone.equals(expirationDate) || pDClone.after(expirationDate)) return 0.1;
		return -1;//-1 indicates that there is no discount!
	}
	
	//I've written this method as public static because I want to use it at different classes and because it gets all the information it needs through parameters.
	public static boolean isTheSameDay(GregorianCalendar g1,GregorianCalendar g2) {
		return (g1.get(GregorianCalendar.YEAR) == g2.get(GregorianCalendar.YEAR) &&
				g1.get(GregorianCalendar.MONTH) == g2.get(GregorianCalendar.MONTH) &&
				g1.get(GregorianCalendar.DAY_OF_MONTH) == g2.get(GregorianCalendar.DAY_OF_MONTH)
				);		
	}
	
}
