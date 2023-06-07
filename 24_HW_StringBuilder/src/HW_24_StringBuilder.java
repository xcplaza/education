
public class HW_24_StringBuilder {

	public static void main(String[] args) {
		String str = "aaabbccccdddd";
		System.out.println(maxCharIndex(str));

		str = "Mama myla ramu";
		maxCharOccurances(str);
	}

	/*
	 * дополнение к домашке метод должен вернуть индекс самого первого символа
	 * который в строке встречается подряд наибольщее количество раз (например:
	 * "aaabbccccddddd" -> 9) public static int maxCharIndex(String str) { }
	 */

	public static int maxCharIndex(String str) {
		if (str == null || str.isBlank()) {
			return -1;
		}

		char[] ar = str.toCharArray();
		int count = 1, maxCount = 0, indexStart = 0, indexMax = 0;
		char maxChar = 0;

		for (int i = 1; i < ar.length - 1; i++) {
			if (ar[i] == ar[i + 1]) {
				count++;

				if (count >= maxCount) {
					maxCount = count;
					maxChar = ar[i];
					indexMax = indexStart;
				}
			} else {
				count = 1;
			}
			if (count > maxCount)
				maxChar = ar[i];
			indexMax = indexStart;
		}

		return str.indexOf(maxChar);
	}

	/*
	 * 2. написать метод java который должен вывести на консоль тот символ который
	 * встречается больщее количество раз (если символов несколько т.е. одинаковые
	 * по количеству, вывести все эти символы, пробелы не учитываем) public static
	 * void maxCharOccurances(String str){ str -> "Mama myla ramu" -> вывести на
	 * консоль -> 'a' 'm'
	 */

	public static void maxCharOccurances(String str) {
		if (str == null || str.isBlank()) {
			return;
		}
		str = str.replace(" ", "");
		str = str.toLowerCase();
		char[] ar = str.toCharArray();
		int count = 0;
		int maxCount = 0;
		char[] symbols = new char[ar.length];
		int symbolCount = 0;

		for (int i = 0; i < str.length(); i++) {
			count = 0;
			for (int j = 0; j < str.length() - i; j++) {
				if (ar[i] == ar[j]) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				symbolCount = 1;
				symbols[0] = ar[i];
			} else if (count == maxCount) {
				symbols[symbolCount] = ar[i];
				symbolCount++;
			}
		}

		for (int i = 0; i < symbolCount; i++) {
			System.out.println("'" + symbols[i] + "'");
		}
	}
}
