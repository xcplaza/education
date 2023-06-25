import java.util.Arrays;

public class MyArray<T> implements IList<T> {
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
	public boolean add(T obj) { // добавляем в конец
		if (obj == null)
			return false;
		if (size == array.length)
			allocateArray();
		array[size] = obj;
		size++;
		return true;
	}

	private void allocateArray() { // увеличиваем массив
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public boolean add(int index, T obj) { // добавление по индексу
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

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || index >= size)
			return null;
		return (T) array[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(T obj) {
		if (obj == null)
			return -1;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj))
				return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T obj) {
		if (obj == null)
			return -1;
		for (int i = size - 1; i >= 0; i--) {
			if (array[i].equals(obj))
				return i;
		}
		return -1;
	}

	@Override
	public boolean contains(T obj) { // true - объект есть, false - объекта нет
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

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		if (index < 0 || index >= size)
			return null;
//		Object res = get(index);
		Object res = array[index];

		if (index < size - 1) {
			System.arraycopy(array, index + 1, array, index, size - index - 1);
		}
		size--;
		return (T) res;
	}

	@Override
	public boolean remove(T obj) {
		int index = indexOf(obj);
		return remove(index) != null;
	}

	@Override
	public Object[] toArray() { // вернуть массив со значениями
		return Arrays.copyOf(array, size);
	}

	@Override
	public void addAll(MyArray<T> other) {
		if (other == null || other.size() == 0)
			return;
		for (int i = 0; i < other.size; i++) {
			add(other.get(i));
		}

//		while (other.size() + size > array.length)
//			allocateArray();
//		for (int i = 0; i < other.size(); i++) {
//			array[size] = other.get(i);
//			size++;
//		}
	}

	@Override
	public void addAll(int index, MyArray<T> other) {
		if (index < 0 || index > size || other == null || other.size() == 0)
			return;
		if (index == size) {
			addAll(other);
		} else {
			shiftRight(index, other.size());
			System.arraycopy(other.array, 0, array, index, other.size());
			size += other.size();
		}
//		while (other.size() + size > array.length)
//			allocateArray();
//		System.arraycopy(array, index, array, index + other.size(), size - index);
//		size += other.size();
//		for (int i = 0; i < other.size(); i++) {
//			array[index + i] = other.get(i);
//		}
	}

	private void shiftRight(int index, int otherSize) {
		if (otherSize + size > array.length) {
			int newCapacity = Math.max(size + otherSize, array.length + CAPACITY);
			array = Arrays.copyOf(array, newCapacity);
		}
		System.arraycopy(array, index, array, index + otherSize, size - index);
	}

	@Override
	public boolean removeAll(T obj) {
		if (obj == null)
			return false;
//		==================================
//		int temp = size;
//		for (int i = size -1; i >=0; i--) {
//		if (array[i].equals(obj))
//			remove(i);
//		==================================
//		for (int i = 0; i < size; i++) {
//			if (array[i].equals(obj))
//				remove(i);
//			i--;
//		}
//		return temp != size;
//		==================================
		int count = 0;
		while (remove(obj)) {
			count++;
		}
		return count > 0;
	}
}
