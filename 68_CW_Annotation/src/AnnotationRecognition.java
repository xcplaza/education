import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationRecognition {

	public static boolean a1_recognition(Class<?> clazz) {
		return clazz.isAnnotationPresent(A1.class);
	}

	public static void dispayFieldsInfo(Object obj) {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Arrays.asList(fields).forEach(f -> {
			try {
				printInfo(f, obj);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}

	private static void printInfo(Field f, Object obj) throws IllegalArgumentException, IllegalAccessException {
		A2 an = f.getAnnotation(A2.class);
//		System.out.println(Arrays.toString(A2.class.getDeclaredMethods()));
		if (an != null) {
			System.out.printf(
					"Field name = %s, field value = %s, annotation value = %s, annotation number = %d, unique = %s, field type = %s\n",
					f.getName(), f.get(obj).toString(), an.value(), an.number(), an.unique(), f.getType());
		}
	}

}
