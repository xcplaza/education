import java.util.Arrays;

public class ComparableAppl {

	public static void main(String[] args) {
		int[] ar = { 3, 0, 1, 5, 8, 9, 2, 1 };
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		String[] strs = { "xyz", "Abc", "bbc", "abc" };
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));

		Cats[] cats = { new Cats("Barsik", 10, "color1", 3000.), new Cats("Murzik", 4, "color2", 3700.),
				new Cats("Bogdana", 10, "color4", 10000.), new Cats("Masha", 1, "color0", 7000.4),
				new Cats("Masha2", 1, "color40", 7000.) };
		Arrays.sort(cats);

		sort(cats);
		System.out.println(Arrays.toString(cats));

	}

	public static void sort(Cats[] cats) {
		boolean flSorted = true;
		do {
			flSorted = true;
			for (int i = 0; i < cats.length - 1; i++) {
				if (cats[i].compareTo(cats[i + 1]) > 0) {
					swap(i, i + 1, cats);
					flSorted = false;
				}
			}
		} while (!flSorted);
	}

	private static void swap(int i, int j, Cats[] cats) {
		Cats temp = cats[i];
		cats[i] = cats[j];
		cats[j] = temp;

	}

}
