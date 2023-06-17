public class Calculator {

	public static Object computeExpression(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		String[] parts = str.split("\\s*(?=[+\\-*/])|(?<=[+\\-*/])\\s*");
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equals(" ")) {
				parts[i] = parts[i].replaceAll("\\s+", "");
			}

		}
		if (parts.length % 2 != 1) {
			return null;
		}
		int result;
		if (!isInteger(parts[0])) {
			return null;
		} else {
			result = Integer.parseInt(parts[0]);
		}

		for (int i = 1; i < parts.length; i += 2) {
			String operator = parts[i];
			if (!isInteger(parts[i + 1])) {
				return null;
			}
			int operand = Integer.parseInt(parts[i + 1]);
			switch (operator) {
			case "+":
				result += operand;
				break;
			case "-":
				result -= operand;
				break;
			case "*":
				result *= operand;
				break;
			case "/":
				if (operand == 0) {
					return null;
				}
				result /= operand;
				break;
			default:
				return null;
			}
		}
		return result;
	}

	private static boolean isInteger(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		int length = str.length();
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
}
