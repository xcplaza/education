
public class ExceptiosAppl {

	public static void main(String[] args) {
		int x = 2;
		if (x < 20) {
			try {
				throw new MyException("Number x must be equals 20");
//				int y = x * 2;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				method();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
//			method1();
			double res;
			try {
				res = div(10, 0);
			} catch (Exception e) {
				res = 100;
			}
			System.out.println(res);
			System.out.println(res + 1);
//			System.out.println(div(10, 0));

			getNumber(1, 10);
			System.out.println("the end");
		}
	}

	public static int getNumber(int min, int max) {
		while (true) {
			int random = (int) (min + Math.random() * (max - min + 1));
			try {
				System.out.println(random);
				if (random < max / 2)
					throw new Exception();
				return random;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static double div(double x, double y) {
		if (y == 0)
			throw new ArithmeticException("Divide by zero");
		return x / y;
	}

	public static void method() throws MyException {
		System.out.println("I am a method");
		throw new MyException("Ooops");
	}

	public static void method1() throws RuntimeException {
		System.out.println("I am a method2");
		throw new RuntimeException("Ooops2");
	}
}
