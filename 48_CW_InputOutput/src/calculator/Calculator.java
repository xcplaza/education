package calculator;

import java.util.HashMap;
import java.util.*;
import java.util.function.BinaryOperator;

public class Calculator {

	static Map<String, BinaryOperator<Integer>> mapOperations;
	static {
		mapOperations = new HashMap<>();
		mapOperations.put("+", (x, y) -> x + y);
		mapOperations.put("-", (x, y) -> x - y);
		mapOperations.put("x", (x, y) -> x * y);
		mapOperations.put("/", (x, y) -> y == 0 ? null : x / y);
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter first openrad or exit for quit");
				String line = s.nextLine();
				if (line.equalsIgnoreCase("exit"))
					break;
				int op1 = Integer.parseInt(line);

				System.out.println("Enter operator [+, -, *, /] or exit for quit");
				line = s.nextLine();
				if (line.equalsIgnoreCase("exit"))
					break;
				String operator = line;

				System.out.println("Enter second openrad or exit for quit");
				line = s.nextLine();
				if (line.equalsIgnoreCase("exit"))
					break;
				int op2 = Integer.parseInt(line);

				System.out.println("res = " + computeOne(op1, op2, operator));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Integer computeOne(Integer res, Integer operand, String operator) {
		return mapOperations.get(operator).apply(res, operand);
	}

}
