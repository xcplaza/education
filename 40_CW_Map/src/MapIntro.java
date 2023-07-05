import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapIntro {

	public static void main(String[] args) {
		Map<String, Integer> months = new TreeMap<>();
		fillMap(months);
		System.out.println(months);
		System.out.println(months.put("May", 5));
		System.out.println(months);
		System.out.println(months.put("May", 15));
		System.out.println(months);

		System.out.println(months.putIfAbsent("Apr", 7));
		System.out.println(months);
		System.out.println(months.putIfAbsent("Dec", 12));
		System.out.println(months);

		Map<String, Integer> temp = new LinkedHashMap<>();
		temp.put("Sep", 9);
		temp.put("Nov", 11);
		months.putAll(temp);
		System.out.println(months);

		System.out.println(months.containsKey("Jan"));
		System.out.println(months.containsKey("Oct"));
		System.out.println(months.containsValue(1));
		System.out.println(months.containsValue(10));

		System.out.println(months.get("Jan"));
		System.out.println(months.get("Oct"));
		System.out.println(months.getOrDefault("Jan", 100500));
		System.out.println(months.getOrDefault("Oct", 100500));

		months.put("HRT", null);
		System.out.println(months);
//		months.put(null, 22);
//		System.out.println(months);

		System.out.println(months.remove("Jan"));
		System.out.println(months);
		System.out.println(months.remove("Oct"));
		System.out.println(months);
		System.out.println(months.remove("Feb", 20));
		System.out.println(months);
		System.out.println(months.remove("Feb", 2));
		System.out.println(months);

		System.out.println(months.isEmpty());
		months.clear();
		System.out.println(months.isEmpty());
		System.out.println(months);

		fillMap(months);
		iteratingKeys(months);
		iteratingValues(months);
		iteratingEntries(months);

		Map<Integer, Integer> randomNumbers = getRandomNumbers(0, 10, 100);
		System.out.println(randomNumbers);

		System.out.println();
		String str = "abc, lmn ab a lmn: a a ab-lmn";
//		a - 3
//		lmn - 3
//		ab - 2
//		abc - 1
		displayWordCounts(str);

	}

	private static void displayWordCounts(String str) {
		String[] words = str.split("[^a-zA-Z]+");
		HashMap<String, Integer> temp = new HashMap<>();
		for (String w : words) {
			temp.put(w, temp.getOrDefault(w, 0) + 1);
		}
		ArrayList<Entry<String, Integer>> list = new ArrayList<>(temp.entrySet());
		list.sort(new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int res = o2.getValue() - o1.getValue();
				return res != 0 ? res : o1.getValue().compareTo(o2.getValue());
			}
		});
		for (Entry<String, Integer> e : list) {
			System.out.printf("%s - %d\n", e.getKey(), e.getValue());
		}
	}

	private static Map<Integer, Integer> getRandomNumbers(int min, int max, int count) {
		TreeMap<Integer, Integer> temp = new TreeMap<>();
		for (int i = 0; i < count; i++) {
			int number = (int) (Math.random() * (max - min + 1) + min);
//			solution 1			
//			Integer value = temp.get(number);
//			Integer newValue = value == null ? 1 : value + 1; //сколько раз встречаем число при генерации
//			temp.put(number, newValue);

//			solution 2
//			Integer value = temp.getOrDefault(number, 0);
//			temp.put(number, value + 1);

//			solution 3
			temp.put(number, temp.getOrDefault(number, 0) + 1);
		}
		return temp;
	}

	private static void iteratingEntries(Map<String, Integer> months) {
		System.out.println("\nIterating entries:");
		for (Entry<String, Integer> e : months.entrySet()) {
			System.out.println(e);
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		System.out.println();
	}

	private static void iteratingValues(Map<String, Integer> months) {
		System.out.println("\nIterating keys:");
		for (Integer v : months.values()) {
			System.out.println(v);
		}
		System.out.println();
	}

	private static void iteratingKeys(Map<String, Integer> months) {
		System.out.println("\nIterating keys:");
		for (String s : months.keySet()) {
			System.out.println(s);
		}
		System.out.println();
	}

	private static void fillMap(Map<String, Integer> months) {
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
	}

}
