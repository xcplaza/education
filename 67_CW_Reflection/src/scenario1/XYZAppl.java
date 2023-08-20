package scenario1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class XYZAppl {

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		1й способ - получаем ссылку через обычный объект
		Y y = new Y();
		Class<?> classY = y.getClass();

//		2й способ
		Class<?> classZ = Z.class;

//		3й способ
		Class<?> clazz = Class.forName("scenario1.Y");

//		только для wrapper (обертки)
		Class wrap = Integer.TYPE;

		System.out.println(classY);
		System.out.println(classZ);
		System.out.println(clazz);
		System.out.println(classY == clazz);
		System.out.println(Arrays.toString(clazz.getConstructors()));

		Constructor[] array = clazz.getConstructors();
		X res = (X) array[0].newInstance();

		String pack = "scenario1.";
		for (int i = 0; i < args.length; i += 2) {// Z hello Y bye Z Java Z JS
			try {
				Class<X> clazzX = (Class<X>) Class.forName(pack + args[i]);
				Constructor<X> cons = clazzX.getConstructor(String.class);

				X x = cons.newInstance(args[i + 1]);
				x.action();

			} catch (Exception e) {
				System.err.println("error " + e.getMessage());
			}
		}
	}

}
