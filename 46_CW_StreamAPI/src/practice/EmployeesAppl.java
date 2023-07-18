package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class EmployeesAppl {

	public static void main(String[] args) {
		List<Employeer> list = new ArrayList<>(Arrays.asList(new Employeer("Masha", "IBM", 10000),
				new Employeer("Dasha", "Moto", 10000), new Employeer("Kolya", "Moto", 20000),
				new Employeer("Petya", "IBM", 30000), new Employeer("Vasya", "Moto", 30000)

		));
		displayMinMaxAvgSalary(list);
		displayCompanyAvgSalary(list, "IBM");
		displayEmployeesGreaterAvgSalary(list);// name -> salary
	}

	private static void displayEmployeesGreaterAvgSalary(List<Employeer> list) {
		if (list.isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		double avg = list.stream().mapToInt(e -> e.salary).average().getAsDouble();
		list.stream().filter(e -> e.salary >= avg)
//				.forEach(e -> System.out.println(e.name + " -> " + e.salary));
				.map(e -> new NameSalary(e.name, e.salary)).forEach(System.out::println);

	}

	private static void displayCompanyAvgSalary(List<Employeer> list, String company) {
		System.out.printf("AVG sallary %s is %.2f\n", company,
				list.stream().filter(c -> c.company.equals(company)).mapToInt(e -> e.salary).average().orElse(0));
	}

	private static void displayMinMaxAvgSalary(List<Employeer> list) {
		IntSummaryStatistics ss = list.stream().mapToInt(e -> e.salary).summaryStatistics();
		System.out.printf("min: %d, max: %d, avg: %.2f\n", ss.getMin(), ss.getMax(), ss.getAverage());
	}

}
