package telran.employees.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import telran.employees.dto.Programmer;

public class ProgrammersMaps implements IProgrammer {

	private Map<Integer, Programmer> programmers = new HashMap<>();

	public ProgrammersMaps(Map<Integer, Programmer> programmers) {
		super();
		this.programmers = programmers;
	}

	@Override
	public boolean addProgrammer(Programmer programmer) {
		if (programmer == null)
			return false;
		return programmers.putIfAbsent(programmer.getId(), programmer) == null ? true : false;
	}

	@Override
	public boolean removeProgrammer(int id) {
		if (id < 0)
			return false;
		return programmers.remove(id) != null ? false : true;
	}

	@Override
	public Programmer getProgrammerData(int id) {
		if (id < 0)
			return null;
		return programmers.get(id);
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {
		if (id < 0 || technology.isEmpty())
			return false;
		return programmers.get(id).getTechnologies().add(technology);
	}

	@Override
	public boolean removeTechnology(int id, String technology) {
		if (id < 0 || technology.isEmpty())
			return false;
		return programmers.get(id).getTechnologies().remove(technology);
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSalary(int id, int salary) {
		if (id < 0 || salary < 0)
			return false;
		programmers.get(id).setSalary(salary);
		return true;
	}

}
