import java.util.Comparator;

public class ComrataorByPrice implements Comparator<Cats> {

	@Override
	public int compare(Cats o1, Cats o2) {
		return Double.compare(o1.price, o2.price);
	}

}
