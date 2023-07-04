package telran.treeSetAppl;
import java.util.Comparator;

public class CatsComparatorByAge implements Comparator<Cat> {

	@Override
	public int compare(Cat o1, Cat o2) {
		int res = o1.getAge() - o2.getAge();
		return res == 0 ? o1.getId() - o2.getId() : res;
	}

}
