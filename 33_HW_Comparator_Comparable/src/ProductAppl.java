import java.util.Arrays;
import java.util.Comparator;

public class ProductAppl {

	public static void main(String[] args) {
		
		Product[] products = { 
				new Product("Barsik", 3000., 10), 
				new Product("Murzik", 3700., 56),
				new Product("Bogdana", 10000., 32), 
				new Product("Masha", 7000.9, 10),
				new Product("Masha", 7000.4, 9),
				new Product("Masha2", 7000., 10) 
				};
		Arrays.sort(products, new ComparatorBySeller());
		System.out.println(Arrays.toString(products));
		
		Arrays.sort(products, new ComparatorByPrice());
		System.out.println(Arrays.toString(products));

		Comparator<Product> comp = new ComparatorByCount().reversed().thenComparing(new ComparatorByPrice().reversed());
		Arrays.sort(products, comp);
		System.out.println(Arrays.toString(products));
		
	}
	
	

}
