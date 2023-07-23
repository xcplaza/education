import java.io.*;
import java.util.Arrays;

public class BufferedInputOutput {

	public static void main(String[] args) throws IOException {
//		InputStreamReader input = new InputStreamReader(System.in);
//		BufferedReader breader = new BufferedReader(input, 10000);
//		OR
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in), 10000);

		while (true) {
			System.out.println("Enter numbers separeted by space or exit");
			String line = breader.readLine();
			if (line.equalsIgnoreCase("exit"))
				break;
			if (line.isBlank()) {
				System.out.println("Enter numbers, please!");
				continue;
			}
			String[] temp = line.trim().split("\\s+");
			try {
				System.out.println("Sum = " + Arrays.stream(temp).mapToInt(Integer::parseInt).sum());
			} catch (Exception e) {
				System.out.println("Enter only numbers and space, please!");
			}
		}

	}

}
