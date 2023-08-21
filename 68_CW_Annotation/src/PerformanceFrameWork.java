
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PerformanceFrameWork {

	public static void run(Object obj) {
		Class<?> clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			runMethod(m, obj);
		}
	}

	private static void runMethod(Method m, Object obj) {
		Test test = m.getAnnotation(Test.class);
		if (test != null) {
			m.setAccessible(true);
			printResult(m, obj, test.nRuns());
			m.setAccessible(false);
		}
	}

	private static void printResult(Method m, Object obj, int nRuns) {
		Instant start = Instant.now();
		String name = m.getName();
		for (int i = 0; i < nRuns; i++) {
			try {
				m.invoke(obj);
			} catch (Exception e) {
				System.out.printf("Method %s doesn't match test requairements\n", name);
			}
		}
		System.out.printf("Method %s run %d milliseconds\n", name, ChronoUnit.MILLIS.between(start, Instant.now()));
	}

}
