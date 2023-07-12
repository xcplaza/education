
public class MySingleTone {
	public static final MySingleTone ISTANCE = new MySingleTone();

	private MySingleTone() {
		System.out.println("Object created");
	}

	public void dispaly() {
		System.out.println("I am a singletone");
	}
}
