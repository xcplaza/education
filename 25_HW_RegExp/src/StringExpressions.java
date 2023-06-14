//import java.util.regex.Pattern;

public class StringExpressions {

	public static boolean isProgrammingName(String str) {
		if (str == null || str.isBlank())
			return false;
		// allowed letters - Any English letter
		// allowed digits - any digit
		// allowed symbols _
		// first symbol can't be a digit
		String pattern = "[a-zA-Z_]\\w*";
		return str.matches(pattern);
	}

	public static Object isThreeDigitsNumber(String str) {
		if (str == null || str.isBlank())
			return false;
		String pattern = "[1-9]\\d{2}";
		return str.matches(pattern);
	}

	public static boolean isWord(String str) {
		if (str == null || str.isBlank())
			return false;
//		String pattern = "^(?:non\\-w|[Ww])ord$";
		String pattern = "[a-zA-Z]|([a-zA-Z][a-z]*-?[a-z]+)";
		return str.matches(pattern);
	}

	public static boolean isPositiveLessThan1000(String str) {
		if (str == null || str.isBlank())
			return false;
//		String pattern = "\\b(?!00)\\d{1,3}";
		String pattern = "[0]|([1-9]\\d{0,2})";
		return str.matches(pattern);
	}

	public static boolean isPositiveLessThan300(String str) {
		if (str == null || str.isBlank())
			return false;
//		String pattern = "\\d|\\d{1,3}[^300]";
		String pattern = "\\d|[1-9]\\d|[12]\\d{2}";
		return str.matches(pattern);
	}

	public static boolean isPositiveLessThanEquals255(String str) {
		if (str == null || str.isBlank())
			return false;
		String pattern = "[1-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5]";
		return str.matches(pattern);
	}

	public static boolean isIsraelMobile(String str) {
		if (str == null || str.isBlank())
			return false;
		String pattern = "(\\+972-?5|05)[0-8](-?\\d){7}";
		return str.matches(pattern);
	}

}
