
public class MethodsInOut {

	public static void main(String[] args) {
////		option 1
//		int res = mariya();
//		System.out.println(res);
////		option 2
//		System.out.println(mariya());
//
//		int res2 = valera(res + 1);
//		System.out.println(res);
//		System.out.println(res2);
		
		double cash = 200.;
		double amount = 150.;
		int discount = 10;
		double change = change(cash, amount, discount);
		System.out.println("change = " + change + " NIS");

	}

	private static double change(double cash1, double amount1, int discount1) {
		double price = amount1 * (1 - discount1/100.);
		return cash1 - price;
	}

	public static int valera(int money) { // int money =101
		return money + 50;
	}

	public static int mariya() {
		return 100;
	}

}
