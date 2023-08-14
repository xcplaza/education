
public class MessageAppl {
	private static final int N_PRODUCERS = 2000;
	private static final int N_CONSUMER = 10;

	public static void main(String[] args) throws InterruptedException {
		MessageBox box = new MessageBox();
		Producer[] producers = new Producer[N_PRODUCERS];
		Consumer[] consumers = new Consumer[N_CONSUMER];

		launchProducers(producers, box);
		launchConsumers(consumers, box);

		waitProducers(producers);
//		Thread.sleep(100);
		stopConsumers(consumers);
	}

	private static void stopConsumers(Consumer[] consumers) {
		for (int i = 0; i < consumers.length; i++) {
//			consumers[i].running = false;
			consumers[i].interrupt();
		}
	}

	private static void waitProducers(Producer[] producers) {
		for (int i = 0; i < producers.length; i++) {
			try {
				producers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void launchConsumers(Consumer[] consumers, MessageBox box) {
		for (int i = 0; i < consumers.length; i++) {
			consumers[i] = new Consumer(box);
			consumers[i].start();
		}
	}

	private static void launchProducers(Producer[] producers, MessageBox box) {
		for (int i = 0; i < producers.length; i++) {
			producers[i] = new Producer(box);
			producers[i].start();
		}
	}

}
