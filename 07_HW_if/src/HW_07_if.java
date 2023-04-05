
public class HW_07_if {

	public static void main(String[] args) {
//		time
		float time = 7.59f;
		amPm(time);

//		medtest
		int age = 55;
		int puls = 109;
		medtest(puls, age);
	}

	public static void amPm(float time) {
		int hour = (int) time;
		int min = (int) ((time - hour) * 100);

		// Проверка корректности значений времени
		if (hour < 0 || hour > 23) {
			System.out.println("Некорректное значение часов.");
			return;
		}
		if (min < 0 || min > 0.59001) {
			System.out.println("Некорректное значение минут.");
			return;
		}

		// Определение am или pm
		boolean isPm = hour >= 12;
		if (hour == 0 || hour == 12) {
			hour = 12;
		} else if (hour > 12) {
			hour -= 12;
		}

		// вывод времени
		System.out.printf("%02d:%02d %s%n", hour, min, isPm ? "PM" : "AM");
	}

	public static void medtest(int puls, int age) {
		if (age > 0 && age < 35 && puls > 40 && puls < 120 || age >= 35 && age <= 55 && puls > 40 && puls < 110
				|| age > 55 && puls > 40 && puls < 100) {
			System.out.println("Medical test passed!");
		} else {
			System.out.println("Medical test failed!");
		}
	}
}