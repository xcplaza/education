public class Methods {

	public static void main(String[] args)
	{
		method1 ();
		System.out.println("***********");
		method2();
		
		int x;
		int y;
		x=10; // 2 - может выполниться по порядку
		y=20; // 1 - может выполниться по порядку
		System.out.println(x);
		System.out.println(y);
		Other.test();
		
		int res = getNumber();
		System.out.println(res);
		System.out.println(getNumber1());
		
		printNumber(-111);
		printNumber(res);
		
		printData(y, res);
		
		double temp = sum (10.1, 20.2);
		System.out.println(temp);
		
		System.out.println(sum(getNumber(), getNumber1()));
//		System.out.println(sum(111, 11));
//		System.out.println(sum(122));
		
	}
	
	// принимает значение и возвращает
	public static double sum(double x, double y) 
	{
		return x + y;
	}
	
	// принимает значение и ничего не возвращает
	public static void printNumber(int number) 
	{
		System.out.println(number);
	}
	
	// принимает несколько значение и ничего не возвращает
	public static void printData(int number, double num) 
	{
		System.out.println(number);
		System.out.println(num);
	}
	
	// возвращает значение и не принимает ничего
	public static int getNumber()
	{
		return 111;
	}
	
	
	
	
	public static int getNumber1()
	{
		int x = 11;
		return x;
	}
	
	public static void method1 ()
	{
		System.out.println("I'm method1");
		method2();
	}
	public static void method2 ()
	{
		System.out.println("I'm method2");
		Other.test();
	}

}
