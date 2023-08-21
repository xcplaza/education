
public class MyTestClass {
	String array[];

	public MyTestClass() {
		array = new String[1000];
		for (int i = 0; i < array.length; i++) {
			array[i] = "Hello";
		}
	}

	void f1() {
	}

	void f2() {
	}

	@Test(nRuns = 1000)
	void stringJoinBuilder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
	}

	@Test(nRuns = 1000)
	void stringJoinString() {
		String str = new String();
		for (int i = 0; i < array.length; i++) {
			str = str + array[i];
		}
	}
}
