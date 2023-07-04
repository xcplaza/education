import java.security.DrbgParameters.Capability;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyHashSet<E> implements Set<E> {
	List<E>[] table;
	int size;
	int capacasity;
	double loadFactor;

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacasity, double loadFactor) {
		super();
		table = new LinkedList[capacasity];
		this.capacasity = capacasity;
		this.loadFactor = loadFactor;
	}

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacasity) {
		super();
		table = new LinkedList[capacasity];
		this.capacasity = capacasity;
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

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
