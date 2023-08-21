
public class X {
	@A2("Hello world") // - String value(); in A2 annotation!
	int x;
	int y;

	@A2(value = "Bye", number = 10, unique = false)
	String c;

	public X(int x, int y, String c) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
	}

}
