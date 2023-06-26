import java.util.Comparator;

public class ComparatorByCount implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o2.getCount() - o1.getCount();
	}

}
