package telran.mystring;
import java.util.Iterator;

public class MyString implements Iterable<Character> {
	private StringBuilder str;

	public MyString(String str) {
		super();
		this.str = new StringBuilder(str);
	}

	public String getStr() {
		return str.toString();
	}

	public void setStr(String str) {
		this.str = new StringBuilder(str);
	}

	public int size() {
		return str.length();
	}

	public void remove(Character c) {
		str.deleteCharAt(str.toString().indexOf(c));
	}

	@Override
	public Iterator<Character> iterator() {
		return new MyStringIterator(str);
	}

}
