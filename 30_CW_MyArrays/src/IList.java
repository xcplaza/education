
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
	
	void addAll(MyArray other) ; // из MyArray other добавить в конец MyArray (наш)
	void addAll(MyArray other, int index) ; // из MyArray other добавить в MyArray (наш) + сдвигаем и вставляем по index
	boolean removeAll(Object obj); // удалить все объекты(передаваемые например 10) и возвратить  true если хотя бы 1 элемент удален
}
