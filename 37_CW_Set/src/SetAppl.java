import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetAppl {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10, 20);
		Rectangle r2 = new Rectangle(10, 20);
		Rectangle r3 = new Rectangle(20, 10);
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		System.out.println(r3.hashCode());

		Rectangle r4 = new Rectangle(1, 1);
		Rectangle r5 = new Rectangle(0, 32);
		System.out.println(r4.hashCode());
		System.out.println(r5.hashCode());

		Set<Rectangle> set = new LinkedHashSet<>(Arrays.asList(r1, r2, r3, r4, r5));
		System.out.println(set);
		System.out.println(set.size());
		
	}

}
