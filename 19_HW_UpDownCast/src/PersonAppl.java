
public class PersonAppl {
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

		Employee[] people = { mng1, mng2, mng3, mng4, wag1, wag2, wag3, sal1, sal2, sal3 };

		AllEmp(people);
		System.out.println("\nAll salary: " + sumSalary(people) + " ₪");
		System.out.println("\nSales Sum: " + sumSales(people) + " ₪");

	}

	private static void AllEmp(Employee[] people) {
		for (int i = 0; i <= people.length - 1; i++)
			if (people[i] != null)
				System.out.println(people[i].toString());
	}

//	метод, который вернет затраты компании(зарплата всех сотрудников)
	public static int sumSalary(Employee[] people) {
		int sum = 0;
		for (int i = 0; i < people.length; i++) {
			if (people[i] == null)
				continue;
//			if (people[i] instanceof Manager) {
//				Manager temp = (Manager) people[i];
//				sum += temp.calculateSalary();
//			}
//			if (people[i] instanceof WageEmployee) {
//				WageEmployee temp = (WageEmployee) people[i];
//				sum += temp.calculateSalary();
//			}
//			if (people[i] instanceof SaleManager) {
//				SaleManager temp = (SaleManager) people[i];
//				sum += temp.calculateSalary();
//			}
			sum += people[i].calculateSalary();
		}
		return sum;
	}

//	 метод, который вернет доход компании 
	public static int sumSales(Employee[] people) {
		if (people == null || people.length == 0) {
			System.out.println("Wrong arrays!");
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < people.length; i++) {
			if (people[i] == null)
				continue;
			if (people[i] instanceof SaleManager) {
				SaleManager temp = (SaleManager) people[i]; // downCast
				sum += temp.getTotalSale();
			}
		}
		return sum;
	}
}