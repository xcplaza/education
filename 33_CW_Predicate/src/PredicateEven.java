import java.util.function.Predicate;

public class PredicateEven implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t % 2 == 0;
	}

}
