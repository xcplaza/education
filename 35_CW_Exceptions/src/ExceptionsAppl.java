
public class ExceptionsAppl {

	public static void main(String[] args) {
		System.out.println("Start programm");
		try {
			Integer number = getNumber(args[0]);
			System.out.println(number + 1);
			String str = "SOS";
			str.charAt(0);
//			int res = 2 / 0;
//			System.out.println(res);
//		}catch (Exception e) {
////			System.out.println(e.getMessage());
//			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Wrong! Number Format Exception");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wrong! Array Index Out Of Bounds Exception");
		} catch (ArithmeticException | NullPointerException e) {
			System.out.println("Wrong! " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finaly block");
		}
		System.out.println("End programm");
//		=======================================

		System.out.println("Start part 2");
		boolean res = isNumber("123");
		System.out.println("End part 2");

	}

	private static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static Integer getNumber(String str) {
		return Integer.parseInt(str);
	}

}
