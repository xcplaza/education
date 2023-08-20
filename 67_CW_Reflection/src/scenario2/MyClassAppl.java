package scenario2;

import java.lang.reflect.Method;

public class MyClassAppl {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) { // method4 hellomethod1 bye
		Class clazz = MyClass.class;
		for (Method m : clazz.getMethods()) {
			System.out.println(m);
		}
		System.out.println("===========================");
		for (Method m : clazz.getDeclaredMethods()) {
			System.out.println(m);
		}
		System.out.println("===========================");
		Class parent = clazz.getSuperclass();
		for (Method m : parent.getDeclaredMethods()) {
			System.out.println(m);
		}
		System.out.println("===========================");
		MyClass obj = new MyClass();
		for (int i = 0; i < args.length; i += 2) {
			try {
				Method m = clazz.getDeclaredMethod(args[i], String.class);
				m.setAccessible(true); //открываем доступ с private method
				m.invoke(obj, args[i + 1]);
				m.setAccessible(false);
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

	}

}
