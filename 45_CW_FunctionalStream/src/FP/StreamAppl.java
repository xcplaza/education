package FP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamAppl {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Movie[] array = { new Movie("a", 2021, 4.), new Movie("b", 2022, 4.5), new Movie("c", 2021, 4.5),
				new Movie("d", 2022, 3.5), new Movie("e", 2022, 5.) };
//		solution 1 - from array
		Stream<Movie> str1 = Arrays.stream(array);

//		solution 2 - from collection
		ArrayList<Movie> list = new ArrayList<>(Arrays.asList(array));
		Stream<Movie> str2 = list.stream();
		Set<Movie> set = new HashSet<>(Arrays.asList(array));
		str2 = set.stream();

//		solution 3 - from entry-Map (из Map нельзя сделать stream)
		Map<String, Movie> map = new HashMap<>();
		Stream<Entry<String, Movie>> str3 = map.entrySet().stream();

//		solution 4 - from other values
		Stream<String> str4 = Stream.of("a", "b", "c", "d");

//		solution 5 - from String
		IntStream str5 = "hello".chars();

//		solution 6 - builder (значения любые - но нужны одинаковые)
		Stream<Object> str6 = Stream.builder().add("1").add(2).add(true).build();

		IntStream.iterate(1, x -> x * 2).limit(10).forEach(System.out::println);

//		solution 8 - generate
		Stream.generate(() -> "Hello world!").limit(10).forEach(System.out::println);
		Stream.generate(() -> new Random().nextBoolean()).limit(10).forEach(System.out::println);

//		solution 9 - range
		LongStream.range(1, 10).forEach(System.out::println);
	}

}
