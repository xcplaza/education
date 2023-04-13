
import java.util.Scanner;

public class Practic_Build {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int floorCount = scan.nextInt();

		if (floorCount >= 1 && floorCount <= 4) {
			System.out.println("малоэтажный дом");
		} else if (floorCount >= 5 && floorCount <= 8) {
			System.out.println("Среднеэтажный дом");
		} else if (floorCount >= 9) {
			System.out.println("Многоэтажный дом");
		} else {
			System.out.println("Wrong numbers floor");
		}
	}

}
