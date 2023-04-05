// 1.How many functions does “main”calls?
// метод "main" вызывает три функции: function6(), function1() и function2().
//
// 2.Which functions are not called?
// метод function3() не вызывается.
// 
// 3.Which functions don’t call any other functions?
// метод function6() и function3() не вызывает другие методы.
//
// 4.Draw snapshot of a stack with maximal amount of the functions into a stack
// снимок стека с максимальным количеством методов:
//
// main
// function1()
// function4()
// function5()
// function6()
// 
//
// 5.Make a new project, and write code of this diagram

public class HWmethods {

	public static void main(String[] args)
	{		
		System.out.print("main ");
		function6();
		System.out.print("main ");
		function1();
		System.out.print("main ");
		function2();
	}
	
	public static void function1()
	{
		System.out.print("f1 ");
		function4();
	}

	public static void function2()
	{
		System.out.print("f2 ");		
		function6();
	}

	public static void function3()
	{
		System.out.print("f3 ");		
	}

	public static void function4()
	{
		System.out.print("f4 ");		
		function5();
	}

	public static void function5()
	{
		System.out.print("f5 ");	
		function6();
	}

	public static void function6()
	{
		System.out.print("f6\n");
	}
	
}
