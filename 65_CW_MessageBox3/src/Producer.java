
public class Producer extends Thread {
	MessageBox box;

	public Producer(MessageBox box) {
		super();
		this.box = box;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
			box.put("message " + i);
		}
	}
}
