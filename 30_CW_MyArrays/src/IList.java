
public interface IList {
	boolean add(Object obj); // возвращает 
	boolean add(int index, Object obj); //возвращает true если по указанному индексу есть объект
	Object get(int index); //метод возвращает объект по индексу
	int size(); // метод возвращает размер

	int indexOf(Object obj);
	int lastIndexOf(Object obj);
	boolean contains(Object obj);
	Object remove(int index);
	boolean remove(Object obj);
	Object[] toArray(); // от 0 до size
	
	void addAll(MyArray other); // из MyArray other добавить в конец MyArray (наш)
	void addAll(int index, MyArray other); // из MyArray other добавить в MyArray (наш) + сдвигаем и вставляем по index
	boolean removeAll(Object obj); // удалить все объекты(передаваемые например 10) и возвратить  true если хотя бы 1 элемент удален
}
