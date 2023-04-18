import java.util.Scanner;

public class CalcEnergy {
    public static void main(String[] args) {
        double febDiscount = 0.068; // скидка на оплату в феврале 6.8%
        double cost = 66.55; // стоимость 1 кВт в 2022 году

        int prevKwatt = 16209; // предыдущее значение kWt
        System.out.println("Введите текущее значение kWt: ");
        Scanner scanner = new Scanner(System.in);
        int currentKwatt = scanner.nextInt();

        double totalSum = calculateTotalSum(currentKwatt, prevKwatt, cost, febDiscount);
        double sum = calculateSum(currentKwatt, prevKwatt, cost);
        
        System.out.printf("Сумма к оплате в 2022 году = %.2f\n", sum);
        System.out.printf("Сумма к оплате в 2023 году = %.2f\n", totalSum);
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
