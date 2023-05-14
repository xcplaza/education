package telran.dto;

public class Product {
	String name;
	double price;
	String unit;
	int code;

	public Product() {
	}

	public Product(String name, double price, String unit, int code) {
		super(); // обращение к суперклассу (к родителю), () - обращение к конструктору родителя
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override // аннотация переопределения родительского метода
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", unit=" + unit + ", code=" + code + "]";
	}
	
	

}
