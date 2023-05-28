
public class WrapperInrt {
//	примитив - обертка
//	byte - Byte
//	short - Short
//	int - Integer
//	long - Long
//	================
//	float - Float
//	double - Double
//	================
//	boolean - Boolean
//	================
//	char - Character

	public static void main(String[] args) {
		int a = 6;
		Integer a1 = 10;
		System.out.println(a1 + a1);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);

		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);

		String numString = "34";
		System.out.println(numString + 10);
		String numStr = "34";
		int res = Integer.parseInt(numStr);
		System.out.println(res + 10);

		numStr = "34.5";
		double resD = Double.parseDouble(numStr);
		System.out.println(resD + 10);

		String bool = "True";
		boolean resB = Boolean.parseBoolean(bool);
		System.out.println(resB);
		
		System.out.println(Integer.toBinaryString(129));
		System.out.println(Integer.toHexString(129));
		System.out.println(Integer.toOctalString(129));
		int resX = 0x12;
		System.out.println(resX);
		resX = 020;
		System.out.println(resX);
	}

}
