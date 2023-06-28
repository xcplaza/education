
public class MyIterator<T> implements java.util.Iterator<T> {
	private Object[] array;
	private int size;
	private int position;

	public MyIterator() {
	}

	public MyIterator(Object[] array, int size) {
		super();
		this.array = array;
		this.size = size;
		this.position = 0;
	}

	@Override
	public boolean hasNext() {
		return position < size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T next() {
		return (T) array[position++];
	}

}
