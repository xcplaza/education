import java.util.Comparator;

public class ComparatorByAge implements Comparator<Cats>{

	@Override
	public int compare(Cats o1, Cats o2) {
			return o1.age - o2.age;
	}
	
}
