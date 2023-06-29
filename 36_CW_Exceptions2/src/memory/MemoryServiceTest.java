package memory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemoryServiceTest {

	@Test
	void testMemory() {
		int size = MemoryService.getMaxAvailableMemory();
		System.out.println(size / 1024 / 1024);
		byte[] array = new byte[size];
		boolean flag = false;

		array = null;
		try {
			array = new byte[size + 1];
		} catch (OutOfMemoryError e) {
			flag = true;
		}
		assertTrue(flag);
	}

	@Test
	void testJVM() {
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.freeMemory() / 1024 / 1024);
		System.out.println(runtime.maxMemory() / 1024 / 1024);
		System.out.println(runtime.totalMemory() / 1024 / 1024);
//		runtime.gc(); //garbage collector
		System.out.println("Ver: " + runtime.version());
	}

}
