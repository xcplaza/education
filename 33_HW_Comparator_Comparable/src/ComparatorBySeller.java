import java.util.Comparator;

public class ComparatorBySeller implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getSellerName().compareTo(o2.getSellerName());
	}

}
