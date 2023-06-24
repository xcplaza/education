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
	public boolean add(Object obj) { // добавляем в конец
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
	public boolean add(int index, Object obj) { // добавление по индексу
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
	public int lastIndexOf(Object obj) {
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

	@Override
	public void addAll(MyArray other) {
		if (other == null)
			return;
		while (other.size() + size > array.length)
			allocateArray();
		for (int i = 0; i < other.size(); i++) {
			array[size] = other.get(i);
			size++;
		}
	}

	@Override
	public void addAll(int index, MyArray other) {
		if (index < 0 || index > size || other == null)
			return;
		while (other.size() + size > array.length)
			allocateArray();
		System.arraycopy(array, index, array, index + other.size(), size - index);
		size += other.size();
		for (int i = 0; i < other.size(); i++) {
			array[index + i] = other.get(i);
		}
	}

	@Override
	public boolean removeAll(Object obj) {
		if (obj == null)
			return false;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj)) {
				remove(i);
				size = i;
			}
			return true;
		}
		return false;
	}

//	@Override
//	public void addAll(MyArray other) {
//		if (other == null)
//			return;
//		System.arraycopy(other, 0, array, size + 1, other.size);
//		size++;
//	}
//
//	@Override
//	public void addAll(int index, MyArray[] other) {
//		if (index < 0 || index > size || other == null)
//			return;
//		if (other.size >= array.length || other.size >= size) // проверили что сдивг не приведет к exception
//			allocateArray();
//		System.arraycopy(other, index, array, index + 1, size - index);
//
//	}
//
//	@Override
//	public boolean removeAll(Object obj) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
