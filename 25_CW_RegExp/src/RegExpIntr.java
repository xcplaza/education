
public class RegExpIntr {

	public static void main(String[] args) {
		String str = "  \t\n  ";
		System.out.println(str.matches("\\s+")); // проверяем на пробелы

	}

	public static boolean isTrue(String str) {
		String pattern = "[Tt]ru[eE]";
		return str.matches(pattern);
	}

	public static boolean isNumber(String str) {
		String pattern = "0|(-?[1-9]\\d*)";
		return str.matches(pattern);
	}

}
