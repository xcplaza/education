
public class CW_11_ASCII_Itr {

	public static void main(String[] args) {
		char ch = 'P';
		System.out.println(ch);
		System.out.println((int) ch);
//		ch = (char) (ch + 4);
		ch += 4;
		System.out.println(ch);

		ch = 123;
		System.out.println(ch);

//		printASCII();

		char start = 'A';
		char finish = 'z';
		int col = 4;
		printASCIIRange(start, finish, col);
	}

	public static void printASCIIRange(char start, char finish, int col) {
		if (start < 32 || finish > 126 || finish < start || col < 1) {
			System.out.println("Wrong args");
			return;
		}
		for (int count = 1; start <= finish; start++, count++) {
			System.out.print((int)start + " -> " + start + " \t");
			if (count % col == 0)
				System.out.println();
		}
		System.out.println();

	}

	public static void printASCII() {
		for (char count = 32; count < 127; count++) {
			System.out.print((int) count + " -> " + count + " \t"); // 80 -> P
			if (count % 3 == 1)
				System.out.println();
		}
		System.err.println();
	}
}
