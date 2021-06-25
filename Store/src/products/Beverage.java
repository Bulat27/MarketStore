package products;

import java.util.GregorianCalendar;

public class Beverage extends PerishableProduct{
	
	public Beverage(String name, String brand, double price, double quantity, GregorianCalendar expirationDate) {
		super(name, brand, price, quantity, expirationDate);
	}
	
	//I intentionally implemented toString() differently in Beverage and in Food because there is a slight difference between the two in your output example.
	@Override
	public String toString() {
		return name + " " + brand;
	}
}
