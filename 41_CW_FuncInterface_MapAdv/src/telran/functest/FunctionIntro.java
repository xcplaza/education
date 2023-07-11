package telran.functest;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionIntro {

	public static void main(String[] args) {
		Function<String, Integer> fun = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		System.out.println(fun.apply("Hello world!"));

		Function<String, String> funUpperCase = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		};
		System.out.println(funUpperCase.apply("hello world!"));

		BiFunction<String, String, String> biFun1 = new BiFunction<String, String, String>() {
			@Override
			public String apply(String t, String u) {
				return t + u;
			}
		};
		System.out.println(biFun1.apply("Hello ", "world"));

		BiFunction<String, Integer, String> biFun2 = new BiFunction<String, Integer, String>() {
			@Override
			public String apply(String t, Integer u) {
				return t.repeat(u);
			}
		};
		System.out.println(biFun2.apply("Hello ", 3));

		ThreeFunction<String, Integer, Boolean, String> threeFun = new ThreeFunction<String, Integer, Boolean, String>() {
			@Override
			public String apply(String a, Integer b, Boolean c) {
				return c ? a.repeat(b).toUpperCase() : a.repeat(b).toLowerCase();
			}
		};
		System.out.println(threeFun.apply("Hello ", 4, false));
		System.out.println(threeFun.apply("Hello ", 4, true));
	}

}
