
public class SplitAppl {

	public static void main(String[] args) {
		String text = "FIFA, will never: reget; it";
		String[] words = text.split("[:;,]?\\s"); // вычищаем слова без разделителей

		text = "a    \tPreved     b";
		words = text.split("\\s");

		printStrings(words);
	}

	private static void printStrings(String[] words) {
		for (int i = 0; i < words.length; i++) {
			System.out.println("[" + words[i] + "]");
		}

	}
	/*
	 * принимаем строку с арифметикой (только положительные и целочисленные) надо
	 * посчитать как они будут (без учета приоритета) *усложнение  с приоритетом
	 * 10 +10-10 = 10
	 * 10 * 10-10 = 90
	 */
}
