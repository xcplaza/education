//import java.util.regex.Pattern;

public class StringExpressions {

	public static boolean isProgrammingName(String str) {
		// allowed letters - Any English letter
		// allowed digits - any digit
		// allowed symbols _
		// first symbol can't be a digit
		String pattern = "^[a-zA-Z_][\\w]*$";
		return str.matches(pattern);
	}

	public static Object isThreeDigitsNumber(String str) {
		String pattern = "\\b(?!00)\\d{3}";
		return str.matches(pattern);
	}

	public static boolean isWord(String str) {
		String pattern = "^(?:non\\-w|[Ww])ord$";
		return str.matches(pattern);
	}

	public static boolean isPositiveLessThan1000(String str) {
		String pattern = "\\b(?!00)\\d{1,3}";
		return str.matches(pattern);
	}

	public static boolean isPositiveLessThan300(String str) {
		String pattern = "\\d|\\d{1,3}[^300]";
		return str.matches(pattern);
	}

}
