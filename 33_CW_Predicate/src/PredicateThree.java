import java.util.function.Predicate;

public class PredicateThree implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t % 3 == 0;
	}

}
