package products;

import java.util.GregorianCalendar;

public class Clothes extends Product{
	
	private Size size;
	private String color;
	
	public Clothes(String name, String brand, double price, double quantity, Size size, String color) {
		super(name, brand, price, quantity);
		this.size = size;
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public double getDiscount(GregorianCalendar purchaseDate) {
		if(!Appliance.isWeekend(purchaseDate)) return 0.1;
		return -1;//-1 indicates that there is no discount!
	}
	
	@Override
	public String toString() {
		return name + " " + brand + " " + size + " " + color;
	}
		
}
