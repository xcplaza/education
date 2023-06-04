
public class CW_24_StringBuilderInt {
	private static final int N_RUNS = 100_000;

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		System.out.println("Capacity = " + sb1.capacity());
		System.out.println("Size = " + sb1.length());

		StringBuilder sb2 = new StringBuilder("Hello");
		System.out.println("Capacity = " + sb2.capacity());
		System.out.println("Size = " + sb2.length());
		sb2.append("qazwsxedcrfvtgbrf"); // конкатинация для StringBuilder
		System.out.println("Capacity = " + sb2.capacity());
		System.out.println("Size = " + sb2.length());
		sb2.append("Bye");
		System.out.println("Capacity = " + sb2.capacity());
		System.out.println("Size = " + sb2.length());

		StringBuilder sbTest = new StringBuilder("Zelenoglazka");
		sbTest.reverse();
		System.out.println(sbTest);
		System.out.println(sbTest.charAt(0));
		sbTest.deleteCharAt(0);
		System.out.println(sbTest.reverse());
		System.out.println(sbTest.indexOf("leno"));
		System.out.println(sbTest.lastIndexOf("l"));
		System.out.println(sbTest.substring(3));
		System.out.println(sbTest.capacity());
		System.out.println(sbTest.toString().length());

		long timeStamp = System.currentTimeMillis();
		concatWithString();
		System.out.println("Time string = " + (System.currentTimeMillis() - timeStamp));
		timeStamp = System.currentTimeMillis();
		concatStrimBuilder();
		System.out.println("Time stringBuilder = " + (System.currentTimeMillis() - timeStamp));

	}

	private static void concatStrimBuilder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N_RUNS; i++) {
			sb.append("aa");
		}

	}

	private static void concatWithString() {
		String str = "";
		for (int i = 0; i < N_RUNS; i++) {
			str = str.concat("aa");
		}

	}

}
