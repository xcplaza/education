import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;

//int prevKwatt = ; // предыдущее значение kWt 29/09-28/11 ()
//471.34
//int prevKwatt = 780; // предыдущее значение kWt 28/11-31/12 (13284-14064)
//int prevKwatt = 734; // предыдущее значение kWt 31/12-31/01 (14064-14798)
//1025.85
//int prevKwatt = 1411; // предыдущее значение kWt 31/01-26/03 (14798-16209)
//914.08
//int prevKwatt = 54; // предыдущее значение kWt 26/03-31/03 (16209-16263)
//int prevKwatt = 584; // предыдущее значение kWt 26/03-31/03 (16263-16847)
//432.97

public class CalcEnergy {
	static Map<String, BinaryOperator<Integer>> mapOperations;
	static {
		mapOperations = new HashMap<>();
		mapOperations.put("+", (x, y) -> x + y);
		mapOperations.put("-", (x, y) -> x - y);
		mapOperations.put("x", (x, y) -> x * y);
		mapOperations.put("/", (x, y) -> y == 0 ? null : x / y);
	}

	static Map<Integer, Integer> kWts = new HashMap<>();;
	static {
		kWts.put(1, 13284);
		kWts.put(1, 14064);
		kWts.put(2, 14798);
		kWts.put(3, 16209);
		kWts.put(4, 16263);
		kWts.put(5, 16847);
	}

	public static void main(String[] args) {
		double febDiscount = 0.068; // скидка на оплату в феврале 6.8%
		double cost = 66.55; // стоимость 1 кВт в 2022 году

//		Integer[] kWt = { 13284, 14064, 14798, 16209, 16263, 16847 };
//		List<Integer> kWts = new ArrayList<>(Arrays.asList(kWt));

		int prevKwatt = 16847; // предыдущее значение kWt
		System.out.println("Введите текущее значение kWt: ");
		try (Scanner scanner = new Scanner(System.in)) {
			int currentKwatt = scanner.nextInt();

			double totalSum = calculateTotalSum(currentKwatt, prevKwatt, cost, febDiscount);
//        double sum = calculateSum(currentKwatt, prevKwatt, cost);
//        System.out.printf("Сумма к оплате в 2022 году = %.2f\n", sum);
			System.out.printf("Примерно к оплате = %.2f\n", totalSum);
		}
	}

	private static double calculateTotalSum(int currentKwatt, int prevKwatt, double cost, double febDiscount) {
		double extCost = cost / 100;
		double discount = extCost * febDiscount;
		double sum = calculateSum(currentKwatt, prevKwatt, cost);
		double discountSum = (currentKwatt - prevKwatt) * discount;
		return sum - discountSum;
	}

	private static double calculateSum(int currentKwatt, int prevKwatt, double cost) {
		double extCost = cost / 100;
		return (currentKwatt - prevKwatt) * extCost;
	}
}
