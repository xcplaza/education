package scenario3;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CatAppl {

	public static void main(String[] args) throws Exception {
		Cat cat = new Cat("name", 10, false);
		Class clazz = cat.getClass();

		System.out.println(Arrays.toString(clazz.getFields()));
		System.out.println("===========================");
		System.out.println(Arrays.toString(clazz.getDeclaredFields()));

		cat.age = 120;
		System.out.println(cat.age);

		Field fieldGenger = clazz.getDeclaredField("gender");
		fieldGenger.setAccessible(true);
		fieldGenger.setBoolean(cat, true);
		System.out.println(fieldGenger.getBoolean(cat));
	}

}
