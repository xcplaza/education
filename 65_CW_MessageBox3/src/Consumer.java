
public class Consumer extends Thread {
	MessageBox box;
//	volatile public boolean running = true;

	public Consumer(MessageBox box) {
		super();
		this.box = box;
//		setDaemon(true);
	}

	@Override
	public void run() {
		while (true) {
			String message;
			try {
				message = box.take();
				printMessage(message);
			} catch (InterruptedException e) {
				message = box.pull();
				if (message != null)
					printMessage(message);
				break;
			}

		}
	}

	private void printMessage(String message) {
		System.out.printf("threads %s, id: %d, message: %s\n", getName(), threadId(), message);
	}
}
