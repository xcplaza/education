
public class MySingleTone2 {
	private static MySingleTone2 instance;

	private MySingleTone2() {
		System.out.println("Object created");
	}

	public static MySingleTone2 getInstance() {
		if (instance == null)
			instance = new MySingleTone2();
		return instance;
	}

	public void dispaly() {
		System.out.println("I am a singletone");
	}
}
