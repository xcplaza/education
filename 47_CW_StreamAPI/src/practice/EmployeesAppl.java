package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeesAppl {

	public static void main(String[] args) {
		List<Employeer> list = new ArrayList<>(
				Arrays.asList(new Employeer("Masha", "IBM", 10000), new Employeer("Gosha", "IBM", 10100),
						new Employeer("Dasha", "Moto", 10000), new Employeer("Kolya", "Moto", 20000),
						new Employeer("Petya", "IBM", 30000), new Employeer("Vasya", "Moto", 30000),
						new Employeer("Pasha", "IBM", 30000), new Employeer("Vasya", "Apple", 30000)

				));
		displayMinMaxAvgSalary(list);
		displayCompanyAvgSalary(list, "IBM");
		displayEmployeesGreaterAvgSalary(list);// name -> salary

		displayBiggestCompanies(list); // наибольшее количество сотрудников в компании - только название компании
		displayCompaniesAboveAverSalary(list); // название компании - у которой средняя з/п >= по всем компаниям

		int interval = 1000;
		displayEmployeesBySalaryInInterval(list, interval);
//		[10000 - 19999] -> "Masha", "Dasha"
//		[20000 - 29999] -> "Kolya"
//		[30000] -> "Petya", "Pasha", "Vasya"

		System.out.println();
		String text = "lmn, vf, ab 0 a9 lmn: ab_ -imn ab";
		displayWordCounts(text);
//		1.split
//		2.count
//		3.sort -> count -> alphabet
//		4.print "string -> count" a -> 1 vf -> 1 ab -> 3 lmn -> 3 
	}

	private static void displayWordCounts(String text) {
		String[] ar = text.split("[^a-zA-Z]+");
		System.out.println(Arrays.toString(ar));
		Map<String, Long> map = Arrays.stream(ar).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println("Map: " + map);
		map.entrySet().stream()
				.sorted((e1, e2) -> e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey())
						: Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
	}

	private static void displayEmployeesBySalaryInInterval(List<Employeer> list, int interval) {
		Map<Integer, List<Employeer>> res = list.stream()
				.collect(Collectors.groupingBy(e -> e.salary / interval, TreeMap::new, Collectors.toList()));
		res.forEach((k, v) -> System.out.printf("[%d-%d) - %s\n", k * interval, (k + 1) * interval, v));
	}

	private static void displayCompaniesAboveAverSalary(List<Employeer> list) {
		double avgSalary = list.stream().collect(Collectors.averagingInt(e -> e.salary));
		System.out.printf("\nAVG salary: %.2f", avgSalary);
		System.out.println();
		Map<String, Double> map = list.stream()
				.collect(Collectors.groupingBy(e -> e.company, Collectors.averagingInt(e -> e.salary)));
		map.entrySet().stream().filter(ent -> ent.getValue() > avgSalary)
				.forEach(ent -> System.out.println("Company: " + ent.getKey()));
//		OR
//		map.forEach((k, v) -> {
//			if(v > avgSalary)
//				System.out.println("Company: " + k);
//		} );
	}

	private static void displayBiggestCompanies(List<Employeer> list) {
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(e -> e.company, Collectors.counting()));
		long max = map.values().stream().collect(Collectors.maxBy((v1, v2) -> Long.compare(v1, v2))).orElse(0L);
		map.entrySet().stream().filter(e -> e.getValue() == max)
				.forEach(ent -> System.out.println("Company: " + ent.getKey()));
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
