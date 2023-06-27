import java.util.Objects;
import java.util.function.Predicate;

public class PredicateByRemove implements Predicate<Integer> {
	private int res;

	@Override
	public boolean test(Integer t) {
		return t % res == 0;
	}
	
	public PredicateByRemove() {
	}

	public PredicateByRemove(int res) {
		super();
		this.res = res;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(res);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PredicateByRemove))
			return false;
		PredicateByRemove other = (PredicateByRemove) obj;
		return res == other.res;
	}

	@Override
	public String toString() {
		return "PredicateByRemove [res=" + res + "]";
	}
	
	

}
