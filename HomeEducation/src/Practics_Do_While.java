
public class Practics_Do_While {

//	вывод нечетных чисел
	public static void main(String[] args) {
		for (int i = 0; i <= 15; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}

}
