package scenario2;

public class MyClass {
	String str;

	public static void methodStat(String srt) {
		System.out.println("Static method - " + srt);
	}

	public void method1(String str) {
		System.out.println("Method 1 - " + str);
	}

	public void method2(String str) {
		System.out.println("Method 2 - " + str);
	}

	private void method3(String str) {
		System.out.println("Method 3 - " + str);
	}

	private void method4(String str) {
		System.out.println("Method 4 - " + str);
	}

	protected void method5(String str) {
		System.out.println("Method 5 - " + str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
