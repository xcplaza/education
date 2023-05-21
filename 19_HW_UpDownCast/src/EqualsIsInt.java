
public class EqualsIsInt {

	public static void main(String[] args) {
		Employee mng1 = new Manager("John Doe", 30, true, "Apple", "mng1", 5500., 5);
		Employee mng2 = new Manager("Alice Brown", 59, true, "HP", "mng2", 7000., 3);
		Employee mng3 = new Manager("David Lee", 60, true, "Dell", "mng3", 8000., 1);
		Employee mng4 = new Manager("Em Anders", 28, true, "Comp", "mng4", 6000., 2);
		Employee wag1 = new WageEmployee("Jane Smith", 27, false, "Apple", "wag1", 3000., 40, 80);
		Employee wag2 = new WageEmployee("Bob Davis", 80, false, "HP", "wag2", 5000., 35, 70);
		Employee wag3 = new WageEmployee("Amy Taylor", 43, true, "Dell", "wag3", 2000., 30, 100);
		Employee sal1 = new SaleManager("Mike Johnson", 42, true, "Apple", "sal1", 1000., 15500., 0.2);
		Employee sal2 = new SaleManager("Karen Wilson", 18, false, "HP", "sal2", 1000., 19730., 0.2);
		Employee sal3 = new SaleManager("Steven Miller", 70, true, "Dell", "sal3", 1000., 20130., 0.2);
		Employee emp = new Manager("Em Anders", 28, true, "Comp", "mng4", 6000., 2);
		Employee[] people = { mng1, mng2, mng3, mng4, wag1, wag2, wag3, sal1, sal2, sal3 };

		int index2 = searchEmployee(people, emp);
		System.out.println(index2);

		int[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int value = 5;
		int index = searchNumber(ints, value);
		System.out.println(index);

		String str = "qwerty";
		String str2 = "qwerty";
		System.out.println(str.equals(str2));
		String str3 = "QweRty";
		System.out.println(str.equals(str3));
		System.out.println(str.equalsIgnoreCase(str3));

	}

	private static int searchEmployee(Employee[] people, Employee emp) {
		for (int i = 0; i < people.length; i++) {
//			if (people[i] == emp)
			if (people[i].equals(emp))
				return i;
		}
		return -1;
	}

	private static int searchNumber(int[] ints, int value) {
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] == value)
				return i;
		}
		return -1;
	}

}
