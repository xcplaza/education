package game;
import java.io.*;
import java.util.*;

public class BullsAndCows {
	private static final int MIN = 1;
	private static final int MAX = 9;

	public static void main(String[] args) throws IOException {

		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Enter 4 numbers <1234> or exit");
			String line = breader.readLine();
			if (line.equalsIgnoreCase("exit"))
				break;
			if (line.isBlank()) {
				System.out.println("Enter numbers, please!");
				continue;
			}
			String[] temp = line.trim().split("\\s+");
			try {
				String res = randomNumbers(MIN, MAX);
				System.out.println(res);
//				System.out.println("Sum = " + Arrays.stream(temp).mapToInt(Integer::parseInt).sum());
			} catch (Exception e) {
				System.out.println("Enter only numbers and space, please!");
			}
		}
	}

	public static String randomNumbers(int min, int max) {
		Random random = new Random();
		int res = random.nextInt(max - min + 1) + min;
		String generated = String.format("%04d", random.nextInt((max - min + 1) + min));

		return generated;

	}
}
