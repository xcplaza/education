
public class EmployeeAppl {

	public static void main(String[] args) {

		Employee em1 = new Employee("HP", 12000., 1, "Ivan", 123, 18);
		Employee em2 = new Employee("Compaq", 8000., 3, "Petr", 456, 23);
		Employee em3 = new Employee("Qualcom", 27000., 6, "Serg", 789, 34);
		Employee em4 = new Employee("Dell", 50000., 2, "Jeron", 321, 70);
		Employee em5 = new Employee("Intel", 32000., 4, "Dan", 654, 57);
		Employee em6 = new Employee("Apple", 46000., 5, "Mike", 987, 37);

		Employee[] employee = { em1, em2, em3, em4, em5, em6 };

		System.out.println("\n============Netto===========\n");
		AllEmployeeNetto(employee);
		System.out.println("\n============Brutto==========\n");
		AllEmployeeBrutto(employee);
		System.out.println("\n=============All============\n");
		AllEmployee(employee);
		System.out.println("\n========Summary salary======\n");
		sumSalary(employee);
//		System.out.println("Summary salary: " + sumSalary(employee));
	}

//	метод нетто
	public static void AllEmployeeNetto(Employee[] employee) {
		if (employee == null || employee.length == 0) {
			System.out.println("Wrong arrays!");
			return;
		}
		for (int i = 0; i < employee.length; i++) {
			if (employee[i] == null)
				continue;
			System.out.println(employee[i].display(true));
		}
	}

//	метод брутто
	public static void AllEmployeeBrutto(Employee[] employee) {
		if (employee == null || employee.length == 0) {
			System.out.println("Wrong arrays!");
			return;
		}
		for (int i = 0; i < employee.length; i++) {
			if (employee[i] == null)
				continue;
			System.out.println(employee[i].display(false));
		}
	}

//	 метод выводящий на информацию по всем сотрудникам без отображения зарплаты
	public static void AllEmployee(Employee[] employee) {
		if (employee == null || employee.length == 0) {
			System.out.println("Wrong arrays!");
			return;
		}
		for (int i = 0; i < employee.length; i++) {
			if (employee[i] == null)
				continue;
			System.out.println(employee[i].display());
		}
	}

//	 метод выводящий общую сумму затрат компании на зарплату 5-ых сотрудников
	public static void sumSalary(Employee[] employee) {
		if (employee == null || employee.length == 0) {
			System.out.println("Wrong arrays!");
			return;
		}
		int sum = 0;
		for (int i = 0; i < employee.length; i++) {
			if (employee[i] == null)
				continue;
			sum += employee[i].salary();
		}
		System.out.println(sum);
	}
}
