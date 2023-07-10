package telran.employees.service;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;

import telran.employees.dto.Programmer;

public class ProgrammerTest {
	Map<Integer, Programmer> programmers;
	ProgrammersMaps s;

	String[] skils1 = { "java", "c++" };
	String[] skils2 = { "python", "kotlin" };
	String[] skils3 = { "php" };

	Programmer elik = new Programmer(302, "Elik", skils1, 20150);
	Programmer vika = new Programmer(303, "Vika", skils2, 21380);
	Programmer svyat = new Programmer(304, "Svyat", skils3, 25390);
	Programmer david = new Programmer(305, "David", skils1, 20390);

	@Before
	public void setUp() throws Exception {
		programmers = new HashMap<>();
		s = new ProgrammersMaps(programmers);

		s.addProgrammer(svyat);
		s.addProgrammer(vika);
		s.addProgrammer(elik);
	}

	@Test
	public void testAddProgrammer() {
		assertNotEquals(true, programmers);
		assertEquals(true, s.addProgrammer(david));
		assertTrue(programmers.containsKey(305));
		assertEquals(false, s.addProgrammer(elik));
		assertEquals(false, s.addProgrammer(null));
	}

	@Test
	public void removeProgrammer() {
		assertEquals(true, s.removeProgrammer(303));
		assertEquals(false, s.removeProgrammer(303));
		assertEquals(false, s.removeProgrammer(900));
		assertEquals(false, s.removeProgrammer(-303));
	}

	@Test
	public void getProgrammerData() {
		assertEquals(svyat, s.getProgrammerData(304));
		assertEquals(vika, s.getProgrammerData(303));
		assertEquals(null, s.getProgrammerData(900));
		assertEquals(null, s.getProgrammerData(-304));
	}

	@Test
	public void addNewTechnology() {
		assertEquals(true, s.addNewTechnology(304, "java"));
		assertEquals(true, s.addNewTechnology(303, "php"));
		assertEquals(false, s.addNewTechnology(304, "php"));
		assertEquals(false, s.addNewTechnology(900, "java"));
		assertEquals(false, s.addNewTechnology(304, ""));
		assertEquals(false, s.addNewTechnology(304, "   "));
		assertEquals(false, s.addNewTechnology(-304, "java"));
		assertEquals(false, s.addNewTechnology(304, null));
	}

	@Test
	public void removeTechnology() {
		assertEquals(true, s.removeTechnology(303, "python"));
		assertEquals(true, s.removeTechnology(304, "php"));
		assertEquals(false, s.removeTechnology(900, "java"));
		assertEquals(false, s.removeTechnology(304, ""));
		assertEquals(false, s.removeTechnology(304, "   "));
		assertEquals(false, s.removeTechnology(-304, "java"));
		assertEquals(false, s.removeTechnology(304, null));
	}

	@Test
	public void getProgrammersWithTechnology() {
		List<Programmer> result = s.getProgrammersWithTechnology("php");
		assertTrue(result.contains(svyat));
		assertFalse(result.contains(elik));
		assertFalse(result.contains(vika));
		assertFalse(result.contains(null));
		assertEquals(null, s.getProgrammersWithTechnology(""));
		assertEquals(null, s.getProgrammersWithTechnology("   "));
	}

	@Test
	public void getProgrammersWithSalaries() {
		List<Programmer> result = s.getProgrammersWithSalaries(21000, 26000);
		assertTrue(result.contains(vika));
		assertTrue(result.contains(svyat));
		assertFalse(result.contains(elik));
		assertFalse(result.contains(null));
		assertEquals(null, s.getProgrammersWithSalaries(-10000, 0));
		assertEquals(null, s.getProgrammersWithSalaries(0, -10000));
		assertEquals(null, s.getProgrammersWithSalaries(10000, 500));
	}

	@Test
	public void updateSalary() {
		assertEquals(true, s.updateSalary(304, 26000));
		assertEquals(true, s.updateSalary(304, 22000));
		assertEquals(true, s.updateSalary(303, 15000));
		assertEquals(false, s.updateSalary(900, 25000));
		assertEquals(false, s.updateSalary(900, -10000));
		assertEquals(false, s.updateSalary(304, 0));
		assertEquals(false, s.updateSalary(-304, 25000));
	}
}
