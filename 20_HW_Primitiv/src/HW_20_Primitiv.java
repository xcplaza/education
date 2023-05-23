
public class HW_20_Primitiv {

	public static void main(String[] args) {
		minMaxByte();
	}

	public static void minMaxByte() {
		byte min = findMinByte();
		byte max = findMaxByte();

		short minS = findMinShort();
		short maxS = findMaxShort();
		
		int minI = findMinInt();
		int maxI = findMaxInt();
		
//		long minL = findMinLong();
//		long maxL = findMaxLong();
		
		char minC = findMinChar();
		char maxC = findMaxChar();

		System.out.println("minimal byte value: " + min);
		System.out.println("maximal byte value: " + max);

		System.out.println("\nminimal short value: " + minS);
		System.out.println("maximal short value: " + maxS);
		
		System.out.println("\nminimal int value: " + minI);
		System.out.println("maximal int value: " + maxI);
		
//		System.out.println("\nminimal long value: " + minL);
//		System.out.println("maximal long value: " + maxL);
		
		System.out.println("\nminimal char value: " + minC);
		System.out.println("maximal char value: " + maxC);
	}

	private static byte findMinByte() {
		byte value = 0;
		byte count;
		do {
			count = value;
			value--;
		} while (value < count);

		return (byte) (value + 1);
	}

	private static byte findMaxByte() {
		byte value = 0;
		byte count;
		do {
			count = value;
			value++;
		} while (value > count);

		return (byte) (value - 1);
	}

	private static short findMinShort() {
		short value = 0;
		short count;
		do {
			count = value;
			value--;
		} while (value < count);

		return (short) (value + 1);
	}

	private static short findMaxShort() {
		short value = 0;
		short count;
		do {
			count = value;
			value++;
		} while (value > count);

		return (short) (value - 1);
	}
	
	private static int findMinInt() {
		int value = 0;
		int count;
		do {
			count = value;
			value--;
		} while (value < count);

		return (int) (value + 1);
	}

	private static int findMaxInt() {
		int value = 0;
		int count;
		do {
			count = value;
			value++;
		} while (value > count);

		return (int) (value - 1);
	}
	
	private static long findMinLong() {
		long value = 0;
		long count;
		do {
			count = value;
			value--;
		} while (value < count);

		return (long) (value + 1);
	}

	private static long findMaxLong() {
		long value = 0;
		long count;
		do {
			count = value;
			value++;
		} while (value > count);

		return (long) (value - 1);
	}
	
	private static char findMinChar() {
		char value = 0;
		char count;
		do {
			count = value;
			value--;
		} while (value < count);

		return (char) (value + 1);
	}

	private static char findMaxChar() {
		char value = 0;
		char count;
		do {
			count = value;
			value++;
		} while (value > count);

		return (char) (value - 1);
	}
}
