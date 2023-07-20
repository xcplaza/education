import java.util.ArrayList;
import java.util.Scanner;

public class ScannerAppl {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
//		System.out.println("Enter your name: ");
//		str = scan.nextLine();
//		System.out.println("Welcome to Israel, " + str);

		ArrayList<String> names = new ArrayList<>();
		while (true) {
			System.out.println("Enter name text or exit for quit");
			String res = scan.nextLine();
			if (res.equalsIgnoreCase("exit"))
				break;
//			System.out.println("Your text is \"" + res + "\"");
			names.add(res);
		}
		System.out.println(names);
	}

}
