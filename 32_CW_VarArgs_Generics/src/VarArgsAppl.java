import java.util.Arrays;

public class VarArgsAppl {

	public static void main(String[] args) {
		testVarArgsArint(new int[0]);
		testVarArgs();
		testVarArgs(1);
		testVarArgs(1, 2, 3);
		testVarArgs(new int[] { 1, 2, 3, 4, 5 });
//		testVarArgs(100, new int[] { 1, 2, 3, 4, 5 });
//		testVarArgs(new int[] { 10, 11 }, new int[] { 1, 2, 3, 4, 5 }); //принимает только один аргумент
		testVarArgs2(100, new int[] { 1, 2, 3, 4, 5 });

	}

	private static void testVarArgs2(int i, int... ar) {
		System.out.println("Test varArgs");
		System.out.println(ar.length);
		System.out.println(i);

	}

	public static void testVarArgsArint(int[] ar) {
		System.out.println("Test");
	}

	public static void testVarArgs(int... ar) { // метод принимает динамическое количество аргументов
		System.out.println("Test varArgs");
		System.out.println(ar.length);
		System.out.println(Arrays.toString(ar));
//		System.out.println(ar[0]); //так тоже можно

	}

}
