import java.time.chrono.MinguoChronology;

public class HW_20_Primitiv {

	public static void main(String[] args) {
		minMax();
	}

	public static void minMax() {
//		byte min = findMinByte();
//		byte max = findMaxByte();
//
//		short minS = findMinShort();
//		short maxS = findMaxShort();
//
//		int minI = findMinInt();
//		int maxI = findMaxInt();
//
////		long minL = findMinLong();
////		long maxL = findMaxLong();
//
//		char minC = findMinChar();
//		char maxC = findMaxChar();

		System.out.println("minimal byte value: " + getByteValue());
		System.out.println("maximal byte value: " + (byte) (getByteValue() - 1));

		System.out.println("\nminimal short value: " + getShortValue());
		System.out.println("maximal short value: " + (short) (getShortValue() - 1));

		System.out.println("\nminimal int value: " + getIntValue());
		System.out.println("maximal int value: " + (getIntValue() - 1));

		System.out.println("\nminimal long value: " + getLongValue());
		System.out.println("maximal long value: " + (long) (getLongValue() - 1));

		char minChar = 0;
		char maxChar = (char) (minChar - 1);

		System.out.println("\nminimal char value: " + (int) minChar);
		System.out.println("maximal char value: " + (int) maxChar);
	}

	private static char getCharValue() {
		char res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res;
	}

	private static long getLongValue() {
		long res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res;
	}

	private static int getIntValue() {
		int res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res;
	}

	public static byte getByteValue() {
		byte res = 1;
		while (res > 0) {
			res++;

		}
		return res;
	}

	public static short getShortValue() {
		short res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res;
	}

//	private static byte findMinByte() {
//		byte value = 0;
//		byte count;
//		do {
//			count = value;
//			value--;
//		} while (value < count);
//
//		return (byte) (value + 1);
//	}
//
//	private static byte findMaxByte() {
//		byte value = 0;
//		byte count;
//		do {
//			count = value;
//			value++;
//		} while (value > count);
//
//		return (byte) (value - 1);
//	}
//
//	private static short findMinShort() {
//		short value = 0;
//		short count;
//		do {
//			count = value;
//			value--;
//		} while (value < count);
//
//		return (short) (value + 1);
//	}
//
//	private static short findMaxShort() {
//		short value = 0;
//		short count;
//		do {
//			count = value;
//			value++;
//		} while (value > count);
//
//		return (short) (value - 1);
//	}
//	
//	private static int findMinInt() {
//		int value = 0;
//		int count;
//		do {
//			count = value;
//			value--;
//		} while (value < count);
//
//		return (int) (value + 1);
//	}
//
//	private static int findMaxInt() {
//		int value = 0;
//		int count;
//		do {
//			count = value;
//			value++;
//		} while (value > count);
//
//		return (int) (value - 1);
//	}
//	
//	private static long findMinLong() {
//		long value = 0;
//		long count;
//		do {
//			count = value;
//			value--;
//		} while (value < count);
//
//		return (long) (value + 1);
//	}
//
//	private static long findMaxLong() {
//		long value = 0;
//		long count;
//		do {
//			count = value;
//			value++;
//		} while (value > count);
//
//		return (long) (value - 1);
//	}
//	
//	private static char findMinChar() {
//		char value = 0;
//		char count;
//		do {
//			count = value;
//			value--;
//		} while (value < count);
//
//		return (char) (value + 1);
//	}
//
//	private static char findMaxChar() {
//		char value = 0;
//		char count;
//		do {
//			count = value;
//			value++;
//		} while (value > count);
//
//		return (char) (value - 1);
//	}

//	public static void minMaxByte() {
//	    byte min = (byte) (1 << 7);
//	    byte max = (byte) ((1 << 7) - 1);
//
//	    System.out.println("Min: " + min);
//	    System.out.println("Max: " + max);
//	}

}
