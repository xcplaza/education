
public class IfIntr {

	public static void main(String[] args) {
		int a = 0;
		if (a >= 0) {
			System.out.println("Hello");
		}
		// если строка выполнения одна можно без фигурных скобок, но лучше так не
		// делать!
		if (a >= 0) {
			System.out.println("Hello2");
		} else {
			System.out.println("Bye 2");
		}

//		gender = false - man, true - woman
		boolean gender = false, married = true;
		double salary = 29450.;
		int age = -41;
		System.out.printf("My salary: %.2f\n", bachelorTax(salary, age, gender, married));

		isPositive(a);

		System.out.println("End program");

	}

	public static void isPositive(int a) {
		if (a > 0) {
			System.out.println("Positive");
		} else if (a < 0) {
			System.out.println("Negative");
		} else {
			System.out.println("Zero");
		}
	}

	public static double bachelorTax(double salary, int age, boolean gender, boolean married) {
		if (salary <= 0. || age <= 14 || age > 120) {
			System.out.println("Wrong args");
			return Double.NaN;
		}
		if (age >= 24 && age <= 65 && gender == false && married == false) {
			return salary * (1 - 0.19); // 19% налог
		} else {
			return salary * (1 - 0.13); // 13% налог
		}

//		return age >= 24 && age <= 65 && gender == false && married == false ? salary * 0.81 : salary * 0.87;
	}

}
