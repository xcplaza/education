package telran.dto;

public class Food extends Product { // extends - унаследование от Product
	String expDate;

	public Food() {
	}

	public Food(String name, double price, String unit, int code, String expDate) {
		super(name, price, unit, code);
		this.expDate = expDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", unit=" + unit + ", code=" + code + ", expDate=" + expDate
				+ "]";
	}
	
	
}
