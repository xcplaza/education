package telran.treeSetAppl;
import java.util.Arrays;
import java.util.*;

public class TreeSetAppl {

	public static void main(String[] args) {
		TreeSet<Cat> cats = new TreeSet<>();
		Cat cat1 = new Cat(10, "Cats1", 12345);
		Cat cat2 = new Cat(5, "Cats2", 322223);
		Cat cat3 = new Cat(11, "ACats", 876543);
		Cat cat4 = new Cat(3, "BCats4", 765433);
		Cat cat5 = new Cat(5, "BCats4", 765433);
		cats.addAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		displayCats(cats);

		TreeSet<Cat> cats2 = new TreeSet<>(new CatsComparatorByAge());
		cats2.addAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		displayCats(cats2);
//===============================
		Integer[] numbers = { 200, 20, 1000, 80, 10, 100 };
		TreeSet<Integer> set = new TreeSet<>(Arrays.asList(numbers));
		displaySet(set);
		int min = 20, max = 100;
		removeFromSet(set, min, max);
		displaySet(set);

		displaySet(set.headSet(201));
		displaySet(set.tailSet(100));

	}

	private static void removeFromSet(TreeSet<Integer> set, int min, int max) {
//		view !!!!
//		Set<Integer> temp = set.subSet(min, max);

//		new object - копия
//		Set<Integer> temp = new TreeSet<Integer>(set.subSet(min, max));
//		temp.clear();

		set.subSet(min, max).clear();
	}

	private static void displaySet(Set<Integer> set) {
		for (Integer num : set) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static void displayCats(TreeSet<Cat> cats) {
		for (Cat cat : cats) {
			System.out.println(cat);
		}
		System.out.println();
	}
}
