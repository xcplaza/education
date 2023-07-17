package FP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class MoviesAppl {

	public static void main(String[] args) {
		Movie[] array = { new Movie("a", 2021, 4.), new Movie("b", 2022, 4.5), new Movie("c", 2021, 4.5),
				new Movie("d", 2022, 3.5), new Movie("e", 2022, 5.5), new Movie("f", 2022, 5.5) };
		displayMoviesTitle(array, 2022, 4.0);

		System.out.println("\nsolution 2");
		displayMoviesTitleFP(array, 2022, 4.0);

		Stream<Movie> str = Arrays.stream(array);
		str.distinct().forEach(System.out::println);

		System.out.println("\nsolution 3");
		Arrays.stream(array).limit(3).forEach(System.out::println);

		System.out.println("\nsolution 4");
		Arrays.stream(array).skip(5).limit(3).forEach(System.out::println);

		System.out.println("\nsolution 5");
		Arrays.stream(array).limit(3).skip(2).forEach(System.out::println);

//		Practics
//		1. Create a stream that will give you and outputs unique movie ratings to your console
		Arrays.stream(array).distinct().map(x -> x.rating).forEach(System.out::println);

//		2. Create a stream that will give you and outputs only the first unique year of movies
		Arrays.stream(array).map(x -> x.year).limit(1).forEach(System.out::println);

//		3. Create a stream that will give you and outputs only the second unique year of movies.
		Arrays.stream(array).distinct().map(x -> x.year).skip(1).limit(1).forEach(System.out::println);

//		4. Create a stream that will give you and outputs only the penultimate element of your array.
		Arrays.stream(array).skip(array.length - 2).limit(1).forEach(System.out::println);

//		5. Create a stream that will announce each next movie in the list in a format "Next movie is <our movie>", but only if they are not repeated.
		Arrays.stream(array).distinct().map(m -> m.title).forEach(t -> System.out.println("Next movie is: " + t));
		System.out.println();
		Arrays.stream(array).distinct().map(m -> "Next movie is: " + m.title).forEach(System.out::println);
	}

//	solution 1
	private static void displayMoviesTitleFP(Movie[] array, int year, double rating) {
		Arrays.stream(array).filter(m -> m.year == year && m.rating >= rating).sorted((m1, m2) -> {
			int res = Double.compare(m1.rating, m2.rating);
			return res == 0 ? m1.title.compareTo(m2.title) : res;
		}).map(m -> m.title).forEach(System.out::println);
	}

//	solution 2
	private static void displayMoviesTitle(Movie[] array, int year, double rating) {
		ArrayList<Movie> list = new ArrayList<>();
		for (Movie m : array) {
			if (m.year == year && m.rating >= rating)
				list.add(m);
		}
		list.sort(new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				int res = Double.compare(o1.rating, o2.rating);
				return res == 0 ? o1.title.compareTo(o2.title) : res;
			}
		});
		for (Movie m : list) {
			System.out.println(m.title);
		}
	}

}
