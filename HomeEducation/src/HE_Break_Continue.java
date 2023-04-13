
public class HE_Break_Continue {

	public static void main(String[] args) {
		brk(args);
		contin(args);
	}

	public static void brk(String[] args) {
		int i = 0;
		while (true) {
			i++;
			if (i == 15) {
				break;
			}
			System.out.println(i);
		}
		System.out.println("End cycle");
	}

	public static void contin(String[] args) {
		for (int i = 0; i <= 15; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println("number = " + i);
		}
	}
}
