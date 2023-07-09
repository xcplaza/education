package telran.employees.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import telran.employees.dto.Programmer;

public class ProgrammersMaps implements IProgrammer {

	private Map<Integer, Programmer> programmers = new HashMap<>();
	private HashMap<String, List<Programmer>> techProgrammers = new HashMap<>();
	private TreeMap<Integer, List<Programmer>> salaryProgrammers = new TreeMap<>();

	public ProgrammersMaps(Map<Integer, Programmer> programmers) {
		super();
		this.programmers = programmers;
	}

	@Override
	public boolean addProgrammer(Programmer programmer) {
		if (programmer == null)
			return false;
		for (String str : programmer.getTechnologies()) {
			techProgrammers.putIfAbsent(str, new ArrayList<>());
			techProgrammers.get(str).add(programmer);
		}
		salaryProgrammers.putIfAbsent(programmer.getSalary(), new ArrayList<>());
		salaryProgrammers.get(programmer.getSalary()).add(programmer);
		return programmers.putIfAbsent(programmer.getId(), programmer) == null ? true : false;
	}

	@Override
	public boolean removeProgrammer(int id) {
		if (id < 0 || !(programmers.containsKey(id)))
			return false;
		Programmer rmv = getProgrammerData(id);
		for (String tech : rmv.getTechnologies())
			techProgrammers.get(tech).remove(rmv);
		salaryProgrammers.remove(id);
		return programmers.remove(id) != null ? true : false;

	}

	@Override
	public Programmer getProgrammerData(int id) {
		if (id < 0 || !(programmers.containsKey(id)))
			return null;
		return programmers.get(id);
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {
		if (id < 0 || technology.isEmpty() || !(programmers.containsKey(id)))
			return false;
		List<Programmer> tempTechProg = techProgrammers.getOrDefault(technology, new ArrayList<>());
		techProgrammers.put(technology, tempTechProg);
		return programmers.get(id).getTechnologies().add(technology);
	}

	@Override
	public boolean removeTechnology(int id, String technology) {
		if (id < 0 || technology.isEmpty() || !(programmers.containsKey(id)))
			return false;
		Programmer programmer = getProgrammerData(id);
		programmer.getTechnologies().remove(technology);
		return programmers.get(id).getTechnologies().remove(technology);
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
		if (technology.isEmpty())
			return null;
		List<Programmer> res = techProgrammers.get(technology);
//		List<Programmer> res = new ArrayList<>();
//		for (Programmer programmer : programmers.values()) {
//			Set<String> tech = programmer.getTechnologies();
//			if (!tech.isEmpty() && tech.contains(technology)) {
//				res.add(programmer);
//			}
//		}
		return res != null ? res : new ArrayList<>();
	}

	@Override
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo) {
		if (salaryFrom < 0 || salaryFrom > salaryTo)
			return null;
		List<Programmer> res = new ArrayList<>();
		for (List<Programmer> list : salaryProgrammers.subMap(salaryFrom, salaryTo).values()) {
			res.addAll(list);
		}
//		for (Programmer programmer : programmers.values()) {
//			int salary = programmer.getSalary();
//			if (salary >= salaryFrom && salary <= salaryTo) {
//				res.add(programmer);
//			}
//		}
		return new ArrayList<>(res);
	}

	@Override
	public boolean updateSalary(int id, int salary) {
		if (id < 0 || salary <= 0 || !(programmers.containsKey(id)))
			return false;
		Programmer programmer = getProgrammerData(id);
		salaryProgrammers.get(programmer.getSalary()).remove(programmer);
		programmer.setSalary(salary);
		List<Programmer> tempSalProg = salaryProgrammers.getOrDefault(salary, new ArrayList<>());
		salaryProgrammers.put(salary, tempSalProg);
//		programmers.get(id).setSalary(salary);
		return true;
	}

}