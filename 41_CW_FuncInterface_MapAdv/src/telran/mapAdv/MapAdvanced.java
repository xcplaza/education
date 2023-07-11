package telran.mapAdv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapAdvanced {

	public static void main(String[] args) {
		Map<String, Integer> months = new TreeMap<>();
		fillMap(months);
//		compute -  ключ по get существует и значение не null - перезапишет, если не было - добавит
		Integer res = months.compute("Dec", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return u != null ? u + 100 : null;
			}
		});
		System.out.println("res = " + res);
		System.out.println(months);

//		=============================================
//		computeIfPresent - только если есть пара (ключ/знач) - работает, если нет пары (ключ/знач) - делать ничего не будет
		months.computeIfPresent("Dec", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return u + 10;
			}
		});
		System.out.println(months);

//		=============================================
//		computeIfPresent - только если нет ключа
		months.computeIfAbsent("Dec", new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return numberOfMonth();
			}
		});
		System.out.println(months);

		months.put("Jan", 20);
		System.out.println(reverseMap(months));

//		=============================================
//		key - have & value = null - add
//		key - have & return null - delete
//		key - have & value - have = merge
		System.out.println(months);
		months.merge("Jan", 100, new BiFunction<Integer, Integer, Integer>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				return null;
			}
		});
		System.out.println(months);
//		=============================================
		Map<String, String> map = new HashMap<>();
		map.put("question", "Bla?");
		System.out.println(map);
		map.merge("question", "Blabla", new BiFunction<String, String, String>() {

			@Override
			public String apply(String t, String u) {
				return u + t;
			}
		});
		System.out.println(map);
//		=============================================

		months.replaceAll(new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return 1000;
			}
		});
		System.out.println(months);
	}

//	revers String - > Integer
	private static Map<Integer, List<String>> reverseMap(Map<String, Integer> map) {
		Map<Integer, List<String>> res = new HashMap<>();
		for (String s : map.keySet()) {
			Integer value = map.get(s);
			res.compute(value, new BiFunction<Integer, List<String>, List<String>>() {
				@Override
				public List<String> apply(Integer t, List<String> u) {
					if (u == null)
						u = new ArrayList<>();
					u.add(s);
					return u;
				}
			});
		}
		return res;
	}

	protected static Integer numberOfMonth() {
		return 20;
	}

	private static void fillMap(Map<String, Integer> months) {
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
	}
}
