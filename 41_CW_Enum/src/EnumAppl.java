import java.util.Arrays;

public class EnumAppl {

	public static void main(String[] args) {
		Weekday firstWeekday = Weekday.FRI;
		Weekday secondWeekday = Weekday.FRI;
		System.out.println(firstWeekday == secondWeekday);
		System.out.println(firstWeekday == Weekday.FRI);

		displayCommentWeekDay(Weekday.WED);

		Person person = new Person(111, "Vasya", Gender.MALE);
		System.out.println(person);

		Weekday[] array = Weekday.values();
		System.out.println(Arrays.toString(array));

		System.out.println(Weekday.valueOf("SUN"));
		Weekday day = Weekday.valueOf("MON");
//		day = Weekday.valueOf(null); // так делать нельзя
		System.out.println(Weekday.SUN.ordinal());
		System.out.println(Weekday.SAT.ordinal());
		String name = Weekday.FRI.name();
		System.out.println(name);
		
		System.out.println(Weekday.SUN.plusDays(16));
	}

	private static void displayCommentWeekDay(Weekday day) {
		switch (day) {
		case SUN:
			System.out.println("First working day in Israel");
			break;
		case SAT:
			System.out.println("Shabat");
			break;
		case FRI:
			System.out.println("Week end for Israel");
			break;
		default:
			System.out.println("No Week");
			break;
		}

	}

}
