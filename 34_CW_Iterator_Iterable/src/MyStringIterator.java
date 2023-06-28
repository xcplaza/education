import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {
	private StringBuilder str;
	private int size;
	private int current;

	public MyStringIterator(StringBuilder str) {
		super();
		this.str = str;
		size = str.length();
		current = 0;
	}

	@Override
	public boolean hasNext() { // можно ли продолжать итерацию
		return current < size;
	}

	@Override
	public Character next() { // возвращает элемент на котором находится и делает шаг вперед
		return str.charAt(current++);
	}

	public void remove() {
		str.deleteCharAt(--current);
		size--;
	}

}
