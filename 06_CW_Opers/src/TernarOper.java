
public class TernarOper {

	public static void main(String[] args) {
//		condition?actionIfTrue:actionIfFalse;
		int a = 10;
//		int c = a > 0 ? System.out.printf("Hello") : System.out.printf("Bye");
		int c = a < 0 ? 222 : 50;
		System.out.println(c);

//		String res = a > 0 ? "Hello" : "Bye";
//		System.out.println(res);

		int a1 = 5, b1 = 5;
		System.out.println(isEquals(a1, b1));

		double price = 123., amount = 200.;
		int age = 70, disc = 10;
		System.out.println("change = " + change(price, amount, disc, age));

	}

	public static boolean isEquals(int a, int b) {
		return a == b ? true : false;
//		return a == b;

	}

//	age < 16 || age > 65 - disc
	public static double change(double price1, double amount1, int disc1, int age1) {
		return age1 < 16 || age1 > 65 ? amount1 - price1 * (1 - disc1 / 100.) : amount1 - price1;

	}
}
