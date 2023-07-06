package telran.employees.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import telran.employees.dto.Programmer;

public class ProgrammerTest {
	Map<Integer, Programmer> programmers;
	ProgrammersMaps s;

	@Before
	public void setUp() throws Exception {
		programmers = new HashMap<>();
		s = new ProgrammersMaps(programmers);
	}

	String[] skils1 = { "java", "c++", "pyton", "kotlin" };
	String[] skils2 = { "java", "pyton", "kotlin" };
	String[] skils3 = { "java", "c++", "pyton", "kotlin", "php" };

	Programmer elik = new Programmer(302, "Elik", skils1, 3000);
	Programmer vika = new Programmer(303, "Vika", skils2, 3000);
	Programmer svyat = new Programmer(304, "Svyat", skils3, 3000);
	Programmer nul = new Programmer(0, null, null, 0);

	@Test
	public void testAddProgrammer() {
		assertEquals(true, s.addProgrammer(elik));
		assertEquals(true, s.addProgrammer(vika));
		assertEquals(true, s.addProgrammer(svyat));
		assertEquals(true, s.addProgrammer(nul));
		System.out.println(programmers.toString());
	}

	@Test
	public void removeProgrammer() {
		assertEquals(true, s.removeProgrammer(302));
		System.out.println(programmers.toString());
	}

	@Test
	public void getProgrammerData() {
		System.out.println(s.getProgrammerData(303));
	}

}
