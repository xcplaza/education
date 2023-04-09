
import java.util.Scanner;

public class calcEnergy {

	public static void main(String[] args) {
//		Scanner pk = new Scanner(System.in);
//		System.out.println("Введи предыдущее значение kWt = ?");
//		int pkWt = pk.nextInt();
		int pkWt = 15794;
		
		Scanner k = new Scanner(System.in);
		System.out.print("Введи текущее значение kWt = ");
		int kWt = k.nextInt();
//		int kWt = 16388;
		
//		System.out.println("Введи стоимость (в огоротах) = ?");
//		Scanner c = new Scanner(System.in);
//		int cost = c.nextInt();
		double cost = 66.55;
		System.out.println("Текущая стоимость за 1кВт " + cost);
		
		double extCost = cost / 100;
		double sum = (kWt - pkWt) * extCost;
		System.out.printf("Сумма к оплате = %.2f", sum);

	}

}
