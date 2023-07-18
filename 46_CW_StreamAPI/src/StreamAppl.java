import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAppl {

	public static void main(String[] args) {
		Movie[] array = { new Movie("a", 2021, 4.), new Movie("b", 2022, 4.5), new Movie("c", 2021, 4.5),
				new Movie("d", 2022, 3.5), new Movie("e", 2022, 5.5), new Movie("f", 2022, 5.5) };
		System.out.println(Arrays.stream(array).mapToDouble(m -> m.rating).average().getAsDouble());

		System.out.println("\n-----------------boxed----------------");
		List<Integer> list = new Random().ints(10, 1, 100).boxed().toList();
		System.out.println(list);

		System.out.println("\n---------------flatMap----------------");
		String[] str = Stream.of("Mama myla ramu", "Hello world!").flatMap(s -> Arrays.asList(s.split("")).stream())
				.toArray(String[]::new);
		System.out.println(Arrays.toString(str));

		System.out.println("\n----------012 0123 0 01 0123----------");
		Stream.of(2, 3, 0, 1, 3).flatMapToInt(x -> IntStream.range(0, x + 1)).forEach(System.out::print);

		ArrayList<Company> list1 = new ArrayList<>(
				Arrays.asList(new Company("a", new ArrayList<>(Arrays.asList("Masha", "Sasha"))),
						new Company("b", new ArrayList<>(Arrays.asList("Dasha", "Sasha"))),
						new Company("c", new ArrayList<>(Arrays.asList("Masha", "Pasha")))));

		System.out.println("\n--------------employees---------------");
		list1.stream().flatMap(c -> c.employees.stream()).distinct().forEach(System.out::println);

		System.out.println("\n--------------employees2--------------");
		list1.stream().mapMulti((c, sink) -> {
			for (String name : c.employees) {
				sink.accept(name);
			}
		}).forEach(System.out::println);

		System.out.println("\n================TERMINAL==============");

		System.out.println("\n-----------mapToInt - count-----------");
		long count = Arrays.stream(array).mapToInt(m -> m.year).filter(y -> y == 2022).count();
		System.out.println(count);

		System.out.println("\n-----------mapToDouble - sum-----------");
		double sum = Arrays.stream(array).mapToDouble(m -> m.rating).sum();
		System.out.println(sum);

		System.out.println("\n-----------mapToDouble - min-----------");
		double min = Arrays.stream(array).mapToDouble(m -> m.rating).min().getAsDouble();
		System.out.println(min);

		System.out.println("\n----mapToDouble - summaryStatistics---");
		DoubleSummaryStatistics ss = Arrays.stream(array).mapToDouble(m -> m.rating).summaryStatistics();
		System.out.printf("Count: %d, min: %.2f, max: %.2f, avg: %.2f, sum: %.2f\n", ss.getCount(), ss.getMin(),
				ss.getMax(), ss.getAverage(), ss.getSum());

		System.out.println("\n------------reduce-acc=0---------------");
		int sum1 = Stream.of(1, 2, 3, 4, 5, 6, 7).reduce(0, (acc, num) -> acc + num);
		System.out.println(sum1);

		System.out.println("\n------------reduce-acc=1---------------");
		int sum2 = Stream.of(1, 2, 3, 4, 5, 6, 7).reduce(1, (acc, num) -> acc * num);
		System.out.println(sum2);

		System.out.println("\n---------------reduce------------------");
		int sum3 = Stream.of(1, 2, 3, 4, 5, 6, 7).reduce((acc, num) -> acc * num).orElse(0);
		System.out.println(sum3);

		System.out.println("\n---------------reduce2-----------------");
		double sum4 = Arrays.stream(array).mapToDouble(m -> m.rating).reduce((acc, r) -> acc).orElse(0);
		System.out.println(sum4);

		System.out.println("\n-----------------Match-----------------");
		System.out.println(Arrays.stream(array).allMatch(m -> m.year == 2022));
		System.out.println(Arrays.stream(array).anyMatch(m -> m.year == 2022));
		System.out.println(Arrays.stream(array).noneMatch(m -> m.year == 2022));

		System.out.println("\n-----------------find------------------");
		System.out.println(Arrays.stream(array).findFirst().get());
		System.out.println(Arrays.stream(array).findAny().get());
		System.out.println();
		System.out.println(Arrays.stream(array).parallel().findFirst().get());
		System.out.println(Arrays.stream(array).parallel().findAny().get());

		System.out.println("\n----------------forEach-----------------");
		Arrays.stream(array).forEach(System.out::println);
		System.out.println();
		Arrays.stream(array).forEachOrdered(System.out::println);
		System.out.println("**************************");
		Arrays.stream(array).parallel().forEach(System.out::println);
		System.out.println();
		Arrays.stream(array).parallel().forEachOrdered(System.out::println);

	}

}
