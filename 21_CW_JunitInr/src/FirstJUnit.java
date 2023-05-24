import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstJUnit {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// выполняется 1 раз перед всего тестом (для воссоздания среды)
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// выполняется 1 раз по окончанию всего тестом
		System.out.println("AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		// выполняется перед каждым методом (позитивный и негативный метод)
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		// выполняется после каждого тестового метода
		System.out.println("After");
	}

	@Test
	public void test() {
		System.out.println("Test1");
//		fail("Not yet implemented"); - метод при падении
	}

	@Test
	public void test2() {
		System.out.println("Test2");
	}

	@Test
	public void test3() {
		System.out.println("Test3");
	}
}
