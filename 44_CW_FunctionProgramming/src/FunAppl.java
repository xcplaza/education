import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FunAppl {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 4, -20, -4));
		List<Integer> res = find(list, new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				if (t < 5) {
					return false;
				}
				return t % 2 == 0;
			}
		});
		System.out.println("Even numbers: " + res);

//		лямда-блок имеет {}
//		(params) -> {body}
		res = find(list, (t) -> {
			if (t < 5) {
				return false;
			}
			return t % 2 == 0;
		});

		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		System.out.println("Sorted list: " + list);

		list.sort((o1, o2) -> {
			return o2 - o1;
		});
		System.out.println("New sorted: " + list);

		list.sort((o1, o2) -> Integer.compare(o1, o2));
		System.out.println("Inte_New sorted: " + list);

//		метод референс
//		className::methodName
		list.sort(Integer::compare);
		System.out.println("Inte_New2 sorted: " + list);

//		(parametr) -> {body}
		res = find(list, t -> {
			return t % 2 == 0;
		});
		System.out.println("Sorted list: " + list);

//		(no param) -> {body}
//		res = find(list, () -> {return t % 2 == 0;});
//		System.out.println("Sorted list: " + list);

//		лямда-выражение
		res = find(list, t -> t % 2 == 0);
		System.out.println("L-Sorted list: " + list);

		list.sort((o1, o2) -> o2 - o1);
		System.out.println("L-New sorted: " + list);

		res = find(list, x -> x < 5 || x > 10 ? true : false);

		list.sort(FunAppl::evenOdd);
		System.out.println("Custom evenOdd sorted: " + list);

		list.forEach(t -> System.out.println("forEach: " + t));
		list.forEach(System.out::println);
		
		
	}

	private static int evenOdd(int x, int y) {
		if (x % 2 == 0 && y % 2 != 0)
			return -1;
		if (x % 2 != 0 && y % 2 == 0)
			return 1;
		if (x % 2 == 0 && y % 2 == 0)
			return x - y;
		return y - x;
	}

	private static List<Integer> find(List<Integer> list, Predicate<Integer> predicate) {
		List<Integer> res = new ArrayList<>();
		for (Integer i : list) {
			if (predicate.test(i))
				res.add(i);
		}
		return res;
	}
}
