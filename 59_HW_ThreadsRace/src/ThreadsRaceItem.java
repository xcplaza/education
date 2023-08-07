import telran.view.InputOutput;
import telran.view.Item;

public abstract class ThreadsRaceItem implements Item {
	protected InputOutput inOut;
	protected ThreadsGame threadsGame;

	public ThreadsRaceItem(InputOutput inOut, ThreadsGame threadsGame) {
		super();
		this.inOut = inOut;
		this.threadsGame = threadsGame;
	}

}
