import java.util.Iterator;

public class MyStringIteratorRevers implements Iterator<Character> {
	private StringBuilder str;
	private int size;
	private int current;

	public MyStringIteratorRevers(StringBuilder str) {
		super();
		this.str = str;
		this.size = str.length();
		this.current = size - 1;
	}

	@Override
	public boolean hasNext() {
		
		return current >= 0;
	}

	@Override
	public Character next() {
		return str.charAt(current--);
	}
	
	public void remove() {
		str.deleteCharAt(++current);
		size--;
	}

}
