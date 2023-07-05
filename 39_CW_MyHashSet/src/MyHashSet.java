import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyHashSet<E> implements Set<E> {
	List<E>[] table;
	int size;
	int capacity;
	double loadFactor;

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacity, double loadFactor) {
		super();
		table = new LinkedList[capacity];
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacity) {
		super();
		table = new LinkedList[capacity];
		this.capacity = capacity;
		loadFactor = 0.75;
	}

	public MyHashSet() { // default construct (size, loadFactor)
		this(16, 0.75);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		int index = getIndex(o);
		if (table[index] == null)
			return false;
		return table[index].contains(o);
	}

	private int getIndex(Object o) {
		int hash = o.hashCode();
		return Math.abs(hash) % capacity;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int arrayIndex = 0;
			int listIndex = 0;
			int totalCount = 0;

			@Override
			public boolean hasNext() {
				return totalCount < size;
			}

			@Override
			public E next() {
				while (table[arrayIndex] == null || table[arrayIndex].isEmpty()) {
					arrayIndex++;
				}
				E res = table[arrayIndex].get(listIndex);
				totalCount++;
				if (listIndex < table[arrayIndex].size() - 1) {
					listIndex++;
				} else {
					listIndex = 0;
					arrayIndex++;
				}
				return res;
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] res = new Object[size];
		int index = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null || table[i].isEmpty()) {
				continue;
			}
			for (Object o : table[i]) {
				res[index] = o;
				index++;
			}
		}
		return res;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		if (contains(e))
			return false;
		if (capacity * loadFactor < size) {
			recreation();
		}
		int index = getIndex(e);
		if (table[index] == null)
			table[index] = new LinkedList<>();
		table[index].add(e);
		size++;
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void recreation() {
		capacity += 16;
		LinkedList[] temp = new LinkedList[capacity];
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null)
				continue;
			for (E obj : table[i]) {
				int index = getIndex(obj);
				if (temp[index] == null)
					temp[index] = new LinkedList<>();
				temp[index].add(obj);
			}
		}
	}

	@Override
	public boolean remove(Object o) {
		if (!contains(o))
			return false;
		int index = getIndex(o);
		table[index].remove(o);
		size--;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object obj : c) {
			if (!contains(obj))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		int oldSize = size;
		for (E element : c) {
			add(element);
		}
		return oldSize < size;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		int oldSize = size;
		MyHashSet<E> temp = new MyHashSet<>();
		for (E e : this) {
			if (c.contains(e))
				temp.add(e);
		}
		clear();
		addAll(temp);
		return oldSize != size;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		int oldSize = size;
		MyHashSet<E> temp = new MyHashSet<>();
		for (E e : this) {
			if (!c.contains(e))
				temp.add(e);
		}
		clear();
		addAll(temp);
		return oldSize != size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		table = new LinkedList[capacity];
		size = 0;
	}

}
