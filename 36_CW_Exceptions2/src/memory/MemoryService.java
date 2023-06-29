package memory;

import javax.naming.directory.InvalidSearchControlsException;

public class MemoryService {
	public static int getMaxAvailableMemory() {

		Integer size = Integer.MAX_VALUE;

//		while (true) {
//			try {
//				byte[] array = new byte[size];
//				return size;
//			} catch (OutOfMemoryError e) {
//				size--;
//			}
//		}

		int min = 1;
		int max = Integer.MAX_VALUE;
		int middle = 0;

		while (min <= max) {
			middle = (int) (((long) min + max) / 2);
			try {
				byte[] array = new byte[middle];
				size = middle;
				min = middle + 1;
			} catch (OutOfMemoryError e) {
				max = middle - 1;
			}
		}
		return size;
	}
}
