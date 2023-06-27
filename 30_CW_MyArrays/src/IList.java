import java.util.function.Predicate;

public interface IList<T> {
	
	boolean add(T obj); // возвращает 
	boolean add(int index, T obj); //возвращает true если по указанному индексу есть объект
	T get(int index); //метод возвращает объект по индексу
	int size(); // метод возвращает размер

	int indexOf(T obj);
	int lastIndexOf(T obj);
	boolean contains(T obj);
	T remove(int index);
	boolean remove(T obj);
	Object[] toArray(); // от 0 до size
	
	void addAll(MyArray<T> other); // из MyArray other добавить в конец MyArray (наш)
	void addAll(int index, MyArray<T> other); // из MyArray other добавить в MyArray (наш) + сдвигаем и вставляем по index
	boolean removeAll(T obj); // удалить все объекты(передаваемые например 10) и возвратить  true если хотя бы 1 элемент удален
	
	boolean removeIf(Predicate<T> pred); // удалит все элементы из массива равные predicate
	int indexOf(Predicate<T> pred); //индекс первого встреченного элемента, если элемента нет то - 1
	int lastIndexOf(Predicate<T> pred);  //индекс последнего встреченного элемента, если элемента нет то - 1
}
