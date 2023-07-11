
public enum Weekday {
	SUN, MON, TUE, WED, THU, FRI, SAT;

//	свойтво - переход по дня
	public Weekday plusDays(int days) {
		Weekday[] array = values();
		int index = ordinal();
		return array[(index + days) % array.length];
	}
}
