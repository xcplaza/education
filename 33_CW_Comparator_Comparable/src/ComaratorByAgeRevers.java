import java.util.Comparator;

public class ComaratorByAgeRevers implements Comparator<Cats> {

	@Override
	public int compare(Cats o1, Cats o2) {
		return o2.age - o1.age;
	}

}
