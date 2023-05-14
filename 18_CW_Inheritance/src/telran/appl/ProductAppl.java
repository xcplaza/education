package telran.appl;

import telran.dto.Food;
import telran.dto.Product;

public class ProductAppl {

	public static void main(String[] args) {

		Product p = new Product("Product1", 10., "Unit1", 12345);
		System.out.println(p);
		
		Food f = new Food("Food1", 33., "Unit2", 12312, "12/12/23");
		System.out.println(f);
	}

}
