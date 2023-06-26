import java.util.function.Predicate;

public class PredicateOdd implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t % 2 != 0;
	}

}
