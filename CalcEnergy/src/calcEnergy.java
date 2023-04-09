
import java.util.Scanner;

public class calcEnergy {

	public static void main(String[] args) {
		double feb = 6.8; // c февраля скидка на оплату 6.8%

//		System.out.println("Введи стоимость (в огоротах) = ?");
//		Scanner c = new Scanner(System.in);
//		int cost = c.nextInt();
		double cost = 66.55;
		System.out.println("Стоимость 1кВт в 2022 = " + cost);

//		Scanner pk = new Scanner(System.in);
//		System.out.println("Введи предыдущее значение kWt = ?");
//		int pkWt = pk.nextInt();
		int pkWt = 15794;

		Scanner k = new Scanner(System.in);
		System.out.print("Введи текущее значение kWt = ");
		int kWt = k.nextInt();
//		int kWt = 16388;

		double extCost = cost / 100;
		double perCost = (extCost * feb / 100);
		double sum = (kWt - pkWt) * extCost;
		double percent = (kWt - pkWt) * perCost;
		double perSum = sum - percent;
		System.out.printf("Сумма к оплате в 2022= %.2f\n", sum);
		System.out.printf("Сумма к оплате в 2023= %.2f\n", perSum);

	}
	
}
