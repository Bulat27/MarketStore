package products;

import java.util.GregorianCalendar;

//I've implemented Product as an abstract class because there is no need for the instance of "pure" Product in this application. Only its subclasses are used as the types of instances.
public abstract class Product {

	protected String name;
	protected String brand;
	protected double price;
	protected double quantity;
	

	public Product(String name, String brand, double price, double quantity) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
			
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	//Returns the discount based on the type of product and the purchase date. If no discount is available, it returns -1.
	public abstract double getDiscount(GregorianCalendar purchaseDate);
		
}
