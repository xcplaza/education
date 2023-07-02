import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class ListsTest {
	Integer[] array = { 1, 2, 3, 4, 5, 6, 1, 10, 1, 20 };
//	Integer[] array2 = { 10, 1, 20, 30, 40, 50 };
	List<Integer> list;

	@Before
	public void setUp() throws Exception {
//		list = new ArrayList<>(Arrays.asList(array));
		list = new LinkedList<>(Arrays.asList(array));
	}

	@Test
	public void testToArray() {
		Object[] temp = list.toArray();
		assertArrayEquals(temp, array);

		Integer[] temp2 = list.toArray(new Integer[0]);
		assertArrayEquals(temp2, array);
	}

	@Test
	public void testClear() {
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testAdd() {
		assertTrue(list.add(100));
		list.add(0, 200);
		assertEquals((Integer) 200, list.get(0));
	}

	@Test
	public void testSubList() {
		List<Integer> temp = list.subList(2, 4);
		temp.remove((Integer) 3);
		assertFalse(list.contains(3));
		List<Integer> second = new ArrayList<>(list.subList(0, 3));
		assertTrue(second.add(9000));
		assertFalse(list.contains(9000));
		assertTrue(second.contains(9000));
	}

	@Test
	public void testNotSupport() {
		List<Integer> temp = Arrays.asList(1, 2, 3);
		assertEquals(3, temp.size());
		assertTrue(temp.contains(1));
		assertEquals((Integer) 1, temp.get(0));
		try {
			temp.remove((Integer) 1);
			fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void testRemove() {
		assertTrue(list.remove((Integer) 2));
		assertFalse(list.contains(2));
	}

	@Test
	public void testRemoveAll() {
		assertTrue(list.removeAll(Arrays.asList(1, 30, 5, 6)));
		assertFalse(list.contains(1));
		assertFalse(list.contains(5));
	}

	@Test
	public void testRetainAll() { // оставь только
		assertTrue(list.retainAll(Arrays.asList(1, 4, 5, 6)));
		assertTrue(list.contains(4));
		assertTrue(list.contains(1));
		assertFalse(list.contains(20));
		assertEquals(6, list.size());
	}

	@Test
	public void testContainsAll() {
		assertTrue(list.containsAll(Arrays.asList(1, 2, 20, 3, 4)));
		assertFalse(list.containsAll(Arrays.asList(1, 2, 20, 3, 4, 100500)));
	}

}
