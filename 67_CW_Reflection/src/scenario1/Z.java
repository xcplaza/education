package scenario1;

public class Z implements X {
	String str = "z str";

	public Z() {
	}

	public Z(String str) {
		super();
		this.str = str;
	}

	@Override
	public void action() {
		System.out.println(str);
	}

}
