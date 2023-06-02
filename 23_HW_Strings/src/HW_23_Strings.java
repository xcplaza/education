
public class HW_23_Strings {

	public static void main(String[] args) {
		String str = "Hello world";
		System.out.println(str + " = " + reverseString(str));
		char c = 'l';
		System.out.println("Count char (" + c + "): " + countChar(str, c));
		str = "Aa12345~";
		System.out.println("Password: " + validPassword(str));
	}

	public static String reverseString(String str) {
		if (str == null || str.isBlank()) {
			return "Wrong sring";
		}
		char[] ar = str.toCharArray();
		char temp;
		for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
			temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
		}
		String strRevers = new String(ar);
		return strRevers;
	}

	public static int countChar(String str, char c) {
		if (str == null || str.isBlank())
			return -1;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}
		return count;
	}

	public static boolean validPassword(String password) {
		if (password == null || password.length() < 8)
			return false;
		boolean upFlag = false, lowFlag = false, numFlag = false, specFlag = false;
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isDigit(ch)) {
				numFlag = true;
			} else if (Character.isUpperCase(ch)) {
				upFlag = true;
			} else if (Character.isLowerCase(ch)) {
				lowFlag = true;
			} else if (password.charAt(i) == '~' 
					|| password.charAt(i) == '!' 
					|| password.charAt(i) == '-'
					|| password.charAt(i) == '_') {
				specFlag = true;
			}
			if (numFlag && upFlag && lowFlag && specFlag)
				return true;
		}
		return false;
	}
}