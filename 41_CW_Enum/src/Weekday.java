
public enum Weekday {
	SUN, MON, TUE, WED, THU, FRI, SAT;

//	свойтство - переход по дням
	public Weekday plusDays(int days) {
		Weekday[] array = values();
		int index = ordinal();
		return array[(index + days) % array.length];
	}
}
