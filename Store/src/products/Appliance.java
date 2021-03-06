package products;

import java.util.GregorianCalendar;

public class Appliance extends Product{
	
	private String model;
	private GregorianCalendar productionDate;
	private double weight;
	
	
	public Appliance(String name, String brand, double price, double quantity, String model,
			GregorianCalendar productionDate, double weight) {
		super(name, brand, price, quantity);
		this.model = model;
		this.productionDate = productionDate;
		this.weight = weight;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public GregorianCalendar getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(GregorianCalendar productionDate) {
		this.productionDate = productionDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public double getDiscount(GregorianCalendar purchaseDate) {
		if(price > 999 && isWeekend(purchaseDate))
			return 0.05;
		return -1;//-1 indicates that there is no discount!
	}
	
	public static boolean isWeekend(GregorianCalendar purchaseDate) {
		return purchaseDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY || purchaseDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY;
	}
	
	@Override
	public String toString() {
		return name + " " + brand + " " + model;
	}
	
}
