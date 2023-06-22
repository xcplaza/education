import java.util.Arrays;

public class MyArray implements IList {
	private Object[] array;
	private int size = 0;
	private static final int CAPACITY = 16;

	public MyArray() {
//		array = new Object[CAPACITY];
		this(CAPACITY);
	}

	public MyArray(int capacity) {
		array = new Object[capacity];
	}

	@Override
	public boolean add(Object obj) {
		if (obj == null)
			return false;
		if (size == array.length)
			allocateArray();
		array[size++] = obj;
		return true;
	}

	private void allocateArray() {
		array = Arrays.copyOf(array, array.length * 2);

	}

	@Override
	public boolean add(int index, Object obj) {
		
		return false;
	}

	@Override
	public Object get(int index) {
		
		return null;
	}

	@Override
	public int size() {
		return size;
	}

}
