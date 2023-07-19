import java.lang.foreign.SymbolLookup;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAppl {

	public static void main(String[] args) {
		Movie[] array = { 
				new Movie("a", 2021, 4.), 
				new Movie("b", 2022, 4.5), 
				new Movie("c", 2021, 4.5),
				new Movie("d", 2022, 3.5), 
				new Movie("e", 2022, 5.5), 
				new Movie("f", 2022, 5.5) 
		};

		System.out.println("-------------------Collectors.toList()---------------");
		List<Movie> list = Arrays.stream(array).filter(m -> m.year == 2021).collect(Collectors.toList());
		System.out.println(list);

		list = Arrays.stream(array).filter(m -> m.year == 2021).toList();
		System.out.println(list);

		System.out.println("\n-------------------Collectors.toSet() ---------------");
		Set<Movie> set = Arrays.stream(array).filter(m -> m.rating > 4).collect(Collectors.toSet());
		System.out.println(set);

		System.out.println("\n-------------------Collectors.toSet() ---------------");
		Map<String, Double> map = Arrays.stream(array).collect(Collectors.toMap(m -> m.title, m -> m.rating));
		System.out.println(map);

		System.out.println("\n-------------------Collectors.toMap() ---------------");
		Map<String, Integer> map1 = Stream.of("Java", "Kotlin", "JavaScript", "C++")
				.collect(Collectors.toMap(s -> s, s -> s.length()));
		System.out.println(map1);
		map1 = Stream.of("Java", "Kotlin", "JavaScript", "C++")
				.collect(Collectors.toMap(Function.identity(), s -> s.length()));
		System.out.println(map1);
		map1 = Stream.of("Java", "Kotlin", "JavaScript", "C++")
				.collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(map1);
//		map дубликат ключа - мы берем старое значение С++ (key=3)
		map1 = Stream.of("Java", "Kotlin", "JavaScript", "C++", "C++")
				.collect(Collectors.toMap(Function.identity(), String::length, (oldValue, newValue) -> oldValue));
		System.out.println(map1);

		System.out.println("\n---------------Collectors.toCollection()--------------");
		LinkedList<Movie> llist = Arrays.stream(array).collect(Collectors.toCollection(() -> new LinkedList<>()));
		System.out.println(llist);
		LinkedHashSet<Movie> lhset = Arrays.stream(array).collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(lhset);

		System.out.println("\n-----------------------Movie[]------------------------");
		Movie[] res = Arrays.stream(array).filter(m -> m.rating > 4).toArray(Movie[]::new);
		System.out.println(Arrays.toString(res));

		System.out.println("\n--------------------- groupingBy-----------------------");
		Map<Double, List<Movie>> map2 = Arrays.stream(array).collect(Collectors.groupingBy(m -> m.rating));
		System.out.println(map2);

		Map<Double, Long> map3 = Arrays.stream(array)
				.collect(Collectors.groupingBy(m -> m.rating, Collectors.counting()));
		System.out.println(map3);

		System.out.println("\n----------------- groupingBy - HARD--------------------");
//		key - length -> {key - first symbol -> List<String>}
		String[] str = { "a", "aa", "aab", "aac", "cc", "ca", "cbc", "d", "ddddddd", "ccc" };
		Map<Integer, Map<Character, List<String>>> map4 = Arrays.stream(str)
				.collect(Collectors.groupingBy(String::length, 		// Map<String>, List<String>
						 Collectors.groupingBy(s -> s.charAt(0))));	// Map<Integer, Map<Char, List<String>>>
		System.out.println(map4);

		Map<Integer, Map<Character, Long>> map5 = Arrays.stream(str)
				.collect(Collectors.groupingBy(String::length, 		// Map<String>, List<String>
						 Collectors.groupingBy(s -> s.charAt(0), 	// Map<Integer, Map<Char, List<String>>>
						 Collectors.counting()))); 					// Map<Integer, Map<Char, count>>
		System.out.println(map5);

		System.out.println("\n------------- Collectors.partitioningBy --------------");
		Map<Boolean, List<Movie>> map6 = Arrays.stream(array).collect(Collectors.partitioningBy(m -> m.rating > 4));
		System.out.println(map6);
		
		Map<Boolean, Long> map7 = Arrays.stream(array).collect(Collectors.partitioningBy(m -> m.rating > 4, Collectors.counting()));
		System.out.println(map7);
		
		System.out.println("\n---------------- Collectors.joining ----------------");
		String s = Stream.of("mama", "myla", "ramu").collect(Collectors.joining());
		System.out.println(s);
		
		s = Stream.of("mama", "myla", "ramu").collect(Collectors.joining(" "));
		System.out.println(s);
		
		s = Stream.of("mama", "myla", "ramu").collect(Collectors.joining(" ", "My ", "!"));
		System.out.println(s);
		
//		key -> string length, value -> concat string *
//		{1 -> "a/d", 2 -> "aa/cc/ca", 3 -> "aab/aac/cbc/ccc" 7 -> "ddddddd"}
//		{ "a", "aa", "aab", "aac", "cc", "ca", "cbc", "d", "ddddddd", "ccc" }

		Map<Integer, String> map8 = Arrays.stream(str)
				.collect(Collectors.groupingBy(String::length, 
						Collectors.joining("/")));
	      System.out.println(map8);
		
		System.out.println("\n-------------- Collectors.groupingBy ---------------");
		Map<Double, List<String>> map9 = Arrays.stream(array)
				.collect(Collectors.groupingBy(m -> m.rating, 
				Collectors.mapping(m -> m.title, Collectors.toList())));
		System.out.println(map9);
	}

}
