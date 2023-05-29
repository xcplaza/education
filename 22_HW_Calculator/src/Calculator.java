
public class Calculator {

	public static void main(String[] args) {
		if (args == null || args.length != 3) {
			System.out.println("Wrong arrays!");
			return;
		}

		for (int i = 0; i < args.length; i++) {
			if (args[i] == null) {
				System.out.println("Arrays is null!");
				return;
			}
			double op1 = Double.parseDouble(args[0]);
			double op2 = Double.parseDouble(args[2]);
			String op3 = args[1];
			double result = 0;

			switch (op3) {
			case "+":
				result = op1 + op2;
				break;
			case "-":
				result = op1 - op2;
				break;
			case "x":
				result = op1 * op2;
				break;
			case "/":
				result = op1 / op2;
				break;
			default:
				System.out.println("Wrong value: " + op3);
			}
			System.out.println(result);

		}

	}

}
