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
		array[size] = obj;
		size++;
		return true;
	}

	private void allocateArray() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public boolean add(int index, Object obj) {
		if (index < 0 || index > size || obj == null)
			return false;
		if (index == size)
			return add(obj);
		if (size == array.length) // проверили что сдивг не приведет к exception
			allocateArray();
		System.arraycopy(array, index, array, index + 1, size - index); // сдвиг
		array[index] = obj;
		size++;
		return true;
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index >= size)
			return null;
		return array[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(Object obj) {
		if (obj == null)
			return -1;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj))
				return i;
		}
		return -1;
	}

	@Override
	public int lastInsdexOf(Object obj) {
		if (obj == null)
			return -1;
		for (int i = size - 1; i >= 0; i--) {
			if (array[i].equals(obj))
				return i;
		}
		return -1;
	}

	@Override
	public boolean contains(Object obj) { // true - объект есть, false - объекта нет
		if (obj == null)
			return false;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj))
				return true;
		}
		return false;
	}

//	@Override
//	public boolean contains(Object obj) { // true - объект есть, false - объекта нет
//		return indexOf(obj) != -1;
//	}

	@Override
	public Object remove(int index) {
		if (index < 0 || index >= size)
			return null;
//		Object res = get(index);
		Object res = array[index];

		if (index < size - 1) {
			System.arraycopy(array, index + 1, array, index, size - index - 1);
		}
		size--;
		return res;
	}

	@Override
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		return remove(index) != null;
	}

	@Override
	public Object[] toArray() { // вернуть массив со значениями
		return Arrays.copyOf(array, size);
	}

}
