
public interface IList {
	boolean add(Object obj);
	boolean add(int index, Object obj);
	Object get(int index);
	int size();

	int indexOf(Object obj);
	int lastInsdexOf(Object obj);
	boolean contains(Object obj);
	Object remove(int index);
	boolean remove(Object obj);
	Object[] toArray(); // от 0 до size
}
