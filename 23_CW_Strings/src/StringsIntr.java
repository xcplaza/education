
public class StringsIntr {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = new String("Hello2");
		char[] chars = { 'H', 'e', 'l', 'l', 'o', '3' };
		String str3 = new String(chars);
		System.out.println(str1 + " , " + str2 + " , " + str3);

		printStringInCollumn(str1);
	}

	public static void printStringInCollumn(String str) {
		if (str == null || str.isBlank()) {
			System.out.println("Wrong Arrays!");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

//	метод проверяет в массиве цифра иил нет
	public static boolean isNumber(String str) {
		if (str == null || str.isBlank()) {
			System.out.println("Wrong Arrays!");
			return false;
		}
		if (str.indexOf('.') != str.lastIndexOf('.'))
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.')
				return false;
		}
		return true;
	}

	public static boolean isPalindrom(String str) {
		if (str == null || str.isBlank()) {
			return false;
		}
		str = str.trim().toLowerCase();
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
	}

}
