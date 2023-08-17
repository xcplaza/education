package scenario3;

import java.util.Arrays;

public class CatAppl {

	public static void main(String[] args) {
		Cat cat = new Cat("name", 10, false);
		Class clazz = cat.getClass();

		System.out.println(Arrays.toString(clazz.getFields()));
		System.out.println("===========================");
		System.out.println(Arrays.toString(clazz.getDeclaredFields()));
	}

}
