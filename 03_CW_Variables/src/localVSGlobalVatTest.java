
public class localVSGlobalVatTest {
	public static int testGlobal = 100500;
	public final static int CONST = 1000;
	
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a);
		System.out.println(testGlobal);
		f1();
		System.out.println(testGlobal);
		System.out.println(CONST);
	}
	
	public static void f1() {
		double a = 3.14;
		System.out.println(a);
		testGlobal = -10;
//		CONST = 2000; (нельзя заменить переменную константу)
		System.out.println(testGlobal);
		System.out.println(CONST);
	}

}
