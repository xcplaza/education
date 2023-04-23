
public class CW_13_StringInt {

	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(str);
//		str += " world!"; //str = str + " world!";
		String str1 = "Hello";
		System.out.println(str == str1);

		System.out.println(str.equals(str1));

		String str2 = new String("Bye");
		String str3 = new String("Bye");
		System.out.println(str2 == str3);

		System.out.println(str2.equals(str3));

		str = 2 + 3 + "number" + 4 + 5;
		System.out.println(str);
		greeting("Vasya Pupkin");
		String name = "Donald Trump";
		greeting(name);

	}

	private static void greeting(String name) {
		System.out.println("Dear " + name + "! Welcome to Israel!");
	}

}
