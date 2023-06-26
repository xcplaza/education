import java.util.Comparator;

public class ComaratorByName implements Comparator<Cats> {

	@Override
	public int compare(Cats o1, Cats o2) {
		return o1.name.compareTo(o2.name);
	}

}
