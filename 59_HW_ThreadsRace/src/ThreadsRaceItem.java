import telran.view.InputOutput;
import telran.view.Item;

public class ThreadsRaceItem implements Item {
	protected InputOutput inOut;

	public ThreadsRaceItem(InputOutput inOut) {
		this.inOut = inOut;
	}

	@Override
	public String displayName() {
		return "Game run";
	}

	@Override
	public void perform() {
		Integer distance = inOut.inputInteger("Enter distance");
		if (distance == null || distance <= 0)
			return;
		Thread[] threads = new Thread[distance];

		for (int i = 0; i < distance; i++) {
			ThreadsGame game = new ThreadsGame(i + 1, distance);
			threads[i] = new Thread(game);
			threads[i].start();
		}

		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}