package scenario1;

public class Y implements X {
	String str = "y str";

	public Y() {
	}

	public Y(String str) {
		super();
		this.str = str;
	}

	@Override
	public void action() {
		System.out.println(str);
	}

}
