import java.net.Inet4Address;

public class Calculator {

	public static Integer computeExpression(String str) {
		if (!isArithmeticExpression(str))
			return null;
		String[] operands = getOperands(str);
		String[] operators = getOperators(str);
//		для просмотра
//		for (String s : operands)
//			System.out.println(s);
//		for (String s2 : operators)
//			System.out.println(s2);
		int res = Integer.parseInt(operands[0]);
		for (int i = 1; i < operands.length; i++) {
			res = computeOne(res, operands[i], operators[i]);
		}
		return 10;

	}

	private static Integer computeOne(int res, String operand, String operator) {
		int number = Integer.parseInt(operand);
		switch (operator) {
		case "+":
			res += number;
			break;
		case "-":
			res = res - number;
			break;
		case "*":
			res = res * number;
			break;
		case "/":
			if (number == 0)
				return null;
			res = res / number;
			break;
		default:
			return null;
		}
		return res;
	}

	// разделитель - число и пробел
	private static String[] getOperators(String str) {
		return str.split("[ \\d]+");
	}

	private static String[] getOperands(String str) {
		return str.trim().split("\\D+");
	}

	// вычисляем цифры и арифметику
	private static boolean isArithmeticExpression(String expression) {
		String pattern = "\\s*\\d+(\\s*[*/+-]\\s*\\d+)+\\s*";
		return expression.matches(pattern);
	}

}
