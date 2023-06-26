import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAppl {

	public static void main(String[] args) {
		Cats[] cats = { 
				new Cats("Barsik", 10, "color1", 3000.), 
				new Cats("Murzik", 4, "color2", 3700.),
				new Cats("Bogdana", 10, "color4", 10000.), 
				new Cats("Masha", 1, "colorTest", 7000.9),
				new Cats("Masha", 1, "color0", 7000.4),
				new Cats("Masha2", 1, "color40", 7000.) };

//		Arrays.sort(cats, new ComparatorByAge()); // сравнение по возрасту прямое

//		============================================== сравнение по возрасту прямое
		Comparator<Cats> comp = new ComparatorByAge();
		sort(cats, comp);
		System.out.println(Arrays.toString(cats));
//		============================================== сравнение по возрасту обратное
		comp = new ComaratorByAgeRevers();
		sort(cats, comp);
		System.out.println(Arrays.toString(cats));
//		============================================== сравнение по имени прямое
		comp = new ComaratorByName();
		sort(cats, comp);
		System.out.println(Arrays.toString(cats));
//		============================================== сравнение обратное по имени
		comp = new ComaratorByName().reversed();
		sort(cats, comp);
		System.out.println(Arrays.toString(cats));
//		============================================== сравнение по возрасту (основной) и имени и прайсу
		comp = new ComparatorByAge().thenComparing(new ComaratorByName().thenComparing(new ComrataorByPrice()));
		sort(cats, comp);
		System.out.println(Arrays.toString(cats));

	}

	public static void sort(Cats[] cats, Comparator<Cats> comp) {
		boolean flSorted;
		do {
			flSorted = true;
			for (int i = 0; i < cats.length - 1; i++) {
				if (comp.compare(cats[i], cats[i + 1]) > 0) {
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
