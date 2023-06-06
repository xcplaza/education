
public class HW_24_StringBuilder {

	/*
	 * дополнение к домашке метод должен вернуть индекс самого первого символа
	 * который в строке встречается подряд наибольщее количество раз (например:
	 * "aaabbccccddddd" -> 9)
	 * 
	 * public static int maxCharIndex(String str) { }
	 * 
	 * 2. написать метод java который должен вывести на консоль тот символ который
	 * встречается больщеее количество раз (если симвоолов несколько т.е. одинаковые
	 * по количеству, вывести все эти символы, пробелы не учитываем)
	 * 
	 * public static void maxCharOccurances(String str){ str -> "Mama myla ramu"
	 * ->(вывести на консоль) -> например вывести 'a' 'm'
	 * 
	 * 
	 */

	public static void main(String[] args) {
		String str = "aaabbccccdddd";
		System.out.println(maxCharIndex(str));

		str = "Mama myla ramu";
		maxCharOccurances(str);
	}

	public static int maxCharIndex(String str) {
		if (str == null || str.isBlank()) {
			return -1;
		}

		char[] ar = str.toCharArray();
		int count = 0;
		int maxCount = 0;
		char maxChar = 0;

		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i] == ar[i + 1]) {
				count++;

				if (count >= maxCount) {
					maxCount = count;
					maxChar = ar[i];
				}
			} else {
				count = 0;
			}
		}
		return str.indexOf(maxChar);
	}

	public static void maxCharOccurances(String str) {
		if (str == null || str.isBlank()) {
			System.out.println("Wrong data");
			return;
		}
		str = str.replace(" ", "");
		str = str.toLowerCase();
		StringBuilder sb = new StringBuilder();
		char[] ar = str.toCharArray();
		int count = 0;
		int maxCount = 0;
		char symbol = 0;

		for (int i = 0; i < sb.length() - 1; i++) {
			for (int j = 1; j < i; j++) {
				if (ar[i] == ar[j - 1])
					count++;
			}
			if (count > maxCount) {
				maxCount = count;
				count = 0;
				sb.append(ar[i]++);
				symbol = ar[i];
			}

		}
		System.out.println(symbol);

	}

}
